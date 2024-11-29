package Mini_Projet;

import java.util.List;
import java.util.Random;

public class Gerant {

    private String cin;
    private String nom;
    private String prenom;
    private String pass;
    private List<Transaction> transactions;

    public Gerant(String cin, String nom, String prenom){
        this.cin=cin;
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
    
    public void consulter_comptes(Client client){
        System.out.println(client.toString());
        for (Compte compte : client.getComptes()) {
            System.out.println("Reference Compte: " + compte.getRef_compte() + ", Balance: " + compte.getBalance());
        }
    }

}
