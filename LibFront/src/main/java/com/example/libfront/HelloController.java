package com.example.libfront;

import com.example.modele.Boutique;
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
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    String choixBoutique;

    @FXML
    private TextField inputpass;

    @FXML
    private TextField inputboutique;

    @FXML
    private TextField inputname;

    @FXML
    private Label welcomeText;

    @FXML
    private ListView<String> lvBoutiques;

    String[] book = {"cool", "breef", "trois"};

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
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

    public void SwitchToPanier(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("panier-view.fxml"));
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
    public void SwitchToUsers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("user-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

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