package mini_projet;

import java.util.Scanner;

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
                        boolean gerant_status = DB.Login(gerant);

                        while (gerant_status) {
                            System.out.println("Please choose an option:");
                            System.out.println("1. Afficher tous les clients");
                            System.out.println("2. Afficher tous les comptes");
                            System.out.println("3. Log out");

                            System.out.print("Enter your choice: ");

                            if (scanner.hasNextInt()) {
                                int choice2 = scanner.nextInt();

                                switch (choice2) {
                                    case 1:
                                        DB.Consulter_Clients();
                                        break;
                                    case 2:
                                        DB.Consulter_Comptes();
                                        break;
                                    case 3:
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
                                    boolean client_status = DB.Login(client);

                                    while (client_status) {

                                        System.out.println("Login Successful!");

                                        client = DB.get_Client(client);

                                        if(DB.get_Compte(client) != null){

                                            Compte compte = DB.get_Compte(client);

                                            System.out.println("Please choose an option:");
                                            System.out.println("1. Afficher compte");
                                            System.out.println("2. Depot");
                                            System.out.println("3. Retrait");
                                            System.out.println("4. Log out");

                                            System.out.print("Enter your choice: ");

                                            if (scanner.hasNextInt()) {
                                                int choice2 = scanner.nextInt();

                                                switch (choice2) {
                                                    case 1:
                                                        DB.Consulter_Comptes_Client(client);
                                                        break;
                                                    case 2:
                                                        System.out.println("Reference de compte: "+compte.getRef_compte());
                                                        System.out.println("How much money do you wanna deposit?: ");
                                                        double montant = scanner.nextDouble();
                                                        DB.Depot(compte,montant);

                                                        break;
                                                    case 3:
                                                        System.out.println("Reference de compte: "+compte.getRef_compte());
                                                        System.out.println("How much money do you wanna withdraw?: ");
                                                        montant = scanner.nextFloat();
                                                        DB.Retrait(compte,montant);
                                                        break;
                                                    case 4:
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
                                                        Compte compte = new Compte(client.getCin(), client.getNom(), client.getPrenom(), client.getPass());
                                                        DB.Ajout_Compte(compte);
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
                                    DB.Ajout_Client(client);
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
