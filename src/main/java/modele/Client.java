package modele;

import java.io.Serializable;
import java.util.List;

public class Client implements Serializable {
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String password;
    private Commande panier = new Commande();
    private String compteB;
    private String passwordB;

    public Client(int id, String nom, String prenom, String mail, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.password = password;
    }

    public Client(int id, String name, String iMail) {
        this.id = id;
        this.nom = nom;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Commande getPanier(){
        return panier;
    }

    public void ajouterPanier(Livre l){
        panier.ajouterAuPanier(l);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", compteB='" + compteB + '\'' +
                ", passwordB='" + passwordB + '\'' +
                '}';
    }
}
