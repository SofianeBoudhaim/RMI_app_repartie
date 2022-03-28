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
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    Client client;
    @FXML
    private Label retourNull;

    @FXML
    private TextField inputpass;

    @FXML
    private TextField inputname;

    @FXML
    private TextField inputboutique;

    @FXML
    private TextField nomClient;
    @FXML
    private ListView<String> lvBoutiques;

    @FXML
    void controlClient(ActionEvent event) throws MalformedURLException, NotBoundException, RemoteException, SQLException {
        ClientService clientService = (ClientService) Naming.lookup("rmi://localhost:5099/Client");
        try {
<<<<<<< HEAD
            boolean res = clientService.connectionClient(inputname.getText(), inputpass.getText());
            //System.out.println(inputname.getText() + " a pour user " + response);
            if (res) {
=======
            Client response = clientService.getClientByMail(inputname.getText());
            Boolean connect = clientService.connectionClient(inputname.getText(), inputpass.getText());

            System.out.println(inputname.getText() + " a pour user " + response);
            //if (response != null) {
              if (connect.equals(true)){
>>>>>>> 4ca006b6d3337f40f0f7c4fde5d5bead2d285af4
                client = clientService.getClientByMail(inputname.getText());
                //Boolean connect = this.client.getPrenom();

                System.out.println(inputname.getText() + " a pour user " + client);
                if (client != null) {
                    Parent root = FXMLLoader.load(getClass().getResource("vitrine-view.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    retourNull.setText("Mauvais ID");
                }
            }
        } catch (SQLException | IOException e) {
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
        try {
            ClientService clientService = (ClientService) Naming.lookup("rmi://localhost:5099/Client");

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }

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