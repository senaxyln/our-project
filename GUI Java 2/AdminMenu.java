import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminMenu extends JFrame implements ActionListener {
    JMenuBar mainMenuBar = new JMenuBar();
    JMenu menuLaporan = new JMenu("Master Laporan");

    public AdminMenu() {
        this.setTitle("Admin Menu");

        JMenuItem lJadwalArtis = new JMenuItem("Laporan Jadwal Artis");
        JMenuItem lTicketAvail = new JMenuItem("Laporan Tiket Tersedia");
        JMenuItem lPenjualan = new JMenuItem("Laporan Penjualan");

        menuLaporan.add(lJadwalArtis);
        menuLaporan.add(lTicketAvail);
        menuLaporan.add(lPenjualan);

        mainMenuBar.add(menuLaporan);

        this.setJMenuBar(mainMenuBar);

        lJadwalArtis.addActionListener(this);
        lTicketAvail.addActionListener(this);
        lPenjualan.addActionListener(this);

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
        this.setContentPane(contentPane); // Set the content pane

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String menuItem = ae.getActionCommand();
        if (menuItem.equals("Laporan Jadwal Artis")) {
            new LaporanJadwalArtis().setVisible(true);
        } else if (menuItem.equals("Laporan Tiket Tersedia")) {
            new LaporanTicketAvail().setVisible(true);
        } else if (menuItem.equals("Laporan Penjualan")) {
            new LaporanPenjualan().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AdminMenu();
    }
}
