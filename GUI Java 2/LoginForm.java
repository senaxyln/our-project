import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

// User class to represent user data
class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}

// Login form for authentication
public class LoginForm extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JComboBox<String> cbRole;
    private JButton btnLogin;
    private JButton btnCancel;
    private Map<String, User> userDatabase;

    public LoginForm() {
        initUserData();
        initComponents();
    }

    private void initUserData() {
        userDatabase = new HashMap<>();
        userDatabase.put("admin", new User("admin", "54321", "Admin"));
        userDatabase.put("customer", new User("customer", "12345", "Customer"));
    }

    private void initComponents() {
        JLabel lblRole = new JLabel("Role:");
        lblRole.setForeground(Color.WHITE); // Mengatur warna teks menjadi putih

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.WHITE); // Mengatur warna teks menjadi putih

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.WHITE); // Mengatur warna teks menjadi putih

        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField(15);

        cbRole = new JComboBox<>(new String[]{"Admin", "Customer"});
        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");

        // Set preferred size for components
        lblRole.setPreferredSize(new Dimension(400, 50));
        lblUsername.setPreferredSize(new Dimension(400, 50));
        lblPassword.setPreferredSize(new Dimension(400, 50));
        txtUsername.setPreferredSize(new Dimension(700, 50));
        txtPassword.setPreferredSize(new Dimension(700, 50));
        cbRole.setPreferredSize(new Dimension(500, 50));
        btnLogin.setPreferredSize(new Dimension(200, 30));
        btnCancel.setPreferredSize(new Dimension(200, 30));

        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set background color to simulate a galaxy effect
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(18, 31, 45); // Dark blue
                Color color2 = new Color(63, 51, 103); // Purple
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        setContentPane(contentPane);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(lblRole);
        add(cbRole);
        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(txtPassword);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnCancel);
        add(buttonPanel);

        btnLogin.addActionListener(e -> btnLoginActionPerformed(e));
        btnCancel.addActionListener(e -> {
            txtUsername.setText("");
            txtPassword.setText("");
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void btnLoginActionPerformed(ActionEvent evt) {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        String selectedRole = (String) cbRole.getSelectedItem();

        User user = userDatabase.get(username);

        if (user != null && user.getPassword().equals(password) && user.getRole().equalsIgnoreCase(selectedRole)) {
            JOptionPane.showMessageDialog(this, "Login berhasil sebagai " + selectedRole + "!");

            dispose(); // Close the login frame

            // Redirect based on role
            if (user.getRole().equalsIgnoreCase("Admin")) {
                new AdminMenu().setVisible(true);
            } else if (user.getRole().equalsIgnoreCase("Customer")) {
                new CustomerMenu().setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Username, password, atau role salah!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}