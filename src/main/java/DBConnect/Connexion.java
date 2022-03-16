package DBConnect;

import modele.Livre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connexion {
    private static String URL = "jdbc:sqlite:D:\\LP GL\\_AppRep\\dev\\RMI_app_repartie\\src\\main\\resources\\librairie.db";
    //private static String URL = "jdbc:sqlite:librairie.db";
    private static String DRIVER = "org.sqlite.JDBC";

    public static Connection createConnexion() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static List<Livre> getLivres() throws SQLException {
        //liste de tout les livres
        String qry = "SELECT * FROM livre";
        List<Livre> l = new ArrayList<Livre>();

        Connection connection = createConnexion();
        Statement statement = null;
        ResultSet resultSet = null;

        statement = connection.createStatement();
        resultSet = statement.executeQuery(qry);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String titre = resultSet.getString("titre");
            double prix = resultSet.getDouble("prix");
            l.add(new Livre(id, titre, prix));
        }
        connection.close();
        statement.close();
        resultSet.close();
        return l;
    }

    // Retourne un livre selon son ID, retourne null si aucun livre ne correspond
    public static Livre getLivreById(int id) throws SQLException {
        String qry = "SELECT * FROM livre WHERE id=" + id;
        Livre l = null;

        Connection connection = createConnexion();
        Statement statement = null;
        ResultSet resultSet = null;

        statement = connection.createStatement();
        resultSet = statement.executeQuery(qry);

        if(resultSet.next()) {
            do {
                String titre = resultSet.getString("titre");
                double prix = resultSet.getDouble("prix");
                l = new Livre(id, titre, prix);
            } while (resultSet.next());
        }
        connection.close();
        statement.close();
        resultSet.close();
        return l;
    }

    public static Livre getLivreByTitre(String titre) throws SQLException {
        String qry = "SELECT * FROM livre WHERE titre=" + titre;
        Livre l = null;

        Connection connection = createConnexion();
        Statement statement = null;
        ResultSet resultSet = null;

        statement = connection.createStatement();
        resultSet = statement.executeQuery(qry);

        if(resultSet.next()) {
            do {
                int id = resultSet.getInt("id");
                double prix = resultSet.getDouble("prix");
                l = new Livre(id, titre, prix);
            } while (resultSet.next());
        }
        connection.close();
        statement.close();
        resultSet.close();
        return l;
    }

}  