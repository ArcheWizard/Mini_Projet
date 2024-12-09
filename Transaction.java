package mini_projet;

public class Transaction{

    private String ref_transaction;
    private String ref_compte;
    enum Type_Transaction{
        depot,
        retrait,
        transfer}
    private Type_Transaction type_transaction;
    private double montant;

    public Transaction(String ref_compte, Type_Transaction type_transaction, double montant) {
        this.ref_compte = ref_compte;
        this.type_transaction = type_transaction;
        this.montant = montant;
    }

    public Transaction(String ref_transaction, String ref_compte, Type_Transaction type_transaction, double montant) {
        this.ref_transaction=ref_transaction;
        this.ref_compte = ref_compte;
        this.type_transaction = type_transaction;
        this.montant = montant;
    }

    public Transaction(String ref_transaction) {
        this.ref_transaction=ref_transaction;
    }


    public String getRef_transaction() {
        return ref_transaction;
    }

    public String getRef_compte() {
        return ref_compte;
    }

    public String getType_transaction() {
        return type_transaction.name();
    }

    public double getMontant() {
        return montant;
    }

    @Override
    public String toString() {
        return "Reference de Transaction: "+getRef_transaction()+"\n"+
                "Reference de Compte: "+getRef_compte()+"\n"+
                "Type de Transaction: "+getType_transaction()+"\n"+
                "Montant: "+getMontant()+"\n"+
                "-------------------------------\n";
    }
    
}
