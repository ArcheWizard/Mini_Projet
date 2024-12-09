package mini_projet;

import javax.swing.*;
import java.awt.*;

public class BankApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public BankApp() {

        setTitle("Bank Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        
        mainPanel.add(createMainMenu(), "MainMenu");
        mainPanel.add(createClientMenu(), "ClientMenu");
        mainPanel.add(createGerantMenu(), "GerantMenu");
        mainPanel.add(createClientActions(), "ClientActions");
        mainPanel.add(createGerantActions(), "GerantActions");
        mainPanel.add(new JPanel(), "SignUp");
        mainPanel.add(new JPanel(),"Login");

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createMainMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel title = new JLabel("Welcome to the IFA Bank Application", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title);

        JButton gerantButton = new JButton("Gerant");
        gerantButton.setFont(new Font("Arial", Font.BOLD, 16));
        gerantButton.addActionListener(e -> cardLayout.show(mainPanel, "GerantMenu"));
        panel.add(gerantButton);

        JButton clientButton = new JButton("Client");
        clientButton.setFont(new Font("Arial", Font.BOLD, 16));
        clientButton.addActionListener(e -> cardLayout.show(mainPanel, "ClientMenu"));
        panel.add(clientButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton);

        return panel;
    }

    private JPanel createClientMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 7, 10, 15));

        JLabel title = new JLabel("Client Menu", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title);

        JButton loginButton = new JButton("Log In");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.addActionListener(e ->
        {
            clientLogin();
            cardLayout.show(mainPanel, "Login");});

        panel.add(loginButton);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setFont(new Font("Arial", Font.BOLD, 16));
        signupButton.addActionListener(e -> 
        {
           clientSignUp();
           cardLayout.show(mainPanel, "SignUp");});

        panel.add(signupButton);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        panel.add(backButton);

        return panel;
    }

    private JPanel createGerantMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel title = new JLabel("Gerant Menu", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title);

        JButton loginButton = new JButton("Log In");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "GerantActions"));
        panel.add(loginButton);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        panel.add(backButton);

        return panel;
    }

    private JPanel createClientActions() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));

        JLabel title = new JLabel("Client Actions", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title);

        JButton viewAccountButton = new JButton("View Account");
        viewAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewAccountButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "mzilllll"));
        panel.add(viewAccountButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.setFont(new Font("Arial", Font.BOLD, 16));
        depositButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "mizzzzlll"));
        panel.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 16));
        withdrawButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "mizzzzzl"));
        panel.add(withdrawButton);

        JButton transferButton = new JButton("Transfer");
        transferButton.setFont(new Font("Arial", Font.BOLD, 16));
        transferButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "mizzzll"));
        panel.add(transferButton);

        JButton logoutButton = new JButton("Log out");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.addActionListener(e -> cardLayout.show(mainPanel, "ClientMenu"));
        panel.add(logoutButton);

        return panel;
    }

    private JPanel createGerantActions() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1, 10, 8));

        JLabel title = new JLabel("Gerant Actions", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title);

        JButton viewClientsButton = new JButton("Afficher tous les clients");
        viewClientsButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewClientsButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "mizzzzzzzl"));
        panel.add(viewClientsButton);

        JButton viewAccountsButton = new JButton("Afficher tous les comptes");
        viewAccountsButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewAccountsButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "mzilllll"));
        panel.add(viewAccountsButton);

        JButton viewClientButton = new JButton("Afficher un client");
        viewAccountsButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewClientButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "mizzllll"));
        panel.add(viewClientButton);

        JButton viewAccountButton = new JButton("Afficher un compte");
        viewAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewAccountButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "mizzllll"));
        panel.add(viewAccountButton);

        JButton deleteAccountButton = new JButton("supprimer un compte");
        deleteAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        deleteAccountButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "mizzzzl"));
        panel.add(deleteAccountButton);

        JButton logoutButton = new JButton("Log Out");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        panel.add(logoutButton);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankApp::new);
    }

/* --------------------------------------------------------------------------------------
 kol option (login , singup , depot , ......) lzm ykoun 3ndha void kima elli louta !!!! 
 ----------------------------------------------------------------------------------------*/
    private void clientLogin() {
        JPanel LoginPanel = new JPanel(new GridLayout(6,8 ));

        JLabel cinLabel = new JLabel("CIN:");
        cinLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField cinField = new JTextField();
        cinField.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel passLabel = new JLabel("Pass:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPasswordField passField = new JPasswordField();
        passField.setFont(new Font("Arial", Font.BOLD, 16));

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));

        LoginPanel.add(cinLabel);
        LoginPanel.add(cinField);
        LoginPanel.add(passLabel);
        LoginPanel.add(passField);

        LoginPanel.add(submitButton);
        LoginPanel.add(backButton);

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "ClientMenu"));

        mainPanel.add(LoginPanel, "Login");

        submitButton.addActionListener(e -> {
            String cin = cinField.getText();
            String pass = new String(passField.getPassword());

            Client client = new Client(cin, pass);
            Banque.Login(client);

            if(Banque.Login(client)){
                JOptionPane.showMessageDialog(LoginPanel, "Login Successful! Welcome ");

                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "ClientActions");
            }
            else{
                JOptionPane.showMessageDialog(LoginPanel, "cin ou pass incorrecte !", "Error", JOptionPane.ERROR_MESSAGE);
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "ClientMenu");
            }
        });
    }


    private void clientSignUp() {
        JPanel signUpPanel = new JPanel(new GridLayout(10, 2));
    
        JLabel cinLabel = new JLabel("CIN:");
        cinLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField cinField = new JTextField();
        cinField.setFont(new Font("Arial", Font.BOLD, 16));
    
        JLabel nomLabel = new JLabel("Nom:");
        nomLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField nomField = new JTextField();
        nomField.setFont(new Font("Arial", Font.BOLD, 16));
    
        JLabel prenomLabel = new JLabel("Prenom:");
        prenomLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField prenomField = new JTextField();
        prenomField.setFont(new Font("Arial", Font.BOLD, 16));
    
        JLabel passLabel = new JLabel("Pass:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPasswordField passField = new JPasswordField();
        passField.setFont(new Font("Arial", Font.BOLD, 16));
    
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));

        signUpPanel.add(cinLabel);
        signUpPanel.add(cinField);
        signUpPanel.add(nomLabel);
        signUpPanel.add(nomField);
        signUpPanel.add(prenomLabel);
        signUpPanel.add(prenomField);
        signUpPanel.add(passLabel);
        signUpPanel.add(passField);
        signUpPanel.add(submitButton);

       
        signUpPanel.add(backButton);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "ClientMenu"));
    
        mainPanel.add(signUpPanel, "SignUp");
    
        submitButton.addActionListener(e -> {
            String cin = cinField.getText();
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            String pass = new String(passField.getPassword());
    
            if (cin.isEmpty() || nom.isEmpty() || prenom.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(signUpPanel, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            Client client = new Client(cin, nom, prenom, pass);
            Banque.Ajout_Client(client);

            JOptionPane.showMessageDialog(signUpPanel, "Sign-Up Successful! Welcome " + client.getNom());

                
            CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
            cardLayout.show(mainPanel, "ClientMenu");
            
        });
    }
}
    

