package libfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import modele.Commande;
import modele.Livre;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/*
Controller de l'interface du Panier
 */
public class PanierController implements Initializable {
    private Stage stage;
    private Scene scene;

    @FXML
    private ListView<String> lvArticles;

    @FXML
    private Label mtPanier;

    String retLivre;

    public void SwitchToVitrine(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("vitrine-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToCommande(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("paiement-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Récupération de la liste de livres dans le Panier du Client
        Commande articles = HelloController.getClient().getPanier();
        mtPanier.setText(String.valueOf(articles.getTotalPanier())+" €");
        List<Livre> livres = articles.getPanier();
        for (Livre livre: livres){
            retLivre = "id : "+ livre.getId()+" | Titre : "+livre.getTitre()+" | Prix : "+livre.getPrix()+" € \nDescription : "+livre.getDescription();
            lvArticles.getItems().add(retLivre);
        }
       // lvArticles.getItems().addAll(livres);
    }
}
