package libfront;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import rmiInterface.BoutiqueService;
import rmiInterface.ClientService;
import rmiInterface.LivreService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class VitrineController implements Initializable {
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField inputArticleID;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnSupprimer;

    @FXML
    private ListView<?> lvPanier;

    @FXML
    private ListView<Livre> lvLivres;

    @FXML
    private TextField inputname;
    @FXML
    void ajoutPanier(ActionEvent event) throws MalformedURLException, NotBoundException, RemoteException, SQLException {
        ClientService clientService = (ClientService) Naming.lookup("rmi://localhost:5099/Client");
        LivreService livreService = (LivreService) Naming.lookup("rmi://localhost:5099/Librairie");
        //Livre l = livreService.getLivreByTitre(inputArticleID.getText());
        Client cli = clientService.getClientByMail(inputname.getText());
        //cli.ajouterPanier(livreService.getLivreByID(inputArticleID.getPrefColumnCount()));
        int add = Integer.parseInt(inputArticleID.getText());
        cli.ajouterPanier(livreService.getLivreByID(add));
        System.out.println(cli.getPanier());
    }

    @FXML
    void supprimePanier(ActionEvent event) {

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
            LivreService livreService = (LivreService) Naming.lookup("rmi://localhost:5099/Librairie");
            List<Livre> livres = livreService.getLivres();
            for (Livre l :livres){
                lvLivres.getItems().add(l);
            }
           // lvLivres.getItems().addAll(livreService.getLivres());
        } catch (NotBoundException | SQLException | RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
