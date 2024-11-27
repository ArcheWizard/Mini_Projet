package Mini_Projet;

import java.util.ArrayList;

public class Client_Comptes{

    protected
        Client client;
        ArrayList<Compte> liste_compte;
    

    public Client_Comptes(){
        this.client= new Client(null, null, null, 0);
        this.liste_compte= new ArrayList<Compte>();
    }

    public Client_Comptes(Client client){
        this.client=client;
        this.liste_compte= new ArrayList<Compte>();
    }

    public Client_Comptes(Client client, Compte compte){
        this.client=client;
        this.liste_compte.add(compte);
    }

    public Client_Comptes(Client client, ArrayList<Compte> liste_compte){
        this.client=client;
        this.liste_compte= liste_compte;
    }
    
}
