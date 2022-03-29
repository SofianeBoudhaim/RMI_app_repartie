package libfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import modele.Client;
import modele.Commande;
import modele.Livre;
import rmiInterface.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.*;

/*
Controller de l'interface Vitrine concernant la Liste des Livres
 */
public class VitrineController implements Initializable {
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField inputArticleID;

    @FXML
    private ListView<String> lvPanier;

    @FXML
    private ListView<String> lvLivres;

    @FXML
    private Label labMessage;

    @FXML
    private TextField inputname;

    String retLivre = null;

    //Appel de l'interface LivreService
    LivreService livreService = (LivreService) Naming.lookup("rmi://localhost:5099/Librairie");

    //récupération du client et son panier
    Client client = HelloController.getClient();
    Commande commande = client.getPanier();


    public VitrineController() throws MalformedURLException, NotBoundException, RemoteException {
    }

    //bouton pour l'ajout au panier
    @FXML
    void ajoutPanier(ActionEvent event) throws RemoteException, SQLException {
        int add = Integer.parseInt(inputArticleID.getText());
        Livre livreAdd = livreService.getLivreByID(add);
        //Recherche le livre à ajouter par ID

        List<Livre> inp = this.commande.getPanier();
        Set<Livre> distinct = new HashSet<>(inp);

        //recherche le livre par ID afin de vérifier sa disponibilité
        if (livreAdd.getQuantite()>0){
            this.client.ajouterAuPanier(livreAdd);
            System.out.println(HelloController.getClient().getPanier());
            for (Livre livre : commande.getPanier()){
                retLivre = livre.getId()+" "+livre.getTitre();
            }
            lvPanier.getItems().addAll(retLivre);
            //Affiche le livre ajouté dans la ListView panier
        } else {
            labMessage.setText( livreAdd.getTitre()+" pas disponible");
            //ou retourne un message d'erreur
        }
    }

    //bouton pour la suppression d'un article dans le panier
    @FXML
    void supprimePanier(ActionEvent event) throws RemoteException, SQLException {
        int add = Integer.parseInt(inputArticleID.getText());
        this.client.supprimerDuPanier(livreService.getLivreByID(add));
        System.out.println(HelloController.getClient().getPanier());
        labMessage.setText("Bien supprimé du panier");
    }

    public void SwitchToPanier(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("panier-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resource) {
        try {
            inputname.setText( HelloController.getClient().getMail());

            //Récupération de la Liste des Livres de LivreService
            List<Livre> livres = livreService.getLivres();
            for (Livre l :livres){
                if (l.getQuantite()>=0){
                    retLivre = "id :"+ l.getId() + " | Titre : "+l.getTitre()+" | Prix : "+l.getPrix()+" € | Quantité : "+l.getQuantite()+"\nDescription : "+l.getDescription();
                }else {
                    retLivre = "id :"+ l.getId() + " | Titre : "+l.getTitre()+" | Prix : "+l.getPrix()+" € | Quantité : Pas disponible \nDescription : "+l.getDescription();
                }
                //Ajout à la ListView des Livres
                lvLivres.getItems().add(retLivre);
            }

            //Ajout des livres dans le panier dans la ListView Panier
            for (Livre livre : commande.getPanier()){
                retLivre = livre.getId()+" "+livre.getTitre();
                lvPanier.getItems().addAll(retLivre);
            }
        } catch (SQLException | RemoteException e) {
            e.printStackTrace();
        }

    }
}
