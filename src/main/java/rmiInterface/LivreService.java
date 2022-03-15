package rmiInterface;

import modele.Livre;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface LivreService extends Remote {
    List<Livre> getLivres() throws  RemoteException, SQLException;
    Livre getLivreByID(int id) throws  RemoteException, SQLException  ;
    Livre getLivreByTitre(String titre) throws  RemoteException, SQLException;
}
