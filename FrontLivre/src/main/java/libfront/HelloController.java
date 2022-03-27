package libfront;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Client;
import rmiInterface.ClientService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.EventListener;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label retourNull;

    @FXML
    private TextField inputpass;

    @FXML
    private TextField inputname;

    @FXML
    private TextField inputboutique;


    @FXML
    private ListView<String> lvBoutiques;

    @FXML
    void controlClient(ActionEvent event) throws MalformedURLException, NotBoundException, RemoteException {
        ClientService clientService = (ClientService) Naming.lookup("rmi://localhost:5099/Client");
        try {
            Client response = clientService.getClientByMail(inputname.getText());
            System.out.println(inputname.getText() + " a pour user " + response);
            if (response != null){
                Parent root = FXMLLoader.load(getClass().getResource("vitrine-view.fxml"));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                retourNull.setText("Mauvais ID");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void SwitchToStart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void SwitchToVitrine(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("vitrine-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToUsers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("user-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    String[] book = {"cool", "breef", "trois"};
    String choixBoutique;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lvBoutiques.getItems().addAll(book);
        lvBoutiques.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
               choixBoutique = lvBoutiques.getSelectionModel().getSelectedItem();
                inputboutique.setText(choixBoutique);
            }
        });
    }
}