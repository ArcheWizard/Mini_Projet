package Mini_Projet;

public class Compte extends Client{

    protected
        String ref_compte;
        enum membership{Bronze, Silver, Gold}
        membership ms;
        float balance;
        float pret;
    
    public Compte(String nom, String prenom, String cin, float salaire_anuelle){
        super(nom, prenom, cin, salaire_anuelle);
        this.ref_compte=generer_ref_compte(nom,prenom,cin,nb_compte);
        this.ms=membership.Bronze;
        this.balance=0.0f;
        this.pret=0.0f;
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

    public float getPret() {
        return pret;
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

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String generer_ref_compte(String nom, String prenom, String cin, int nb_compte){
        
        String ref_compte = "";
        String full_name=nom+prenom;
		int Length = full_name.length();

		for(int i=0;i<Length;i=i+5)
		{
			if(nom.charAt(i)!=' '){
			    ref_compte+=full_name.charAt(i);
			}
		}

        ref_compte+=cin.substring(-3)+nb_compte;

        return ref_compte;
        
    }

    public void depot(){

    }

    public void retrait(){

    }

    public void transfer(){

    }

    public void demande_supp_compte(){

    }

    public String toString(String ref_compte) {
        return super.toString()+"Votre compte de reference: ("+getRef_compte()+"). Tu as une balance de: ("+getBalance()+"DT). Votre abonnement est: ("+getMs()+"). Tu as un pret de: (-"+getPret()+"DT)";
    }
}
