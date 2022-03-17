package DBConnect;

import modele.Livre;
import DBConnect.Connexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DBConnect.Connexion.createConnexion;

public class LivreBDD {

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

    public static void ajouterLivre(Livre livre) throws SQLException {
        //liste de tout les livres


        Connection connection = createConnexion();
        PreparedStatement st = connection.prepareStatement("INSERT INTO livre VALUES (?, ?, ?, ?)") ;
        st.setInt(1, livre.getId());
        st.setString(2, livre.getTitre());
        st.setDouble(3, livre.getPrix());
        st.setInt(4, 1);

        st.executeUpdate();
        st.close();

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
