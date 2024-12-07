package mini_projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Compte{

    private String ref_compte;
    private double balance;
    
    public Compte(Client client){
        this.ref_compte=generer_ref_compte(client.getNom(),client.getPrenom(),client.getCin());
        this.balance=0.0f;
    }
    
    public Compte(String cin, String nom, String prenom, String pass){
        this.ref_compte=generer_ref_compte(nom,prenom,cin);
        this.balance=0.0f;
    }

    public String getRef_compte() {
        return ref_compte;
    }

    public double getBalance() {
        return balance;
    }

    public void setRef_compte(String ref_compte) {
        this.ref_compte = ref_compte;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String generer_ref_compte(String nom, String prenom, String cin){
        
        String ref_compte = "";
        String full_name=nom+prenom;
		int Length = full_name.length();

		for(int i=0;i<Length;i=i+5)
		{
			if(full_name.charAt(i)!=' '){
			    ref_compte+=full_name.charAt(i);
			}
		}

        ref_compte+=cin.substring(cin.length()-3);

        return ref_compte;
        
    }

    public void depot(double montant){
        if (montant > 0) {
            this.balance = this.balance + montant;
            System.out.println("Deposit is successful.");
        } else {
            System.out.println("Invalid deposit montant!");
        }
    }

    public void retrait(double montant){
        if (montant > 0 && montant <= balance) {
            this.balance = this.balance - montant;
            System.out.println("Withdrawal is successful.");
        } else {
            System.out.println("Invalid withdrawal montant!");
        }
    }

    public void transfer(Compte compte, double montant){
        if (montant > 0 && montant <= balance) {
            this.retrait(montant);
            compte.depot(montant);
        } else {
            System.out.println("Invalid transfer montant!");
        }
    }

    public static void Depot(Compte compte, double montant){

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {

            String query = "UPDATE comptes SET balance = ? WHERE (ref_compte = ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                System.out.println(compte.getRef_compte());

                compte.depot(montant);
    
                preparedStatement.setDouble(1, compte.getBalance());
                preparedStatement.setString(2, compte.getRef_compte());

                preparedStatement.executeUpdate();
    
            } 

            catch (SQLException e) {
                System.out.println("Error while depositing: " + e.getMessage());
            } 
            
            finally {
                dbConnection.closeConnection();
            }

        }

    }

    public static void Retrait(Compte compte, double montant){

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {

            String query = "UPDATE comptes SET balance = ? WHERE ref_compte = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                compte.retrait(montant);
    
                preparedStatement.setDouble(1, compte.getBalance());
                preparedStatement.setString(2, compte.getRef_compte());

                preparedStatement.executeUpdate();
                
            } 

            catch (SQLException e) {
                System.out.println("Error while depositing: " + e.getMessage());
            } 
            
            finally {
                dbConnection.closeConnection();
            }

        }
        
    }

    public static void Transferer(Client client_sender, Client client_receiver, double montant){
        Retrait(Banque.get_Compte(client_sender), montant);
        System.out.println("Money sent successfully!");
        Depot(Banque.get_Compte(client_receiver), montant);
        System.out.println("Money received successfully!");
        System.out.println("Transaction to "+client_receiver.toString()+"Was finished successfully!");
    }
    
    public String toString() {
        return super.toString()+"Votre compte de reference: ("+getRef_compte()+")";
    };
}
