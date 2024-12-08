package mini_projet;

import java.util.Scanner;

import mini_projet.Transaction.Type_Transaction;

/* Database Import
import java.sql.*;
Graphical Interface Import 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

public class Menu {

    private static final Scanner scanner = new Scanner(System.in); // Single shared Scanner instance

    public static Client client_sign_up_menu() {
        System.out.println("Client Sign-Up");
        System.out.print("CIN: ");
        String cin = scanner.next();
        System.out.print("Nom: ");
        String nom = scanner.next();
        System.out.print("Prenom: ");
        String prenom = scanner.next();
        System.out.print("Pass: ");
        String pass = scanner.next();
        Client client = new Client(cin, nom, prenom, pass);
        System.out.println("---------------------");
        return client;
    }

    public static Client client_login_menu() {
        System.out.println("Client Log-in");
        System.out.print("CIN: ");
        String cin = scanner.next();
        System.out.print("Pass: ");
        String pass = scanner.next();
        Client client = new Client(cin, pass);
        System.out.println("---------------------");
        return client;
    }

    public static Gerant gerant_login_menu() {
        System.out.println("Gerant Log-in");
        System.out.print("CIN: ");
        String cin = scanner.next();
        System.out.print("Pass: ");
        String pass = scanner.next();
        Gerant gerant = new Gerant(cin, pass);
        System.out.println("---------------------");
        return gerant;
    }

    public static void Main() {

        boolean bank_status = true;

        while (bank_status) {
            System.out.println("Please choose an option:");
            System.out.println("1. Gerant");
            System.out.println("2. Client");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice1 = scanner.nextInt();

                switch (choice1) {
                    case 1:
                        Gerant gerant = Menu.gerant_login_menu();
                        boolean gerant_status = Banque.Login(gerant);

                        while (gerant_status) {
                            System.out.println("Please choose an option:");
                            System.out.println("1. Afficher tous les clients");
                            System.out.println("2. Afficher tous les comptes");
                            System.out.println("3. Afficher un client");
                            System.out.println("4. Afficher une compte");
                            System.out.println("5. Supprimer un compte");
                            System.out.println("6. Log out");

                            System.out.print("Enter your choice: ");

                            if (scanner.hasNextInt()) {
                                int choice2 = scanner.nextInt();

                                switch (choice2) {
                                    case 1:
                                        Gerant.Consulter_Clients();
                                        break;
                                    case 2:
                                        Gerant.Consulter_Comptes();
                                        break;
                                    case 3:
                                        System.out.println("Which client do you want to check?");
                                        System.out.print("CIN: ");
                                        String cin = scanner.next();
                                        Gerant.Consulter_Client(cin);
                                        break;
                                    case 4:
                                        System.out.println("Which account do you want to check?");
                                        System.out.print("Account reference: ");
                                        String ref_compte = scanner.next();
                                        Gerant.Consulter_Compte(ref_compte);
                                        break;
                                    case 5:
                                        System.out.println("Which client do you want to check?");
                                        System.out.print("CIN: ");
                                        cin = scanner.next();
                                        Client client = Banque.get_Client(cin);
                                        Gerant.Supprimer_Client(client);
                                        break;
                                    case 6:
                                        System.out.println("Logging out. Goodbye!");
                                        gerant_status = false;
                                        break;
                                    default:
                                        System.out.println("Invalid option. Please enter 1, 2, or 3.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                                scanner.next(); // Consume invalid input
                            }
                            System.out.println(); // Add a blank line for better readability
                        }
                        break;

                    case 2:
                        Client client = null;
                        System.out.println("Dear Client, please choose an option:");
                        System.out.println("1. Log in");
                        System.out.println("2. Sign up");
                        System.out.println("3. Exit");

                        System.out.print("Enter your choice: ");

                        if (scanner.hasNextInt()) {
                            int choice3 = scanner.nextInt();

                            switch (choice3) {
                                case 1:
                                    client = Menu.client_login_menu();
                                    boolean client_status = Banque.Login(client);

                                    while (client_status) {

                                        System.out.println("Login Successful!");

                                        client = Banque.get_Client(client);

                                        if(Banque.get_Compte(client) != null){

                                            Compte compte = Banque.get_Compte(client);

                                            System.out.println("Please choose an option:");
                                            System.out.println("1. Afficher compte");
                                            System.out.println("2. Depot");
                                            System.out.println("3. Retrait");
                                            System.out.println("4. Transfer");
                                            System.out.println("5. Supprimer compte");
                                            System.out.println("6. Log out");

                                            System.out.print("Enter your choice: ");

                                            if (scanner.hasNextInt()) {
                                                int choice2 = scanner.nextInt();

                                                switch (choice2) {
                                                    case 1:
                                                        Client.Consulter_Compte_Client(client);
                                                        break;
                                                    case 2:
                                                        System.out.println("Reference de compte: "+compte.getRef_compte());
                                                        System.out.print("How much money do you wanna deposit?: ");
                                                        double montant = scanner.nextDouble();
                                                        Compte.Depot(compte,montant);
                                                        compte = Banque.get_Compte(client);
                                                        Transaction transaction = new Transaction(compte.getRef_compte(), Type_Transaction.depot, montant);
                                                        Banque.Ajout_Transaction(transaction);
                                                        break;
                                                    case 3:
                                                        System.out.println("Reference de compte: "+compte.getRef_compte());
                                                        System.out.print("How much money do you wanna withdraw?: ");
                                                        montant = scanner.nextFloat();
                                                        Compte.Retrait(compte,montant);
                                                        compte = Banque.get_Compte(client);
                                                        transaction = new Transaction(compte.getRef_compte(), Type_Transaction.retrait, montant);
                                                        Banque.Ajout_Transaction(transaction);
                                                        break;
                                                    
                                                    case 4:
                                                        System.out.println("To which client do you want to send to?");
                                                        System.out.print("CIN: ");
                                                        String cin = scanner.next();
                                                        Client client_receiver = Banque.get_Client(cin);
                                                        System.out.print("How much money do you wanna send?: ");
                                                        montant = scanner.nextDouble();
                                                        Compte.Transferer(client, client_receiver, montant);
                                                        compte = Banque.get_Compte(client);
                                                        transaction = new Transaction(compte.getRef_compte(), Type_Transaction.transfer, montant);
                                                        Banque.Ajout_Transaction(transaction);
                                                        break;
                                                    
                                                    case 5:
                                                        compte = Banque.get_Compte(client);
                                                        if(compte.getBalance()==0){
                                                            Client.Supprimer_Compte(compte);
                                                        }
                                                        else{
                                                            System.out.println("Sorry, your account still has a balance, you should withdraw or transfer it all before deleting it");

                                                        }
                                                        break;
                                                    
                                                    case 6:
                                                        System.out.println("Exiting the program. Goodbye!");
                                                        client_status = false;
                                                        break;

                                                    default:
                                                        System.out.println("Invalid option. Please enter 1, 2, 3 or 4.");
                                                    
                                                    }
                                                
                                                } 
                                                
                                                else {
                                                    System.out.println("Invalid input. Please enter a number (1, 2, 3 or 4).");
                                                    scanner.next(); // Consume invalid input
                                                }

                                                System.out.println(); // Add a blank line for better readability

                                        }

                                        else{

                                            System.out.println("Hey, I see that you still haven't created an account!");
                                            System.out.println("1. Create account?");
                                            System.out.println("2. Log out");

                                            System.out.print("Enter your choice: ");

                                            if (scanner.hasNextInt()) {
                                                int choice2 = scanner.nextInt();

                                                switch (choice2) {
                                                    case 1:
                                                        Client.Ajout_Compte(client);
                                                        break;
                                                    case 2:
                                                        System.out.println("Logging out. Goodbye "+client.getPrenom()+"!");
                                                        client_status = false;
                                                        break;
                                                    default:
                                                        System.out.println("Invalid option. Please enter 1 or 2.");
                                                    
                                                    }
                                                
                                                } 
                                                
                                                else {
                                                    System.out.println("Invalid input. Please enter a number (1 or 2).");
                                                    scanner.next(); // Consume invalid input
                                                }

                                                System.out.println(); // Add a blank line for better readability
                                            
                                        }

                                    }
                                    break;

                                case 2:
                                    client = Menu.client_sign_up_menu();
                                    Banque.Ajout_Client(client);
                                    break;

                                case 3:
                                    System.out.println("Exiting the program. Goodbye!");
                                    break;

                                default:
                                    System.out.println("Invalid option. Please enter 1, 2, or 3.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                            scanner.next(); // Consume invalid input
                        }
                        System.out.println();
                        break;

                    case 3:
                        System.out.println("Exiting the program. Goodbye!");
                        bank_status = false;
                        break;

                    default:
                        System.out.println("Invalid option. Please enter 1, 2, or 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                scanner.next(); // Consume invalid input
            }
            System.out.println();
        }
    }
}
