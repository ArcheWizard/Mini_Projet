package mini_projet;

public class Gerant {

    private String cin;
    private String nom;
    private String prenom;
    private String pass;
    

    public Gerant(String cin, String nom, String prenom, String pass){
        this.cin=cin;
        this.nom=nom;
        this.prenom=prenom;
        this.pass=pass;
    }

    public Gerant(String cin, String pass){
        this.cin=cin;
        this.pass=pass;
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

    public String  getcin(){
        return cin;
    }

    public void setnom(String nom){
        this.nom = nom;
    }

    public void setprenom(String prenom){
        this.prenom=prenom;
    }

    public void setCin(String cin){
        this.cin = cin;
    }

    public void setpass(String pass){
        this.pass =pass;
    }

     
    public void consulter_comptes(Client client){
        System.out.println(client.toString());
        for (Compte compte : client.getComptes()) {
            System.out.println("Reference Compte: " + compte.getRef_compte() + ", Balance: " + compte.getBalance());
        }
    }

}
