package libfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PanierController {
    private Stage stage;
    private Scene scene;


    public void SwitchToVitrine(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("vitrine-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void SwitchToPaiement(ActionEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("paiement-dialog.fxml"));
        //Parent root = fxmlLoader.load();
        // PaimentController paieController = fxmlLoader.<PaimentController>getController();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        // stage.initModality(Modality.APPLICATION_MODAL);
        scene = new Scene(root);

        // Scene scene = new Scene(parent, 300, 200);
        // Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


    public void SwitchToCommande(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("command-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
