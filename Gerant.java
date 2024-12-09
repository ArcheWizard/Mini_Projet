package mini_projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Gerant extends Personne {

    public Gerant(String cin, String nom, String prenom, String pass) {
        super(cin, nom, prenom, pass);
    }

    public Gerant(String cin, String pass){
        super(cin, pass);
    }

    public static String Consulter_Clients(){
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        String allClients="";

        if (connection != null) {
            
            String query = "SELECT cin FROM clients";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){

                    String cin = resultSet.getString(1);

                    allClients += Consulter_Client(cin);
                    
                }

                return allClients;

                } 

            catch (SQLException e){
                System.out.println("Error while retrieving data: " + e.getMessage());
                } 
            
            finally{
                dbConnection.closeConnection();
                }   

        }

        return null;
    }

    public static String Consulter_Client(String cin){
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        String CH="";

        if (connection != null) {
            
            String query = "SELECT * FROM clients WHERE cin = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, cin);

                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){

                    String nom = resultSet.getString(2);

                    String prenom = resultSet.getString(3);

                    String pass = resultSet.getString(4);

                    Client client = new Client(cin, nom, prenom, pass);

                    client = Banque.get_Client(client);

                    Compte compte = Banque.get_Compte(client);

                    CH=client.toString();

                    if(compte != null){
                        CH+=compte.toString();
                    }

                    return CH;
                    
                }

                System.out.println("Printing is successful!");

                } 

            catch (SQLException e){
                System.out.println("Error while retrieving data: " + e.getMessage());
                } 
            
            finally{
                dbConnection.closeConnection();
                }   

        }

        return null;
    }
    
    public static String Consulter_Comptes(){
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        String allComptes="";

        if (connection != null) {
            
            String query = "SELECT * FROM comptes";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){

                    String ref_compte = resultSet.getString(1);

                    String cin = resultSet.getString(2);

                    Client client = Banque.get_Client(cin);

                    Compte compte = Banque.get_Compte(client);

                    if(compte != null){
                        allComptes += Consulter_Compte(ref_compte);
                    }
                    
                }

                return allComptes;

                } 

            catch (SQLException e){
                System.out.println("Error while retrieving data: " + e.getMessage());
                } 
            
            finally{
                dbConnection.closeConnection();
                }   

        }

        return null;
    }

    public static String Consulter_Compte(String ref_compte){
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            
            String query = "SELECT * FROM comptes WHERE ref_compte = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, ref_compte);

                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){

                    String CIN = resultSet.getString(2);

                    Client client = Banque.get_Client(CIN);

                    Compte compte = Banque.get_Compte(client);

                    if(compte != null){
                        return compte.toString();
                    }
                    
                }

                System.out.println("Printing is successful!");

                } 

            catch (SQLException e){
                System.out.println("Error while retrieving data: " + e.getMessage());
                } 
            
            finally{
                dbConnection.closeConnection();
                }   

        }

        return null;
    }

    public static void Supprimer_Client(Client client) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            
            String query = "DELETE FROM clients WHERE cin = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, client.getCin());

                preparedStatement.executeUpdate();
                System.out.println("The client has been deleted.");

                } 

            catch (SQLException e){
                System.out.println("Error while deleting client: " + e.getMessage());
                } 
            
            finally{
                dbConnection.closeConnection();
                }   

        }
    }

}
