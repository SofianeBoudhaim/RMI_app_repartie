package rmiServer;

import modele.Livre;
import rmiInterface.LivreService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.sql.*;

//extends UnicastRemoteObject
public class ServantLivre extends UnicastRemoteObject implements LivreService {


    public ServantLivre() throws RemoteException {
        super();
    }


    @Override
    public List<Livre> getLivres() throws SQLException {
        return DBConnect.LivreBDD.getLivres();
    }

    @Override
    public Livre getLivreByID(int id) throws SQLException {
        return DBConnect.LivreBDD.getLivreById(id);
    }

    @Override
    public Livre getLivreByTitre(String titre) throws SQLException {
        return DBConnect.LivreBDD.getLivreByTitre(titre);
    }

    @Override
    public void ajouterLivre(Livre livre) throws RemoteException, SQLException {
        DBConnect.LivreBDD.ajouterLivre(livre);
    }


}
