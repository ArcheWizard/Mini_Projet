package mini_projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client extends Personne {

    private Compte compte;

    public Client(String cin, String nom, String prenom, String pass) {
        super(cin, nom, prenom, pass);
        this.compte = new Compte(cin, nom, prenom, pass);
    }

    public Client(String cin, String pass){
        super(cin, pass);
    }

    public Compte getCompte() {
        return compte;
    }

    public static void Ajout_Compte(Client client) {

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {

            String query = "INSERT INTO comptes VALUES(?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, client.getCompte().getRef_compte());
                preparedStatement.setString(2, client.getCin());
                preparedStatement.setDouble(3, client.getCompte().getBalance());

                preparedStatement.executeUpdate();
                System.out.println("A new compte has been added.");
            } 

            catch (SQLException e) {
                System.out.println("Error while adding compte: " + e.getMessage());
            } 
            
            finally {
                dbConnection.closeConnection();
            }

        }
    }

    public static void Supprimer_Compte(Compte compte) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            
            String query = "DELETE FROM comptes WHERE ref_compte = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, compte.getRef_compte());

                preparedStatement.executeUpdate();
                System.out.println("The account has been deleted.");

                } 

            catch (SQLException e){
                System.out.println("Error while deleting account: " + e.getMessage());
                } 
            
            finally{
                dbConnection.closeConnection();
                }   

        }
    }

    public String toString() {
        return "CIN: "+ getCin() +"\n"+"Nom: "+ getNom() +"\n"+"Prenom: "+ getPrenom()+"\n"
        +"--------------------------------------------------\n";
    }

}
