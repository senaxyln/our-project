import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM user_data WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Jika email dan password cocok
                request.setAttribute("successMessage", "Login successful!");
                request.getRequestDispatcher("BookingDetails.jsp").forward(request, response);
            } else {
                // Jika email atau password tidak cocok
                request.setAttribute("errorMessage", "Invalid email or password.");
                request.getRequestDispatcher("SignIn.jsp").forward(request, response);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error occurred: " + e.getMessage());
            request.getRequestDispatcher("SignIn.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error occurred: " + e.getMessage());
            request.getRequestDispatcher("SignIn.jsp").forward(request, response);
        }
    }
}
