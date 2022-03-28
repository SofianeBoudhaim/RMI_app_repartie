package libfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Commande;
import rmiInterface.ClientService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PanierController implements Initializable {
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField inputname;

    @FXML
    void controlClient(ActionEvent event) throws MalformedURLException, NotBoundException, RemoteException {
        ClientService clientService = (ClientService) Naming.lookup("rmi://localhost:5099/Client");
        try {
            Commande response = clientService.getClientByMail(inputname.getText()).getPanier();

            System.out.println(response);

            System.out.println(response.getPanier());

            if (response != null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Test Connection");
                alert.setHeaderText("Results:");
                alert.setContentText("Connect to the database successfully!");

                alert.showAndWait();
            } else {
               // retourNull.setText("Mauvais ID");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
