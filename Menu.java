package mini_projet;

import java.util.Scanner;
/* Database Import
import java.sql.*;
Graphical Interface Import 
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;*/

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
        DALClient_compte.addClient(client);
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
        return DALClient_compte.login(client);
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
        return DALClient_compte.login(gerant);
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
