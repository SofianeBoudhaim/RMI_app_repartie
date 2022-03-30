package libfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Client;
import modele.Commande;
import rmiInterface.BanqueService;

import java.io.IOException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PaimentController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField inputPass;

    @FXML
    private Label retourFalse;

    @FXML
    private Label mtAchat;

    @FXML
    private TextField inputName;

    //Récupération du client et sa commande
    Client client = HelloController.getClient();
    Commande commande = HelloController.getClient().getPanier();

    //Bouton pour procédé au paiement
    @FXML
    void ControlPaiement(ActionEvent event) throws IOException, NotBoundException, SQLException {
        //Appel BanqueService pour tester de se connecter
        BanqueService banqueService = (BanqueService) Naming.lookup("rmi://localhost:5099/Banque");
        boolean banqueConnect = banqueService.verifierConnexion(inputName.getText(), inputPass.getText());
        System.out.println(banqueConnect);
        if (banqueConnect){
            //Appel de la méthode pour vérifier le solde
            boolean testSolde = banqueService.verifierSolde(inputName.getText(), inputPass.getText(), client.getTotalPanier());
            System.out.println();
            if (testSolde){
                //Appel de la méthode pour procéder au paiement
                banqueService.payer(inputName.getText(), inputPass.getText(), commande);
                System.out.println("Paiement effectué de "+commande.getTotalPanier()+ " €" );
                Parent root = FXMLLoader.load(getClass().getResource("command-view.fxml"));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                //Message d'erreur si solde insufissant
                retourFalse.setText("Solde insufissant compte : "+inputName.getText());
                System.out.println("Solde insufissant pour régler "+commande.getTotalPanier()+" €, sur le compte "+ inputName.getText());
            }
        }else {
            //Message d'erreur si mauvais login
            retourFalse.setText("Connexion refusée");
            System.out.println("Probleme d'identification");

        }
    }

    @FXML
    void SwitchToPanier(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("panier-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       inputName.setText(client.getPrenom()+client.getNom());
       mtAchat.setText(String.valueOf(client.getPanier().getTotalPanier()) + " €");
        //récupère le montant du paiement
    }
}
