package DBConnect;

import modele.Boutique;
import modele.Livre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static DBConnect.Connexion.createConnexion;

public class BoutiqueBDD {
    public static List<Boutique> getBoutiques() throws SQLException {
        //liste de tout les boutiques
        String qry = "SELECT * FROM boutique";
        List<Boutique> b = new ArrayList<Boutique>();

        Connection connection = createConnexion();
        Statement statement = null;
        ResultSet resultSet = null;

        statement = connection.createStatement();
        resultSet = statement.executeQuery(qry);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String adresse = resultSet.getString("adresse");
            b.add(new Boutique(id, nom));
        }
        connection.close();
        statement.close();
        resultSet.close();
        return b;
    }

    public static Boutique getBoutiqueByNom(String name) throws SQLException {
        //liste de tout les boutiques
        String qry = "SELECT * FROM boutique WHERE name ="+name;
        Boutique b = null;

        Connection connection = createConnexion();
        Statement statement = null;
        ResultSet resultSet = null;

        statement = connection.createStatement();
        resultSet = statement.executeQuery(qry);
        if(resultSet.next()) {
            do {
                int id = resultSet.getInt("id");
                String departement = resultSet.getString("departement");
                b = new Boutique(name, departement);
            }
        while (resultSet.next()) ;

        }
        connection.close();
        statement.close();
        resultSet.close();
        return b;
    }

}
