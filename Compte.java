package Mini_Projet;

public class Compte extends Client{

    protected
        String ref_compte;
        enum membership{Bronze, Silver, Gold}
        membership ms;
        float balance;
    
    public Compte(String nom, String prenom, String cin, float salaire_anuelle){
        super(nom, prenom, cin, salaire_anuelle);
        this.ref_compte=generer_ref_compte(nom,prenom,cin);
        this.ms=membership.Bronze;
        this.balance=0.0f;
    }

    public String getRef_compte() {
        return ref_compte;
    }

    public membership getMs() {
        return ms;
    }

    public float getBalance() {
        return balance;
    }

    public void setRef_compte(String ref_compte) {
        this.ref_compte = ref_compte;
    }

    public void setMs(membership ms) {
        this.ms = ms;
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
			if(nom.charAt(i)!=' '){
			    ref_compte+=full_name.charAt(i);
			}
		}

        ref_compte+=cin.substring(-3);

        return ref_compte;
        
    }

    public void depot(double montant){
        if (montant > 0) {
            balance += montant;
        } else {
            System.out.println("Invalid deposit montant!");
        }
    }

    public void retrait(double montant){
        if (montant > 0 && montant <= balance) {
            balance -= montant;
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
        return super.toString()+"Votre compte de reference: ("+getRef_compte()+"). Tu as une balance de: ("+getBalance()+"DT). Votre abonnement est: ("+getMs()+").";
    }
}
