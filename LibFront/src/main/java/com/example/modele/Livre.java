package com.example.modele;

import java.io.Serial;
import java.io.Serializable;


//Liste des livres
public class Livre implements Serializable {

    @Serial
    private static final long serialVersionUID = 1190476516911661480L;
    private int id;
    private String titre;
    private double prix;

    public Livre(int id, String titre, double prix){
        this.id = id;
        this.titre = titre;
        this.prix = prix;
    }

    public Livre(String titre, double prix){
        this.titre = titre;
        this.prix = prix;
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


    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", prix=" + prix +
                '}';
    }
}
