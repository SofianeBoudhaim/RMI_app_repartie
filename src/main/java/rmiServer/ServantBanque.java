package rmiServer;

import rmiInterface.BanqueService;
import rmiInterface.ClientService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class ServantBanque extends UnicastRemoteObject implements BanqueService {

    protected ServantBanque() throws RemoteException {
        super();
    }

    @Override
    public boolean verifierConnexion(String codeIdentifiant, String password) throws RemoteException, SQLException {
        return false;
    }
}
