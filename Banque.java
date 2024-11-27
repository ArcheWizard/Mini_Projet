package Mini_Projet;

import java.util.ArrayList;

public class Banque {
    private
        ArrayList<Client_Comptes> liste_client_comptes;
    
    public Banque(){
        this.liste_client_comptes = new ArrayList<Client_Comptes>();
    }

    public ArrayList<Client_Comptes> getListe_client_comptes() {
        return liste_client_comptes;
    }

    public void setListe_client_comptes(ArrayList<Client_Comptes> liste_client_comptes) {
        this.liste_client_comptes = liste_client_comptes;
    }
}
