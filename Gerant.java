package mini_projet;

public class Gerant extends Personne {

    public Gerant(String cin, String nom, String prenom, String pass) {
        super(cin, nom, prenom, pass);
    }

    public void consulter_comptes(Client client) {
        System.out.println(client.toString());
        for (Compte compte : client.getComptes()) {
            System.out.println("Reference Compte: " + compte.getRef_compte() + ", Balance: " + compte.getBalance());
        }
    }

}
