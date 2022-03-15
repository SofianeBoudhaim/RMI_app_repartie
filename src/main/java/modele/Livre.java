package modele;

import java.io.Serializable;

public class Livre implements Serializable {


    private String id;
    private String titre;
    private double prix;

    public Livre( String titre, String id, double prix){
        this.id = id;
        this.titre = titre;
        this.prix = prix;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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



    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", prix=" + prix +
                '}';
    }
}
