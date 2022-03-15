package rmiInterface;

import modele.Livre;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIInterface extends Remote {
    Livre trouverLivre(Livre b) throws RemoteException;
    List<Livre> toutLesLivres() throws RemoteException;

}
