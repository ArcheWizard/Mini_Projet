package mini_projet;

public class Compte extends Client{

    private static int compteur=0;
    private String ref_compte;
    private double balance;
    
    public Compte(String cin, String nom, String prenom, String pass){
        super(cin, nom, prenom, pass);
        this.ref_compte=generer_ref_compte(nom,prenom,cin);
        this.balance=0.0f;
    }

    public Compte(Client client, float balance){
        super(client.getCin(), client.getPass());
        this.ref_compte=generer_ref_compte(client.getNom(),client.getPrenom(),client.getCin());
        this.balance=balance;
    }

    public String getRef_compte() {
        return ref_compte;
    }

    public double getBalance() {
        return balance;
    }

    public void setRef_compte(String ref_compte) {
        this.ref_compte = ref_compte;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String generer_ref_compte(String nom, String prenom, String cin){
        
        String ref_compte = "";
        String full_name=nom+prenom;
		int Length = full_name.length();

		for(int i=0;i<Length;i=i+5)
		{
			if(full_name.charAt(i)!=' '){
			    ref_compte+=full_name.charAt(i);
			}
		}

        String scompteur = compteur+"";

        ref_compte=ref_compte+scompteur;

        compteur+=1;

        return ref_compte;
        
    }

    public void depot(double montant){
        if (montant > 0) {
            this.balance += montant;
        } else {
            System.out.println("Invalid deposit montant!");
        }
    }

    public void retrait(double montant){
        if (montant > 0 && montant <= balance) {
            this.balance -= montant;
        } else {
            System.out.println("Invalid withdrawal montant!");
        }
    }

    public void transfer(Compte compte, double montant){
        if (montant > 0 && montant <= balance) {
            this.retrait(montant);
            compte.depot(montant);
        } else {
            System.out.println("Invalid transfer montant!");
        }
    }

    public String toString() {
        return super.toString()+"Votre compte de reference: ("+getRef_compte()+")";
    };
}
