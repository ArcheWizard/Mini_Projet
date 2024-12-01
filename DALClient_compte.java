package mini_projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DALClient_compte {

    public static boolean login(String cin, String pass) {

    DBConnection dbConnection = new DBConnection();
    Connection connection = dbConnection.getConnection();

    if (connection != null) {
        String query = "SELECT COUNT(*) FROM Client WHERE cin = ? AND password = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setString(1, cin);
            preparedStatement.setString(2, pass);

            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error during login: " + e.getMessage());
        } finally {
            dbConnection.closeConnection();
        }
      } return false;
    }


    public static void addClient(Client client) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            String query = "INSERT INTO Client VALUES(?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, client.getNom());
                preparedStatement.setString(2, client.getPrenom());
                preparedStatement.setString(3, client.getCin());
                preparedStatement.setString(4, client.getPass());

                preparedStatement.executeUpdate();
                System.out.println("A new client has been added.");
            } catch (SQLException e) {
                System.out.println("Error while adding client: " + e.getMessage());
            } finally {
                dbConnection.closeConnection();
            }
        }
    }



    public static void addCompte(Compte compte) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            String query = "INSERT INTO Compte VALUES(?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, compte.getCin());
                preparedStatement.setString(2, compte.getref_compte());
                preparedStatement.setDouble(3, compte.getBalance());

                preparedStatement.executeUpdate();
                System.out.println("A new compte has been added.");
            } catch (SQLException e) {
                System.out.println("Error while adding compte: " + e.getMessage());
            } finally {
                dbConnection.closeConnection();
            }
        }
    }



    public static void request_Delete_Client(String cin) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            String query = "INSERT INTO Demande VALUES(?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                
                preparedStatement.setString(1, cin);

                preparedStatement.executeUpdate();
                System.out.println("Your request has been sent.");

            } catch (SQLException e) {
                System.out.println("Error while sending request: " + e.getMessage());
            } finally {
                dbConnection.closeConnection();
            }
        }
    }




    public static void requestDeleteCompte(String ref) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {
            String query = "INSERT INTO Demande VALUES(?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, ref);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Your request has been sent ");
                } else {
                    System.out.println("No compte found with ref " + ref);
                }
            } catch (SQLException e) {
                System.out.println("Error while deleting compte: " + e.getMessage());
            } finally {
                dbConnection.closeConnection();
            }
        }
    }
}