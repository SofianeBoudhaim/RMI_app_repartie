package client;

import modele.*;
import rmiInterface.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException, SQLException {

        LivreService livreService = (LivreService) Naming.lookup("rmi://localhost:5099/Librairie");

        List<Livre> list = livreService.getLivres();
        System.out.println(list);

        Livre lll = new Livre("test", 12);
        livreService.ajouterLivre(lll);
        list = livreService.getLivres();
        System.out.println(list);


    }
}
