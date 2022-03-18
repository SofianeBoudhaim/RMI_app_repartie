package rmiInterface;

import modele.Boutique;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

/**
 * interface de connexion
 */
public interface ClientService {

    List<Boutique> getBoutiques() throws RemoteException, SQLException;

}
