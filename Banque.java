package mini_projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Banque{

    public static boolean Login(Client client) {

    DBConnection dbConnection = new DBConnection();
    Connection connection = dbConnection.getConnection();

    if (connection != null) {
        String query = "SELECT COUNT(*) FROM clients WHERE cin = ? AND pass = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, client.getCin());
            preparedStatement.setString(2, client.getPass());

            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }

            }

        } 

        catch (SQLException e) {
            System.out.println("Error during login: " + e.getMessage());
        }

        finally {
            dbConnection.closeConnection();
        }

      } 
      
      return false;

    }

    public static Client get_Client(Client client){
        
        if(Login(client)){

            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
    
            if (connection != null) {

                String query = "SELECT * FROM clients WHERE cin = ? AND pass = ?";
        
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                    preparedStatement.setString(1, client.getCin());
                    preparedStatement.setString(2, client.getPass());
                    
                    ResultSet resultSet = preparedStatement.executeQuery();

                    while(resultSet.next()){

                        String cin = resultSet.getString(1);

                        String nom = resultSet.getString(2);

                        String prenom = resultSet.getString(3);

                        String pass = resultSet.getString(4);

                        Client full_client = new Client(cin, nom, prenom, pass);

                        return full_client;
                    
                    }

                } 
        
                catch (SQLException e) {
                    System.out.println("Error during login: " + e.getMessage());
                }
        
                finally {
                    dbConnection.closeConnection();
                }
        
            }

        }
     
        return null;
    }

    public static Client get_Client(String cin){

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {

            String query = "SELECT * FROM clients WHERE cin = ?";
    
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, cin);
                
                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){

                    cin = resultSet.getString(1);

                    String nom = resultSet.getString(2);

                    String prenom = resultSet.getString(3);

                    String pass = resultSet.getString(4);

                    Client full_client = new Client(cin, nom, prenom, pass);

                    return full_client;
                
                }

            } 
    
            catch (SQLException e) {
                System.out.println("Error during login: " + e.getMessage());
            }
    
            finally {
                dbConnection.closeConnection();
            }
    
        }

     
        return null;
    }

    public static Compte get_Compte(Client client){

        if(Login(client)){

            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
    
            if (connection != null) {

                String query = "SELECT * FROM comptes WHERE cin = ?";
        
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                    preparedStatement.setString(1, client.getCin());
                    
                    ResultSet resultSet = preparedStatement.executeQuery();

                    while(resultSet.next()){

                        float balance = resultSet.getFloat(3);

                        Compte compte = new Compte(client);

                        compte.setBalance(balance);

                        return compte;
                    
                    }

                } 
        
                catch (SQLException e) {
                    System.out.println("Error during login: " + e.getMessage());
                }
        
                finally {
                    dbConnection.closeConnection();
                }
        
            }

        }
     
        return null;

    }
    
    public static boolean Login(Gerant gerant) {

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
    
        if (connection != null) {
            String query = "SELECT COUNT(*) FROM gerants WHERE cin = ? AND pass = ?";
    
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                
                preparedStatement.setString(1, gerant.getCin());
                preparedStatement.setString(2, gerant.getPass());
    
                
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
    
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
    
                }
    
            } 
    
            catch (SQLException e) {
                System.out.println("Error during login: " + e.getMessage());
            }
    
            finally {
                dbConnection.closeConnection();
            }
    
          } 
          
          return false;
    
    }

    public static Gerant get_Gerant(Gerant gerant){
        
        if(Login(gerant)){

            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
    
            if (connection != null) {

                String query = "SELECT * FROM gerants WHERE cin = ? AND pass = ?";
        
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                    preparedStatement.setString(1, gerant.getCin());
                    preparedStatement.setString(2, gerant.getPass());
                    
                    ResultSet resultSet = preparedStatement.executeQuery();

                    while(resultSet.next()){

                        String cin = resultSet.getString(1);

                        String nom = resultSet.getString(2);

                        String prenom = resultSet.getString(3);

                        String pass = resultSet.getString(4);

                        Gerant full_gerant = new Gerant(cin, nom, prenom, pass);

                        return full_gerant;
                    
                    }

                } 
        
                catch (SQLException e) {
                    System.out.println("Error during login: " + e.getMessage());
                }
        
                finally {
                    dbConnection.closeConnection();
                }
        
            }

        }
     
        return null;
    }

    public static void Ajout_Client(Client client) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            
            String query = "INSERT INTO clients VALUES(?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, client.getCin());
                preparedStatement.setString(2, client.getNom());
                preparedStatement.setString(3, client.getPrenom());
                preparedStatement.setString(4, client.getPass());

                preparedStatement.executeUpdate();
                System.out.println("A new client has been added.");

                } 

            catch (SQLException e){
                System.out.println("Error while adding client: " + e.getMessage());
                } 
            
            finally{
                dbConnection.closeConnection();
                }   

        }
    }

    public static void Ajout_Transaction(Transaction transaction) {

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {

            String query = "INSERT INTO transactions VALUES(?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, transaction.getRef_transaction());
                preparedStatement.setString(2, transaction.getRef_compte());
                preparedStatement.setString(3, transaction.getType_transaction());
                preparedStatement.setDouble(4, transaction.getMontant());

                preparedStatement.executeUpdate();
                System.out.println("Transaction has been added.");
            } 

            catch (SQLException e) {
                System.out.println("Error while adding compte: " + e.getMessage());
            } 
            
            finally {
                dbConnection.closeConnection();
            }

        }
    }
     
    public static void Ajout_Demande(Demande demande) {

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {

            String query = "INSERT INTO demandes VALUES(?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, demande.getRef_demande());
                preparedStatement.setString(2, demande.getCin());
                preparedStatement.setString(3, demande.getRef_compte());
                preparedStatement.setString(4, demande.getType_demande());

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Your request has been sent ");
                } 
                
                else {
                    System.out.println("The data you put in is not valid!");
                }

            } 
            
            catch (SQLException e) {
                System.out.println("An error has happend while completing your request: " + e.getMessage());
            } 
            
            finally {
                dbConnection.closeConnection();
            }

        }
    }

    public static void Modify_Client(Client client, String cin){
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            
            String query = "UPDATE clients SET cin = ? , nom = ? , prenom = ? , pass = ? WHERE (cin = ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, client.getCin());
                preparedStatement.setString(2, client.getNom());
                preparedStatement.setString(3, client.getPrenom());
                preparedStatement.setString(4, client.getPass());
                preparedStatement.setString(5, cin);

                preparedStatement.executeUpdate();
                System.out.println("Client has been modified.");

                } 

            catch (SQLException e){
                System.out.println("Error while modifying client: " + e.getMessage());
                } 
            
            finally{
                dbConnection.closeConnection();
                }   

        }
    }

    public static void Modify_Compte(Client client, String cin){
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            
            String query = "UPDATE comptes SET ref_compte = ? WHERE (cin = ?);";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                
                Compte compte = new Compte(client);
                preparedStatement.setString(1, compte.generer_ref_compte(client.getNom(), client.getPrenom(), client.getCin()));
                preparedStatement.setString(2, client.getCin());

                preparedStatement.executeUpdate();
                System.out.println("Account has been modified.");

                } 

            catch (SQLException e){
                System.out.println("Error while modifying account: " + e.getMessage());
                } 
            
            finally{
                dbConnection.closeConnection();
                }   

        }
    }
    
    public static void Supprimer_Transaction(Transaction transaction) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            
            String query = "DELETE FROM transactions WHERE ref_transaction = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, transaction.getRef_transaction());

                preparedStatement.executeUpdate();
                System.out.println("The transaction has been deleted.");

                } 

            catch (SQLException e){
                System.out.println("Error while deleting transaction: " + e.getMessage());
                } 
            
            finally{
                dbConnection.closeConnection();
                }   

        }
    }

    public static void Supprimer_Demande(Demande demande) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            
            String query = "DELETE FROM demandes WHERE ref_demande = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, demande.getRef_demande());

                preparedStatement.executeUpdate();
                System.out.println("The demand has been deleted.");

                } 

            catch (SQLException e){
                System.out.println("Error while deleting demand: " + e.getMessage());
                } 
            
            finally{
                dbConnection.closeConnection();
                }   

        }
    }
    
}

