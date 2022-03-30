package libfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modele.Commande;
import modele.Livre;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/*
Controller de l'interface du détail de le Commande (après paiement)
 */
public class CommandController implements Initializable {
    private Stage stage;
    private Scene scene;
    Date today = new Date();
    DateFormat dform = new SimpleDateFormat("dd/MM/yy");
    @FXML
    private Text nowdate;
    @FXML
    private ListView<String> lvArticles;
    @FXML
    private Text mtAchat;

    String retLivre;

    public void SwitchToStart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String strDate = "Commande du "+dform.format(today);
        //Initialisation de la commande du client et des livres contenus
        Commande client = HelloController.getClient().getPanier();
        List<Livre> livres = client.getPanier();
        System.out.println(strDate);
        //Ajout des livres achetés dans la ListView
        for (Livre livre: livres){
            retLivre="id : "+livre.getId()+" | Titre : "+ livre.getTitre()+" | Prix : "+livre.getPrix()+" €\nDescription : "+livre.getDescription();
            lvArticles.getItems().add(retLivre);
        }
       // lvArticles.getItems().addAll(livres);
        //Ajout du montant de la commande et identité
        mtAchat.setText(String.valueOf(client.getTotalPanier()));
        nowdate.setText(HelloController.getClient().getPrenom()+ " "+HelloController.getClient().getNom());
    }

}
