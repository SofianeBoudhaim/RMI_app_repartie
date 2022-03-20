package com.example.libfront;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
Scene scene= new Scene(root);
        stage.setTitle("LibraiWeb 📕✈");
        stage.setScene(scene);
        stage.show();
    }

}