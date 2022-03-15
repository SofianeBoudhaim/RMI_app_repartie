package rmiServer;

import modele.Livre;
import rmiInterface.LivreService;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.sql.*;

//extends UnicastRemoteObject
public class Servant extends UnicastRemoteObject implements LivreService {


    public Servant() throws RemoteException {
        super();
    }


    @Override
    public List<Livre> getLivres() throws SQLException {
        return DBConnect.Connexion.getLivres();
    }

    @Override
    public Livre getLivreByID(int id) throws SQLException {
        return DBConnect.Connexion.getLivreById(id);
    }

    @Override
    public Livre getLivreByTitre(String titre) throws SQLException {
        return DBConnect.Connexion.getLivreByTitre(titre);
    }

}
