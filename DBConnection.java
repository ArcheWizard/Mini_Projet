package mini_projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection { 
    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/banque";
    private final String user = "root";
    private final String password = "root";

    public DBConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    
    public Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            } else {
                connection = DriverManager.getConnection(url, user, password);
                return connection;
            }
        } catch (SQLException e) {
            System.out.println("Error obtaining connection: " + e.getMessage());
            return null;
        }
    }

    
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                //System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }

    
}

