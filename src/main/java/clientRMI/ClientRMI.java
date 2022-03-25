package clientRMI;

import modele.*;
import rmiInterface.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class ClientRMI {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException, SQLException {

        LivreService livreService = (LivreService) Naming.lookup("rmi://localhost:5099/Librairie");
        ClientService clientService = (ClientService) Naming.lookup("rmi://localhost:5099/Client");

        List<Livre> livres = livreService.getLivres();
        System.out.println(livres);


        Client client = clientService.getClientByMail("sofiane.boudhaim@gmail.com");
        System.out.println(client);

        List<Client> clients = clientService.getClients();
        System.out.println(clients);

        client.ajouterPanier(livreService.getLivreByID(1));
        System.out.println(client.getPanier());
    }
}
