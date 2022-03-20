import java.sql.SQLException;
import java.util.List;

import modele.Livre;


public class Main {
    public static void main(String[] args) throws SQLException {

        List<Livre> l = DBConnect.LivreBDD.getLivres();
        Livre l1 = DBConnect.LivreBDD.getLivreById(3);

        if(l1!=null){
            System.out.println(l1);
        }else{
            System.out.println("Pas de livre avec cet ID");
        }
    }
}
