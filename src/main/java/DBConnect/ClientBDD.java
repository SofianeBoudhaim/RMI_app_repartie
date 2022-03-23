package DBConnect;

import modele.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static DBConnect.Connexion.createConnexion;

public class ClientBDD {

    public static List<Client> getClients() throws  SQLException{
        //retourne tout les clients
        String qry = "SELECT * FROM client";
        List<Client> c = new ArrayList<Client>();

        Connection connection = createConnexion();
        Statement statement = null;
        ResultSet resultSet = null;

        statement = connection.createStatement();
        resultSet = statement.executeQuery(qry);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            String mail = resultSet.getString("mail");
            String password = resultSet.getString("password");
            c.add(new Client(id, nom, prenom, mail, password));
        }
        connection.close();
        statement.close();
        resultSet.close();
        return c;
    }


    public static Client getClientID(int id) throws SQLException {
        String qry = "SELECT * FROM client WHERE id =" + id;
        Client c = null;

        Connection connection = createConnexion();
        Statement statement = null;
        ResultSet resultSet = null;

        statement = connection.createStatement();
        resultSet = statement.executeQuery(qry);
        if (resultSet.next()) {
            do {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String password = resultSet.getString("decouvert");
                String mail = resultSet.getString("mail");
                c = new Client(id, nom, prenom, mail, password);
            }
            while (resultSet.next());
        }
        connection.close();
        statement.close();
        resultSet.close();
        return c;
    }

    public static Client getClientByMail(String email) throws SQLException {
        //liste de tout les boutiques
        String qry = "SELECT * FROM client WHERE client.mail = '" + email + "'";
        Client c = null;

        Connection connection = createConnexion();
        Statement statement = null;
        ResultSet resultSet = null;

        statement = connection.createStatement();
        resultSet = statement.executeQuery(qry);
        if (resultSet.next()) {
            do {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String password = resultSet.getString("decouvert");
                c = new Client(id, nom, prenom, email, password);
            }
            while (resultSet.next());
        }
        connection.close();
        statement.close();
        resultSet.close();
        return c;
    }


}
