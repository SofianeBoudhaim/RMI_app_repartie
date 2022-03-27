package libfront;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import rmiInterface.ClientService;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.EventListener;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws IOException, NotBoundException {


        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        //root.getChildrenUnmodifiable().addAll(btnClient);
        Scene scene = new Scene(root);
        stage.setTitle("LibraiWeb 📕✈");
        stage.setScene(scene);
        stage.show();
    }
}