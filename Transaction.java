package mini_projet;

public class Transaction{

    private String id;
    private String type; // deposit, withdrawal, transfer
    private double montant;

    public Transaction(String id, String type, double montant) {
        this.id = id;
        this.type = type;
        this.montant = montant;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getMontant() {
        return montant;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + id + '\'' +
                ", type='" + type + '\'' +
                ", montant=" + montant +
                '}';
    }
    
}
