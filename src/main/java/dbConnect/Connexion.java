package dbConnect;

import java.sql.*;

public class Connexion {
    //private static String URL = "jdbc:sqlite:D:\\LP GL\\_STN\\RMI_app_repartie\\src\\main\\resources\\librairie.db";
<<<<<<< HEAD:src/main/java/dbConnect/Connexion.java
     private static String URL = "jdbc:sqlite:C:\\Users\\sofia\\Desktop\\projects\\flutter\\rmi\\RMI_app_repartie\\src\\main\\resources\\librairie.db";
    //private static String URL = "jdbc:sqlite:../../../../resources/librairie.db";
=======
    private static String URL = "jdbc:sqlite:D:\\LP GL\\_STN\\RMI_app_repartie\\src\\main\\resources\\librairie.db";
    //private static String URL = "jdbc:sqlite:librairie.db";
>>>>>>> 4ca006b6d3337f40f0f7c4fde5d5bead2d285af4:src/main/java/DBConnect/Connexion.java
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

}  