package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;


public class Database {
    
    private static Connection connect;
    private static Database bcon;
    private static final String URL = "jdbc:mysql://localhost:3306/dcms?";
    private static final String USER = "root"; // Change if necessary
    private static final String PASSWORD = ""; // Set your actual password here

    public Database() {
        try {
            
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Database getDatabase() {
        if (bcon == null) {
            bcon = new Database();
        }
        return bcon;
    }

    public static Connection getConnection() {
        if (bcon == null) {
            getDatabase();
        }
        return connect;
    }

    public static void main(String[] args) {
        Connection connection = Database.getConnection();
        if (connection != null) {
            System.out.println("CONNECTION IS READY TO USE");
        } else {
            System.err.println("FAILED TO ESTABLISH CONNECTION");
        }
    }
    
}

