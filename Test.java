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
