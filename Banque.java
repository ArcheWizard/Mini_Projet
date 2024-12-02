package mini_projet;

import java.util.ArrayList;
import java.util.List;

public class Banque{

    private List<Client> clients;
    private List<Gerant> gerants;

    public Banque() {
        this.clients = new ArrayList<>();
        this.gerants = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Gerant> getGerants() {
        return gerants;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setGerants(List<Gerant> gerants) {
        this.gerants = gerants;
    }

    /*public void signUpClient(){

    }

    public Client loginClient(){
        
    }

    public void addManager(){
        
    }

    public Manager getManager(){
        
    }

    public void ajouter_compte(){

    }

    public void supp_compte(){

    }*/
    
}
