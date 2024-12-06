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

                        Compte compte = new Compte(client, balance);

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

    public static void Consulter_Clients(){
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            
            String query = "SELECT * FROM clients";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){

                    String cin = resultSet.getString(1);

                    String nom = resultSet.getString(2);

                    String prenom = resultSet.getString(3);

                    String pass = resultSet.getString(4);

                    Client client = new Client(cin, nom, prenom, pass);

                    System.out.println("---------------------");

                    System.out.println("CIN: "+cin);

                    System.out.println("Nom: "+nom);

                    System.out.println("Prenom: "+prenom);

                    Consulter_Comptes_Client(client);

                    System.out.println("---------------------");
                    
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
    }

    public static void Consulter_Client(String cin){
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

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

                    System.out.println("---------------------");

                    System.out.println("CIN: "+cin);

                    System.out.println("Nom: "+nom);

                    System.out.println("Prenom: "+prenom);

                    Consulter_Comptes_Client(client);

                    System.out.println("---------------------");
                    
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
    }
    
    public static void Consulter_Comptes(){
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            
            String query = "SELECT * FROM comptes";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){

                    String ref_compte = resultSet.getString(1);

                    String CIN = resultSet.getString(2);

                    Double Balance = resultSet.getDouble(3);

                    System.out.println("---------------------");

                    System.out.println("Reference Compte: "+ref_compte);

                    System.out.println("CIN: "+CIN);

                    System.out.println("Balance: "+Balance);

                    System.out.println("---------------------");
                    
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
    }

    public static void Consulter_Compte(String ref_compte){
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            
            String query = "SELECT * FROM comptes WHERE ref_compte = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, ref_compte);

                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){

                    String CIN = resultSet.getString(2);

                    Double Balance = resultSet.getDouble(3);

                    System.out.println("---------------------");

                    System.out.println("Reference Compte: "+ref_compte);

                    System.out.println("CIN: "+CIN);

                    System.out.println("Balance: "+Balance);

                    System.out.println("---------------------");
                    
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
    }

    public static void Consulter_Comptes_Client(Client client){
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            
            String query = "SELECT * FROM comptes WHERE cin = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, client.getCin());

                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){

                    String ref_compte = resultSet.getString(1);

                    String CIN = resultSet.getString(2);

                    Double Balance = resultSet.getDouble(3);

                    System.out.println("---------------------");

                    System.out.println("Reference Compte: "+ref_compte);

                    System.out.println("CIN: "+CIN);

                    System.out.println("Balance: "+Balance);

                    System.out.println("---------------------");
                    
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

    public static void Depot(Compte compte, double montant){

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {

            String query = "UPDATE comptes SET balance = ? WHERE ref_compte = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                compte.depot(montant);
    
                preparedStatement.setDouble(1, compte.getBalance());
                preparedStatement.setString(2, compte.getRef_compte());

                preparedStatement.executeUpdate();
                System.out.println("Deposit is successful.");
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
                System.out.println("Withdrawal is successful.");
            } 

            catch (SQLException e) {
                System.out.println("Error while depositing: " + e.getMessage());
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

    public static void Supprimer_Compte(Compte compte) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            
            String query = "DELETE FROM compte WHERE ref_compte = ?";
            
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