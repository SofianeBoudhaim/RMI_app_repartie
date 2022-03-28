package rmiServer;

import DBConnect.BanqueBDD;
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
        return BanqueBDD.getConnectionBanque(codeIdentifiant, password);
    }

    @Override
    public boolean verifierSolde(String codeIdentifiant, String password, double cout) throws RemoteException, SQLException {
        return BanqueBDD.soldeSuffisante(codeIdentifiant, password, cout);
    }

    @Override
    public void payer(String codeIdentifiant, String password, double cout) throws RemoteException, SQLException {
         BanqueBDD.payer(codeIdentifiant, password, cout);
    }
}
