package dcm_2103.Control_Connector;
import java.sql.*;
import javax.swing.JOptionPane;

public class DBConnect {
   private static Connection connect;
    private static DBConnect dbconnect;
    private static String url = "jdbc:mysql://localhost:3306/dcms";
    private static String user = "root";
    private static String password = "";

    public static Connection getConnect() {
        return connect;
    }

    public static void setConnect(Connection connect) {
        DBConnect.connect = connect;
    }

    public static DBConnect getDbconnect() {
        return dbconnect;
    }

    public static void setDbconnect(DBConnect dbconnect) {
        DBConnect.dbconnect = dbconnect;
    }

    // Constructor to establish the connection
    public DBConnect() {
        connect = null;
        try {
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully.");
        } catch (Exception e) {
            e.printStackTrace(); // Log the error for debugging
        }
    }

    // n pattern to get the DBConnect instance
    public static DBConnect getDBConnect() {
        if (dbconnect == null) {
            dbconnect = new DBConnect();
        }
        return dbconnect;
    }

    // Method to retrieve the connection
    public static Connection getConnection() {
        if (connect == null) {
            getDBConnect(); // Initialize the connection if not already done
        }
        return connect;
    }

    // Main method for testing the DB connection
    public static void main(String[] args) {
        // Test the connection
        Connection connection = DBConnect.getConnection();
        if (connection != null) {
            System.out.println("Connection is ready to use.");
        } else {
            System.err.println("Failed to establish connection.");
        }
    }
}