package com.example.modele;

import java.util.ArrayList;
import java.util.List;

/*
    Panier d'un client, rataché à son ID pour le retrouver
 */
public class Commande {

    private int idClient;
    private List<Livre> panier = new ArrayList<Livre>();

    public Commande(List<Livre> panier, Client client) {
        this.idClient = client.getId();
        this.panier = panier;
    }

    public Commande(){
        this.panier = new ArrayList<Livre>();
    }

    public List<Livre> getPanier() {
        return panier;
    }


    public void ajouterAuPanier(Livre livre){
        panier.add(livre);
    }

    public void supprimerDuPanier(Livre livre){
        panier.remove(livre);
    }

    @Override
    public String toString() {
        return "Commande{" +
                "panier=" + panier +
                '}';
    }

}
