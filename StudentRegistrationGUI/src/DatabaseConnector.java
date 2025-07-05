import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnector {

    public static Connection connectToAccessDatabase() {
        Connection connection = null;

        String dbPath = "jdbc:ucanaccess://path/to/your/VUE_Exhibition.accdb";

        try {
            System.out.println("Attempting to connect to database...");
            connection = DriverManager.getConnection(dbPath);
            System.out.println("Connection to Access database established successfully!");

        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Failed to connect to the database.\nError: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return connection;
    }
}
