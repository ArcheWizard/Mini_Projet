package Mini_Projet;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Client{
    
    private String cin;
    private String nom;
    private String prenom;
    private String pass;
    private List<Compte> comptes;


    public Client(String cin, String nom, String prenom, String pass){
        this.cin=cin;
        this.nom=nom;
        this.prenom=prenom;
        this.pass=pass;
        this.comptes = new ArrayList<>();
    }
    
    public String getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPass() {
        return pass;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public Compte getCompte(String refcompte){
        for (int i = 0; i < comptes.size(); i++){
            Compte compte = comptes.get(i);
            if (compte.getRef_compte()==refcompte){
                return compte;
            }
        }
        return null;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void demande_ajout_compte()
    {
        /*
         * This is gonna add a request to the requests table in the database, from which the manager will access and will either approve that request, or deny it.
         */
    }

    public void demande_supp_compte(String refcompte){
        /*
         * This is gonna add a request to the requests table in the database, from which the manager will access and will either approve that request, or deny it.
         */
    }

    public void consulter_compte(String ref_compte)
    {
        Compte compte = getCompte(ref_compte);
        System.out.println(compte.toString());   
    }

    public String toString() {
        return "Mr/Mme "+getPrenom()+" "+getNom()+". ";
    }
    
}
