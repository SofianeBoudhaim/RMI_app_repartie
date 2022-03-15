import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

import DBConnect.*;
import modele.Livre;

import static DBConnect.Connexion.createConnexion;


public class Main {
    public static void main(String[] args) throws SQLException {

        List<Livre> l = DBConnect.Connexion.getLivres();
        Livre l1 = DBConnect.Connexion.getLivreById(3);

        /*
        for (Livre livre : l) {
            System.out.println(livre.toString());
        }
         */

        if(l1!=null){
            System.out.println(l1);
        }else{
            System.out.println("Pas de livre avec cet ID");
        }
    }
}
