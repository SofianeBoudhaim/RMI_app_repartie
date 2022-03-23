package rmiServer;

import modele.*;
import rmiInterface.ClientService;

import java.awt.dnd.DnDConstants;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

public class ServantClient extends UnicastRemoteObject implements ClientService {
    public ServantClient() throws RemoteException {
        super();
    }

    @Override
    public Client getClientByMail(String mail) throws  SQLException{
        return  DBConnect.ClientBDD.getClientByMail(mail);
    }

    @Override
    public Client getClientByID(int id) throws  SQLException {
        return DBConnect.ClientBDD.getClientID(id);
    }

    @Override
    public List<Client> getClients() throws  SQLException {
        return DBConnect.ClientBDD.getClients();
    }
}
