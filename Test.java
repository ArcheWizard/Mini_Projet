package Mini_Projet;

import java.util.ArrayList;
import java.util.Scanner;
/* Database Import */
import java.sql.*;
/* Graphical Interface Import */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Client_Comptes> liste_client_compte = new ArrayList<Client_Comptes>();

        liste_client_compte.add(new Client_Comptes(new Client("Dadi", "Fares", "13289171", 0.0f), new Compte("Dadi", "Fares", null, 0)));

        ArrayList<Gerant> liste_gerants = new ArrayList<Gerant>();

        liste_gerants.add(new Gerant("Charika", "Moudir"));

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
                            Gerant gerant = new Gerant();
                            boolean gerant_password_valid=false;
                            String gerant_password="";
                            System.out.println("Please log in with your password.");
                            for(int i=0;i<3;i++){
                                System.out.println("Password ("+i+" Tries): ");
                                gerant_password = scanner.next();
                                for(Gerant x : liste_gerants){
                                    gerant_password_valid=x.is_gerant_password_valid(gerant_password);
                                    if(gerant_password_valid==true){
                                        break;
                                    }
                                    else{
                                        System.out.println("Password incorrect!");
                                    }
                                }
                                if(gerant_password_valid==true){
                                    break;
                                }
                            }

                            if(gerant_password_valid==false){
                                System.out.println("You have ran out of tries!");
                                break;
                            }
                            
                            while(gerant_password_valid==true)
                            {
                                System.out.println("Password correct!");
                                System.out.println("Welcome Mr/Ms "+gerant.getPrenom()+" "+gerant.getNom()+"!");
                                System.out.println("---------------------");
                                System.out.println("-0:");
                                System.out.println("-1:");
                                System.out.println("-2:Exit");
                                System.out.println("---------------------");
                                int b = scanner.nextInt();

                                System.out.println("---------------------");

                                switch(b)
                                {
                                    case 0:
                                        break;
                                    
                                    case 1:
                                        break;
                                    
                                    case 2:
                                        gerant_password_valid=false;
                                        System.out.println("Goodbye Mr/Ms "+gerant.getPrenom()+" "+gerant.getNom()+"!");
                                        break;
                                }

                            }

							break;
						
						case 1:
                            System.out.println("-0:Log in");
                            System.out.println("-1:New Client? Sign Up");
                            System.out.println("-2:Exit");
                            System.out.println("---------------------");

                            int c = scanner.nextInt();

                            System.out.println("---------------------");

                            boolean client_status=true;

                            while(client_status==true)
                            {
                                switch(c)
                                {

                                case 0:
                                    Client_Comptes client_compte = new Client_Comptes();   
                                    boolean client_password_valid=false;
                                    String client_password="";
                                    System.out.println("Please log in with your password.");
                                    for(int i=0;i<3;i++){
                                        System.out.println("Password ("+i+" Tries): ");
                                        client_password = scanner.next();
                                        for(Client_Comptes x : liste_client_compte){
                                            client_password_valid=x.client.is_client_password_valid(client_password);
                                            if(client_password_valid==true){
                                                client_compte=x;
                                                break;
                                            }
                                            else{
                                                System.out.println("Password incorrect!");
                                            }
                                        }
                                        if(client_password_valid==true){
                                            break;
                                        }
                                    }
                                    if(client_password_valid==false){
                                        System.out.println("You have ran out of tries!");
                                        break;
                                    }
                                    
                                    while(client_password_valid==true)
                                    {
                                        System.out.println("Password correct!");
                                        System.out.println("Welcome Mr/Ms "+client_compte.client.getPrenom()+" "+client_compte.client.getNom()+"!");
                                        System.out.println("---------------------");
                                        System.out.println("-0:");
                                        System.out.println("-1:");
                                        System.out.println("-2:Exit");
                                        System.out.println("---------------------");

                                        int d = scanner.nextInt();

                                        System.out.println("---------------------");

                                        switch(d)
                                        {
                                            case 0:
                                                break;
                                            
                                            case 1:
                                                break;
                                            
                                            case 2:
                                                client_password_valid=false;
                                                System.out.println("Goodbye Mr/Ms "+client_compte.client.getPrenom()+" "+client_compte.client.getNom()+"!");
                                                break;
                                        }

                                    }
                                    
                                    break;
                                
                                case 1:
                                    break;

                                case 2:
                                    client_status=false;
                                    break;

                                }
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
