package rmiServer;

import modele.Livre;
import rmiInterface.RMIInterface;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Librairie extends UnicastRemoteObject implements RMIInterface {
    private List<Livre> listeLivres;

    protected Librairie(List<Livre> list) throws RemoteException{
        super();
        this.listeLivres = list;
    }


    @Override
    public Livre trouverLivre(Livre b) throws RemoteException {
        Predicate<Livre> predicate = x -> x.getId().equals(b.getId());
        return listeLivres.stream().filter(predicate).findFirst().get();
    }

    @Override
    public List<Livre> toutLesLivres() throws RemoteException {
        return listeLivres;
    }
    private static List<Livre> initialiserListe(){
        List<Livre> list = new ArrayList<>();
        list.add(new Livre("Head First Java, 2nd Edition", "978-0596009205", 31.41));
        list.add(new Livre("Java In A Nutshell", "978-0596007737", 10.90));
        list.add(new Livre("Java: The Complete Reference", "978-0071808552", 40.18));
        list.add(new Livre("Head First Servlets and JSP", "978-0596516680", 35.41));
        list.add(new Livre("Java Puzzlers: Traps, Pitfalls, and Corner Cases", "978-0321336781", 39.99));
        return list;
    }

    public static void main(String[] args) {
        try {
            Naming.rebind("//localhost/MyBookstore", new Librairie(initialiserListe()));
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }

}
