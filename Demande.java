package mini_projet;

public class Demande {
    
    private String ref_demande;
    private String cin;
    private String ref_compte;
    enum Type_Demande{
        ajout_client,
        supprime_client,
        ajout_compte,
        supprime_compte}
    private Type_Demande type_demande;

    public Demande(String ref_demande, String cin, String ref_compte, Type_Demande type_demande) {
        this.ref_demande = ref_demande;
        this.cin=cin;
        this.type_demande=type_demande;
        if (this.type_demande==Type_Demande.ajout_compte || this.type_demande==Type_Demande.supprime_compte){
            this.ref_compte=ref_compte;
        }
        else{
            this.ref_compte=null;
        }
    }

    public Demande(String ref_demande, String cin, Type_Demande type_demande) {
        this.ref_demande = ref_demande;
        this.cin=cin;
        if (this.type_demande==Type_Demande.ajout_compte || this.type_demande==Type_Demande.supprime_compte) {
            throw new IllegalArgumentException("Invalid Operation! You must specify your account reference!");
        }
        this.type_demande=type_demande;
    }

    public String getRef_demande() {
        return ref_demande;
    }

    public String getCin() {
        return cin;
    }

    public String getRef_compte() {
        return ref_compte;
    }

    public String getType_demande() {
        return type_demande.name();
    }

    @Override
    public String toString() {
        return "Demande{" +
                "ref_demande='" + ref_demande + '\'' +
                "cin='" + cin + '\'' +
                "ref_compte='" + ref_demande + '\'' +
                ", type='" + type_demande +
                '}';
    }
}
