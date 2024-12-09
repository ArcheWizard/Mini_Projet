package mini_projet;

public class Personne {
    private String cin;
    private String nom;
    private String prenom;
    private String pass;

    public Personne (String cin,String nom,String prenom,String pass){
        this.cin=cin;
        this.nom=nom;
        this.prenom=prenom;
        this.pass=pass;
    }

    public Personne(String cin, String pass){
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

    public void setCin(String cin){
        this.cin = cin;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom=prenom;
    }

    public void setPass(String pass){
        this.pass =pass;
    }
    
}
