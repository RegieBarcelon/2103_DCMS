
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    
    private static Connection connect;
    private static Database bcon;
    private static String url = "jdbc:mysql://localhost:3306/bakeshopsystem";
    private static String user = "root";
    private static String password = "";
    
     public Database(){
           try {
        connect = DriverManager.getConnection(url, user, password);
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
}
