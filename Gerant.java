package Mini_Projet;

import java.util.Random;

public class Gerant {

    private
        String nom;
        String prenom;
        String pass;

    
    public Gerant(){
        this.nom=null;
        this.prenom=null;
        this.pass=null;
    } 

    public Gerant(String nom, String prenom){
        this.nom=nom;
        this.prenom=prenom;
        pass=generer_pass(this.nom, this.prenom);
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

    public String generer_pass(String nom, String prenom){

        String pass = "";
        Random random = new Random();
        int rand = random.nextInt(1,5);
        String full_name=nom+prenom;
		int Length = full_name.length()+rand;


		for(int i=0;i<Length;i=i+rand)
		{
            rand = random.nextInt(1,5);
			if(nom.charAt(i)!=' '){
			    pass+=full_name.charAt(i)+(char)random.nextInt(65, 122);
			}
		}

        return pass;

    }

    public boolean is_gerant_password_valid(String pass){

        if (this.pass==pass){
            return true;
        }

        else{
            return false;
        }
        
    }
    
    public void consulter_comptes(){

    }

    public void ajouter_compte(){

    }

    public void supp_compte(){

    }

    public void set_nbr_comptes(){

    }

    public void pret(){
        
    }
}
