package mini_projet;

import javax.swing.*;

import mini_projet.Transaction.Type_Transaction;

import java.awt.*;
//import java.awt.event.ActionEvent;

public class Interface {
    private static JFrame mainFrame;
    private static JPanel mainPanel;
    private static CardLayout cardLayout;

    public static void main() {
        setupMainFrame();
        showMainMenu();
    }

    // Setup the main frame with CardLayout
    private static void setupMainFrame() {
        mainFrame = new JFrame("Bank Management System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(700, 500);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    // Main Menu Panel
    private static void showMainMenu() {
        JPanel menuPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        JLabel welcomeLabel = new JLabel("Welcome to the Bank System", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton gerantButton = new JButton("Gerant Login");
        gerantButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton clientButton = new JButton("Client Options");
        clientButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));

        gerantButton.addActionListener(e -> showGerantLogin());
        clientButton.addActionListener(e -> showClientMenu());
        exitButton.addActionListener(e -> System.exit(0));

        menuPanel.add(welcomeLabel);
        menuPanel.add(gerantButton);
        menuPanel.add(clientButton);
        menuPanel.add(exitButton);

        mainPanel.add(menuPanel, "MainMenu");
        cardLayout.show(mainPanel, "MainMenu");
    }

    // Gerant Login Panel
    private static void showGerantLogin() {
        JPanel loginPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel cinLabel = new JLabel("CIN:");
        cinLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField cinField = new JTextField();
        cinField.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JPasswordField passField = new JPasswordField();
        passField.setFont(new Font("Arial", Font.BOLD, 16));

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));

        loginButton.addActionListener(e -> {
            String cin = cinField.getText();
            String pass = new String(passField.getPassword());

            Gerant gerant = new Gerant(cin, pass); // Simulated login check
            if (Banque.Login(gerant)) {
                JOptionPane.showMessageDialog(mainFrame, "Login Successful!");
                showGerantMenu(gerant);
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Invalid CIN or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));

        loginPanel.add(cinLabel);
        loginPanel.add(cinField);
        loginPanel.add(passLabel);
        loginPanel.add(passField);
        loginPanel.add(loginButton);
        loginPanel.add(backButton);

        mainPanel.add(loginPanel, "GerantLogin");
        cardLayout.show(mainPanel, "GerantLogin");
    }

