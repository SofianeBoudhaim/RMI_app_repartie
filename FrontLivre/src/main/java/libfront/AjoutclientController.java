package libfront;

import modele.Client;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rmiInterface.ClientService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class AjoutclientController {
    @FXML
    private TextField tfNom;

    @FXML
    private TextField tfPrenom;

    @FXML
    private TextField tfMail;

    @FXML
    private TextField tfPassword;

    private ObservableList<Client> appMainObservableList;

    public void setAppMainObservableList(ObservableList<Client> tvObservableList) {
        this.appMainObservableList = tvObservableList;

    }

    @FXML
    void btnAddPersonClicked(ActionEvent event) throws MalformedURLException, NotBoundException, RemoteException, SQLException {
        System.out.println("btnAddPersonClicked");
        ClientService clientService = (ClientService) Naming.lookup("rmi://localhost:5099/Client");
        clientService.ajouterClient(new Client(tfNom.getText(),tfPrenom.getText(), tfMail.getText(),tfPassword.getText()));

        //Client data = new Client(id, name, iAge);
        //appMainObservableList.add(data);

        closeStage(event);
    }
    private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

    }
}
