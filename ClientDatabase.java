package dental_clinic_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClientDatabase {

    private static final String url = "jdbc:mysql://localhost:3306/dcms";  // Change with your DB details
    private static final String user = "root";  // Your DB username
    private static final String password = ""; // Your DB password
    private Connection con;

    // Constructor to initialize the database connection
    public ClientDatabase() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get connection method
    public Connection getConnection() {
        return con;
    }

    // Method to save client data
    public void saveClient(String username, String password, String email) {
        try {
            // SQL query to insert data into registration table
            String sql = "INSERT INTO registration (Username, Password, Email) VALUES (?, ?, ?)";

            // Prepare the statement to prevent SQL injection
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);  // Note: Ideally, you should hash the password before saving it
            statement.setString(3, email);

            // Execute the query
            int rowsInserted = statement.executeUpdate();

            // Check if insertion was successful
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Registration successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to register the client.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while saving data.");
        }
    }

    // Method to close the connection (optional but recommended)
    public void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
