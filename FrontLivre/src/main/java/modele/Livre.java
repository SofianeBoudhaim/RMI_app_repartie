package modele;


//import java.io.Serial;
import java.io.Serializable;


//Liste des livres
public class Livre implements Serializable {


    private static final long serialVersionUID = 1190476516911661480L;
    private int id;
    private String titre;
    private double prix;
    private int quantite;

    public Livre(int id, String titre, double prix, int quantite){
        this.id = id;
        this.titre = titre;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Livre(String titre, double prix, int quantite){
        this.titre = titre;
        this.prix = prix;
        this.quantite = quantite;
    }



    public Livre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }
}