    // Gerant Menu Panel
    private static void showGerantMenu(Gerant gerant) {
        JPanel gerantPanel = new JPanel(new GridLayout(7, 1, 10, 10));

        JButton viewClientsButton = new JButton("View All Clients");
        viewClientsButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton viewAccountsButton = new JButton("View All Accounts");
        viewAccountsButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton viewSpecificClientButton = new JButton("View Specific Client");
        viewSpecificClientButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton viewSpecificAccountButton = new JButton("View Specific Account");
        viewSpecificAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton deleteAccountButton = new JButton("Delete an Account");
        deleteAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));

        viewClientsButton.addActionListener(e -> {
            String allClients = Gerant.Consulter_Clients(); // Simulated method to get all clients
            JOptionPane.showMessageDialog(mainFrame, allClients, "All Clients", JOptionPane.INFORMATION_MESSAGE);
        });

        viewAccountsButton.addActionListener(e -> {
            String allAccounts = Gerant.Consulter_Comptes(); // Simulated method to get all accounts
            JOptionPane.showMessageDialog(mainFrame, allAccounts, "All Accounts", JOptionPane.INFORMATION_MESSAGE);
        });

        viewSpecificClientButton.addActionListener(e -> {
            String cin = JOptionPane.showInputDialog(mainFrame, "Enter Client CIN:");
            String clientDetails = Gerant.Consulter_Client(cin); // Simulated method for specific client
            if (clientDetails != null) {
                JOptionPane.showMessageDialog(mainFrame, clientDetails, "Client Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Client not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        viewSpecificAccountButton.addActionListener(e -> {
            String accountRef = JOptionPane.showInputDialog(mainFrame, "Enter Account Reference:");
            String accountDetails = Gerant.Consulter_Compte(accountRef);; // Simulated method for specific account
            if (accountDetails != null) {
                JOptionPane.showMessageDialog(mainFrame, accountDetails, "Account Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Account not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        deleteAccountButton.addActionListener(e -> {
            String cin = JOptionPane.showInputDialog(mainFrame, "Enter Client CIN to delete:");
            Client client = Banque.get_Client(cin);
            if (client!=null) {
                Gerant.Supprimer_Client(client); // Simulated delete account method
                JOptionPane.showMessageDialog(mainFrame, "Client deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Client deletion failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        logoutButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));
        JLabel gerantMenu = new JLabel("Gerant Menu", JLabel.CENTER);
        gerantMenu.setFont(new Font("Arial", Font.BOLD, 20));
        gerantPanel.add(gerantMenu);
        gerantPanel.add(viewClientsButton);
        gerantPanel.add(viewAccountsButton);
        gerantPanel.add(viewSpecificClientButton);
        gerantPanel.add(viewSpecificAccountButton);
        gerantPanel.add(deleteAccountButton);
        gerantPanel.add(logoutButton);

        mainPanel.add(gerantPanel, "GerantMenu");
        cardLayout.show(mainPanel, "GerantMenu");
    }

    // Client Menu Panel
    private static void showClientMenu() {
        JPanel clientPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton loginButton = new JButton("Log In");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));

        loginButton.addActionListener(e -> showClientLogin());
        signUpButton.addActionListener(e -> showClientSignUp());
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainMenu"));

        JLabel clientoptions = new JLabel("Client Options", JLabel.CENTER );
        clientoptions.setFont(new Font("Arial", Font.BOLD, 20));
        clientPanel.add(clientoptions);
        clientPanel.add(loginButton);
        clientPanel.add(signUpButton);
        clientPanel.add(backButton);

        mainPanel.add(clientPanel, "ClientMenu");
        cardLayout.show(mainPanel, "ClientMenu");
    }

    // Client Login and Operations Panel
    private static void showClientLogin() {
        JPanel loginPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel cinLabel = new JLabel("CIN:");
        cinLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField cinField = new JTextField();
        cinField.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JPasswordField passField = new JPasswordField();
        passField.setFont(new Font("Arial", Font.BOLD, 16));

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));

        loginButton.addActionListener(e -> {
            String cin = cinField.getText();
            String pass = new String(passField.getPassword());

            Client client = new Client(cin, pass); // Simulated login check
            if (Banque.Login(client)) {
                JOptionPane.showMessageDialog(mainFrame, "Login Successful!");
                client = Banque.get_Client(client);
                // Check if the client has an account
                if (Banque.get_Compte(client) == null) {
                    showNoAccountMenu(client);
                } else {
                    showClientAccountMenu(client);
                }
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Invalid CIN or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "ClientMenu"));

        loginPanel.add(cinLabel);
        loginPanel.add(cinField);
        loginPanel.add(passLabel);
        loginPanel.add(passField);
        loginPanel.add(loginButton);
        loginPanel.add(backButton);

        mainPanel.add(loginPanel, "ClientLogin");
        cardLayout.show(mainPanel, "ClientLogin");
    }

    // No Account Menu
    private static void showNoAccountMenu(Client client) {
        Client full_client = Banque.get_Client(client);
        JPanel noAccountPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JLabel messageLabel = new JLabel(
            "<html>You don't have an account.<br>Would you like to create one or log out?</html>",
            JLabel.CENTER
        );
        messageLabel.setFont(new Font("Arial", Font.BOLD, 15));

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));

        createAccountButton.addActionListener(e -> {
            Client.Ajout_Compte(full_client); // Simulated method to create an account for the client
            JOptionPane.showMessageDialog(mainFrame, "Account created successfully!");
            showClientAccountMenu(full_client);
        });

        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(mainFrame, "Logging out. Goodbye!");
            cardLayout.show(mainPanel, "ClientMenu");
        });

        noAccountPanel.add(messageLabel);
        noAccountPanel.add(createAccountButton);
        noAccountPanel.add(logoutButton);

        mainPanel.add(noAccountPanel, "NoAccountMenu");
        cardLayout.show(mainPanel, "NoAccountMenu");
    }

    // Client Account Menu
    private static void showClientAccountMenu(Client client) {
        JPanel accountPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        Compte compte = Banque.get_Compte(client);
        

        JButton viewAccountButton = new JButton("View Account");
        viewAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton depositButton = new JButton("Deposit Money");
        depositButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton withdrawButton = new JButton("Withdraw Money");
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton transferButton = new JButton("Transfer Money");
        transferButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton deleteAccountButton = new JButton("Delete Account");
        deleteAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));

        viewAccountButton.addActionListener(e -> {
            String accountDetails = compte.toString();
            JOptionPane.showMessageDialog(mainFrame, accountDetails, "Account Details", JOptionPane.INFORMATION_MESSAGE);
        });

        depositButton.addActionListener(e -> {
            String amountStr = JOptionPane.showInputDialog(mainFrame, "Enter amount to deposit:");
            double amount = Double.parseDouble(amountStr);
            Compte.Depot(compte, amount);
            Transaction transaction = new Transaction(compte.getRef_compte(), Type_Transaction.depot, amount);
            Banque.Ajout_Transaction(transaction);
            JOptionPane.showMessageDialog(mainFrame, "Deposited: " + amount);
        });

        withdrawButton.addActionListener(e -> {
            String amountStr = JOptionPane.showInputDialog(mainFrame, "Enter amount to withdraw:");
            double amount = Double.parseDouble(amountStr);
            Compte.Retrait(compte, amount);
            Transaction transaction = new Transaction(compte.getRef_compte(), Type_Transaction.retrait, amount);
            Banque.Ajout_Transaction(transaction);
            JOptionPane.showMessageDialog(mainFrame, "Withdrawn: " + amount);
        });

        transferButton.addActionListener(e -> {
            String recipientCIN = JOptionPane.showInputDialog(mainFrame, "Enter recipient CIN:");
            Client client_receiver = Banque.get_Client(recipientCIN);
            String amountStr = JOptionPane.showInputDialog(mainFrame, "Enter amount to transfer:");
            double amount = Double.parseDouble(amountStr);
            Compte.Transferer(compte, Banque.get_Compte(client_receiver), amount);
            Transaction transaction = new Transaction(compte.getRef_compte(), Type_Transaction.transfer, amount);
            Banque.Ajout_Transaction(transaction);
            JOptionPane.showMessageDialog(mainFrame, "Transferred: " + amount + " to CIN: " + recipientCIN);
        });

        deleteAccountButton.addActionListener(e -> {
            
            if (client.getCompte()!=null) {
                Client.Supprimer_Compte(compte);
                JOptionPane.showMessageDialog(mainFrame, "Account deleted successfully!");
                cardLayout.show(mainPanel, "ClientMenu");
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Account deletion failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        logoutButton.addActionListener(e -> cardLayout.show(mainPanel, "ClientMenu"));
        JLabel clientMenu =new JLabel("Client Account Menu", JLabel.CENTER);
        clientMenu.setFont(new Font("Arial", Font.BOLD, 20));
        accountPanel.add(clientMenu);
        accountPanel.add(viewAccountButton);
        accountPanel.add(depositButton);
        accountPanel.add(withdrawButton);
        accountPanel.add(transferButton);
        accountPanel.add(deleteAccountButton);
        accountPanel.add(logoutButton);

        mainPanel.add(accountPanel, "ClientAccountMenu");
        cardLayout.show(mainPanel, "ClientAccountMenu");
    }

    // Client Sign-Up Panel
    private static void showClientSignUp() {
        JPanel signUpPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        JLabel cinLabel = new JLabel("CIN:");
        cinLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField cinField = new JTextField();
        cinField.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField firstNameField = new JTextField();
        firstNameField.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField lastNameField = new JTextField();
        lastNameField.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JPasswordField passField = new JPasswordField();
        passField.setFont(new Font("Arial", Font.BOLD, 16));

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));

        signUpButton.addActionListener(e -> {
            String cin = cinField.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String pass = new String(passField.getPassword());

            if (!cin.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !pass.isEmpty()) {
                Client client = new Client(cin, lastName, firstName, pass);
                Banque.Ajout_Client(client); // Simulated method to add a client
                JOptionPane.showMessageDialog(mainFrame, "Sign-Up Successful!");
                cardLayout.show(mainPanel, "ClientMenu");
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "ClientMenu"));

        signUpPanel.add(cinLabel);
        signUpPanel.add(cinField);
        signUpPanel.add(firstNameLabel);
        signUpPanel.add(firstNameField);
        signUpPanel.add(lastNameLabel);
        signUpPanel.add(lastNameField);
        signUpPanel.add(passLabel);
        signUpPanel.add(passField);
        signUpPanel.add(signUpButton);
        signUpPanel.add(backButton);

        mainPanel.add(signUpPanel, "ClientSignUp");
        cardLayout.show(mainPanel, "ClientSignUp");
    }
}
