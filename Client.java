package Mini_Projet;

import java.util.Random;

public class Client{
    
    private

        String nom;
        String prenom;
        String pass;

    protected

        String cin;
        int nb_compte;
        String status;
        float salaire_anuelle;

    
    public Client(){
        this.nom=null;
        this.prenom=null;
        this.pass=null;
        this.cin=null;
        this.salaire_anuelle=0.0f;
    }

    public Client(String nom, String prenom, String cin, float salaire_anuelle){
        this.nom=nom;
        this.prenom=prenom;
        this.pass=generer_pass(this.nom, this.prenom, this.cin);
        this.cin=cin;
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

    public int getNbCompte() {
        return nb_compte;
    }

    public String getStatus() {
        return status;
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

    public void setNbCompte(int nb_compte) {
        this.nb_compte = nb_compte;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public void demander_compte(String pass)
    {

    }

    public void consulter_compte(String ref_compte, String pass)
    {
        
    }

    public String toString() {
        return "Mr/Mme "+getPrenom()+" "+getNom()+". ";
    }
    
}
