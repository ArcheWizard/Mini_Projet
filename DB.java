package mini_projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DB {

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

    public static void Ajout_Compte(Compte compte) {

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {

            String query = "INSERT INTO comptes VALUES(?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, compte.getRef_compte());
                preparedStatement.setString(2, compte.getCin());
                preparedStatement.setDouble(3, compte.getBalance());

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
    
}