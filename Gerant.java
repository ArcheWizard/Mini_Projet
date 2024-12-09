package mini_projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Gerant extends Personne implements Loginable {

    public Gerant(String cin, String nom, String prenom, String pass) {
        super(cin, nom, prenom, pass);
    }

    public Gerant(String cin, String pass) {
        super(cin, pass);
    }

<<<<<<< HEAD
    public static String Consulter_Clients(){
=======
    public static void Consulter_Clients() {
>>>>>>> 70083e372cafc30d8f74b60d889da1230f0675d8
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        String allClients="";

        if (connection != null) {
<<<<<<< HEAD
            
            String query = "SELECT cin FROM clients";
            
=======

            String query = "SELECT * FROM clients";

>>>>>>> 70083e372cafc30d8f74b60d889da1230f0675d8
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    String cin = resultSet.getString(1);

<<<<<<< HEAD
                    allClients += Consulter_Client(cin);
                    
=======
                    String nom = resultSet.getString(2);

                    String prenom = resultSet.getString(3);

                    String pass = resultSet.getString(4);

                    Client client = new Client(cin, nom, prenom, pass);

                    System.out.println("---------------------");

                    System.out.println("CIN: " + cin);

                    System.out.println("Nom: " + nom);

                    System.out.println("Prenom: " + prenom);

                    Client.Consulter_Compte_Client(client);

                    System.out.println("---------------------");

>>>>>>> 70083e372cafc30d8f74b60d889da1230f0675d8
                }

                return allClients;

            }

            catch (SQLException e) {
                System.out.println("Error while retrieving data: " + e.getMessage());
            }

            finally {
                dbConnection.closeConnection();
            }

        }

        return null;
    }

<<<<<<< HEAD
    public static String Consulter_Client(String cin){
=======
    public static void Consulter_Client(String cin) {
>>>>>>> 70083e372cafc30d8f74b60d889da1230f0675d8
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        String CH="";

        if (connection != null) {

            String query = "SELECT * FROM clients WHERE cin = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, cin);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    String nom = resultSet.getString(2);

                    String prenom = resultSet.getString(3);

                    String pass = resultSet.getString(4);

                    Client client = new Client(cin, nom, prenom, pass);

                    client = Banque.get_Client(client);

<<<<<<< HEAD
                    Compte compte = Banque.get_Compte(client);

                    CH=client.toString();

                    if(compte != null){
                        CH+=compte.toString();
                    }

                    return CH;
                    
=======
                    System.out.println("CIN: " + cin);

                    System.out.println("Nom: " + nom);

                    System.out.println("Prenom: " + prenom);

                    Client.Consulter_Compte_Client(client);

                    System.out.println("---------------------");

>>>>>>> 70083e372cafc30d8f74b60d889da1230f0675d8
                }

                System.out.println("Printing is successful!");

            }

            catch (SQLException e) {
                System.out.println("Error while retrieving data: " + e.getMessage());
            }

            finally {
                dbConnection.closeConnection();
            }

        }

        return null;
    }
<<<<<<< HEAD
    
    public static String Consulter_Comptes(){
=======

    public static void Consulter_Comptes() {
>>>>>>> 70083e372cafc30d8f74b60d889da1230f0675d8
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        String allComptes="";

        if (connection != null) {

            String query = "SELECT * FROM comptes";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    String ref_compte = resultSet.getString(1);

                    String cin = resultSet.getString(2);

                    Client client = Banque.get_Client(cin);

                    Compte compte = Banque.get_Compte(client);

<<<<<<< HEAD
                    if(compte != null){
                        allComptes += Consulter_Compte(ref_compte);
                    }
                    
=======
                    System.out.println("Reference Compte: " + ref_compte);

                    System.out.println("CIN: " + CIN);

                    System.out.println("Balance: " + Balance);

                    System.out.println("---------------------");

>>>>>>> 70083e372cafc30d8f74b60d889da1230f0675d8
                }

                return allComptes;

            }

            catch (SQLException e) {
                System.out.println("Error while retrieving data: " + e.getMessage());
            }

            finally {
                dbConnection.closeConnection();
            }

        }

        return null;
    }

<<<<<<< HEAD
    public static String Consulter_Compte(String ref_compte){
=======
    public static void Consulter_Compte(String ref_compte) {
>>>>>>> 70083e372cafc30d8f74b60d889da1230f0675d8
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        if (connection != null) {

            String query = "SELECT * FROM comptes WHERE ref_compte = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, ref_compte);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    String CIN = resultSet.getString(2);

                    Client client = Banque.get_Client(CIN);

                    Compte compte = Banque.get_Compte(client);

<<<<<<< HEAD
                    if(compte != null){
                        return compte.toString();
                    }
                    
=======
                    System.out.println("Reference Compte: " + ref_compte);

                    System.out.println("CIN: " + CIN);

                    System.out.println("Balance: " + Balance);

                    System.out.println("---------------------");

>>>>>>> 70083e372cafc30d8f74b60d889da1230f0675d8
                }

                System.out.println("Printing is successful!");

            }

            catch (SQLException e) {
                System.out.println("Error while retrieving data: " + e.getMessage());
            }

            finally {
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

            catch (SQLException e) {
                System.out.println("Error while deleting client: " + e.getMessage());
            }

            finally {
                dbConnection.closeConnection();
            }

        }
    }

    @Override
    public boolean login(String cin, String password) {
        return getCin().equals(cin) && getPass().equals(password);
    }

}
