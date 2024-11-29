import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/oneticket_db";
        String username = "root"; // default username untuk XAMPP
        String password = ""; // default password untuk XAMPP adalah kosong

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to MySQL database");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to MySQL database");
        }
    }
}
