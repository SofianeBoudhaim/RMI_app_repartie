package rmiInterface;

import modele.Client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface BanqueService extends Remote {

    boolean verifierConnexion(String codeIdentifiant, String password) throws RemoteException, SQLException;
}
