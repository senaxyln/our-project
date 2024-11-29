import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class class_koneksi {
    // JDBC URL, username, dan password database
    private static final String JDBC_URL = "jdbc:sqlserver://localhost\\LAPTOP-M15DRKU9\\MSSQLSERVER1:1433;databaseName=db_ticket;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "54321";

    public Connection getConSQL() {
        Connection connection = null;

        try {
            // Membuat koneksi
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Koneksi ke database berhasil!");
        } catch (SQLException e) {
            System.err.println("Error saat membuat koneksi: " + e.getMessage());
            e.printStackTrace(); // Menampilkan stack trace untuk informasi lebih lanjut
        }

        return connection;
    }
}