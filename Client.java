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
    private float salaire_anuelle;


    public Client(String nom, String prenom, String cin, float salaire_anuelle){
        this.nom=nom;
        this.prenom=prenom;
        this.pass=generer_pass(this.nom, this.prenom, this.cin);
        this.cin=cin;
        this.comptes = new ArrayList<>();
        this.salaire_anuelle=salaire_anuelle;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCin() {
        return cin;
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

    public float getSalaire_anuelle() {
        return salaire_anuelle;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSalaire_anuelle(float salaire_anuelle) {
        this.salaire_anuelle = salaire_anuelle;
    }

    public boolean is_client_password_valid(String pass){

        if (this.pass==pass){
            return true;
        }

        else{
            return false;
        }
        
    }

    public String generer_pass(String nom, String prenom, String cin){

        String pass = "";
        Random random = new Random();
        int rand = random.nextInt(1,5);
        String full_id=nom+prenom+cin;
		int Length = full_id.length();


		for(int i=0;i<Length;i=i+rand)
		{
            rand = random.nextInt(1,5);
			if(nom.charAt(i)!=' '){
			    pass+=full_id.charAt(i);
			}
		}

        return pass;

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
