package mini_projet;

import java.util.Scanner;
/* Database Import
import java.sql.*;
Graphical Interface Import 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

import mini_projet.Transaction.Type_Transaction;

public class Menu {

    public static void client_sign_up(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("CIN: ");
        String cin = scanner.next();
        System.out.println();
        System.out.print("Nom: ");
        String nom = scanner.next();
        System.out.println();
        System.out.print("Prenom: ");
        String prenom = scanner.next();
        System.out.println();
        System.out.print("Pass: ");
        String pass = scanner.next();
        Client client = new Client(cin, nom, prenom, pass);
        DB.Ajout_Client(client);
        System.out.println("---------------------");
        scanner.close();
    }

    public static boolean client_login(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("CIN: ");
        String cin = scanner.next();
        System.out.println();
        System.out.print("Pass: ");
        String pass = scanner.next();
        Client client = new Client(cin, pass);
        System.out.println("---------------------");
        scanner.close();
        return DB.Login(client);
    }

    public static boolean gerant_login(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("CIN: ");
        String cin = scanner.next();
        System.out.println();
        System.out.print("Pass: ");
        String pass = scanner.next();
        Gerant gerant = new Gerant(cin, pass);
        System.out.println("---------------------");
        scanner.close();
        return DB.Login(gerant);
    }

    public static void tester_compte(Client client){
        Compte compte = new Compte(client.getCin(), client.getNom(), client.getPrenom(), client.getPrenom());
        DB.Ajout_Compte(compte);
    }

    public static void tester_transaction(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Reference de Transaction: ");
        String ref_transaction = scanner.next();
        System.out.println();
        System.out.print("Reference de Compte: ");
        String ref_compte = scanner.next();
        System.out.println();
        System.out.print("-1: Depot: ");
        System.out.println();
        System.out.print("-2: Retrait: ");
        System.out.println();
        System.out.print("-3: Transfer (Mak rajl barra 5ademha): ");
        System.out.println();
        Type_Transaction type_transaction=Type_Transaction.depot;
        int choix = scanner.nextInt();
        switch(choix){
            case 0:
                type_transaction=Type_Transaction.depot;
                break;
            case 1:
                type_transaction=Type_Transaction.retrait;
                break;
            case 2:
                System.out.println("Mzlt ched s7i7?");
                System.out.println();
                break;
        }
        System.out.println();
        System.out.print("Montant: ");
        double montant = scanner.nextDouble();
        System.out.println();
        Transaction transaction = new Transaction(ref_transaction, ref_compte, type_transaction, montant);
        DB.Ajout_Transaction(transaction);
        scanner.close();
    }

    public static void Main(){

        Scanner scanner = new Scanner(System.in);

		boolean bank_status=true;

				while(bank_status==true)
				{

					System.out.println("-0:Gérant");
                    System.out.println("-1:Client");
                    System.out.println("-2:Exit");
                    System.out.println("---------------------");

					int a = scanner.nextInt();

                    System.out.println("---------------------");

					switch (a) 
					{
        
						case 0:

                            boolean gerant_status=gerant_login();;

                            while(gerant_status==true)
                            {
                                System.out.println("-0:Consulter Comptes");
                                System.out.println("-1:?");
                                System.out.println("-2:Exit");
                                System.out.println("---------------------");

                                a = scanner.nextInt();

                                System.out.println("---------------------");

                                switch(a)
                                {

                                case 0:
                                    break;
                                
                                case 1:
                                    break;

                                case 2:
                                    gerant_status=false;
                                    break;

                                }
                            }
							break;
						
						case 1:
                            System.out.println("-0:Log in");
                            System.out.println("-1:New Client? Sign Up");
                            System.out.println("-2:Exit");
                            System.out.println("---------------------");

                            a=scanner.nextInt();

                            System.out.println("---------------------");

                            switch(a)
                            {

                            case 0:

                                boolean client_status=client_login();

                                while(client_status==true){

                                    System.out.println("-0:?");
                                    System.out.println("-1:?");
                                    System.out.println("-2:Exit");
                                    System.out.println("---------------------");

                                    a = scanner.nextInt();

                                    System.out.println("---------------------");

                                    switch(a){

                                        case 0:
                                            break;

                                        case 1:
                                            break;

                                        case 2:
                                            break;
                                            
                                    }

                                }
                                break;
                            
                            case 1:
                                client_sign_up();
                                break;

                            case 2:
                                break;

                            }

                            break;

						case 2:
                            bank_status=false;
                            break;
                    
					}
				}

		scanner.close();
    }
}
