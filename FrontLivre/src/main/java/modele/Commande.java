package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
    Panier d'un client, rataché à son ID pour le retrouver
 */
public class Commande implements Serializable {

    private List<Livre> panier = new ArrayList<Livre>();

    public Commande(List<Livre> panier) {
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

    public double getTotalPanier(){
        double res = 0;
        for (Livre l: panier) {
            res += l.getPrix();
        }
        return res;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "panier=" + panier +
                '}';
    }

}
