package DBConnect;

import modele.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static DBConnect.Connexion.createConnexion;

public class BanqueBDD {

    public static boolean getConnectionBanque(String identifiant, String password, double cout) throws SQLException {
        //liste de tout les boutiques
        String qry = "SELECT * FROM banque WHERE codeIdentifiant = '" + identifiant + "' AND password = '" + password  + "'";
        Client c = null;
        Double soldeBanque = Double.parseDouble(null);

        Connection connection = createConnexion();
        Statement statement = null;
        ResultSet resultSet = null;

        statement = connection.createStatement();
        resultSet = statement.executeQuery(qry);
        if (resultSet.next()) {
            do {
                 soldeBanque = resultSet.getDouble("solde");
            }
            while (resultSet.next());
        }
        connection.close();
        statement.close();
        resultSet.close();
        if(soldeBanque != null && soldeBanque.doubleValue() >= cout){
            return true;
        }else{
            return false;
        }
    }
}
