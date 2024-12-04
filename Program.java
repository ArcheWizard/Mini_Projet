package mini_projet;

public class Program {
    public static void main(String[] args) {
        Menu.client_sign_up();
        /* Client li 3mltah twa, a3ml bih log in */
        if(Menu.client_login()==true){
            System.out.println("Login successful!");
        }
        /* Lazmtna faza mt3 getClient ml database */
        Client client = new Client("7ot illi yji", "7ot illi yji", "7ot illi yji", "7ot illi yji");
        Menu.tester_compte(client);
        /* Isra 5edmt */
    }
}
