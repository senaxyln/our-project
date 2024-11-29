import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerMenu extends JFrame implements ActionListener {
    JMenuBar mainMenuBar = new JMenuBar();
    JMenu menuData = new JMenu("Master Data");

    public CustomerMenu() {
        this.setTitle("Event Menu Example");

        // Tambahkan item menu untuk Master Data
        JMenuItem dJadwalArtis = new JMenuItem("Menu Jadwal Artis");
        JMenuItem dTicketAvail = new JMenuItem("Menu Tiket Tersedia");
        JMenuItem dPenjualan = new JMenuItem("Menu Penjualan");

        menuData.add(dJadwalArtis);
        menuData.add(dTicketAvail);
        menuData.add(dPenjualan);

        mainMenuBar.add(menuData);

        this.setJMenuBar(mainMenuBar);

        dJadwalArtis.addActionListener(this);
        dTicketAvail.addActionListener(this);
        dPenjualan.addActionListener(this);

        // Set background color to simulate a galaxy effect
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(18, 31, 45); // Dark blue
                Color color2 = new Color(63, 51, 103); // Purple
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        contentPane.setLayout(new BorderLayout());

        JLabel lblWelcome = new JLabel("Selamat Datang di Menu Utama!", SwingConstants.CENTER);
        lblWelcome.setForeground(Color.WHITE); // Set warna teks menjadi putih agar terlihat di atas latar belakang gelap
        contentPane.add(lblWelcome, BorderLayout.CENTER);

        this.setContentPane(contentPane); // Gunakan contentPane yang sudah diberi warna latar belakang
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tutup tanpa mengakhiri aplikasi utama
        this.setSize(600, 400); // Ukuran frame
        this.setLocationRelativeTo(null); // Pusatkan frame pada layar
        this.setVisible(true); // Tampilkan frame
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String menuItem = ae.getActionCommand();

        if (menuItem.equals("Menu Jadwal Artis")) {
            new GuiJadwalArtis().setVisible(true);
        } else if (menuItem.equals("Menu Tiket Tersedia")) {
            new GuiTicketAvail().setVisible(true);
        } else if (menuItem.equals("Menu Penjualan")) {
            new GuiPenjualan().setVisible(true);
        }
    }


    public static void main(String[] args) {
        new CustomerMenu();
    }
}
