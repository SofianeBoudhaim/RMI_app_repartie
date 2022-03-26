package com.example.modele;

import java.io.Serializable;
import java.util.HashMap;

public class Boutique implements Serializable {


    private int id;
    private String nom;
    private String adresse;
    private String departement;
    //proposition : contient l'ID d'un livre, et le stock de ce livre dans la boutique
    private HashMap<Integer, Integer> livreStock = new HashMap<>();


    public Boutique(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }


    public Boutique(String nom, String departement) {
        this.nom = nom;
        this.departement = departement;
    }
    @Override
    public String toString() {
        return "Boutique{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
