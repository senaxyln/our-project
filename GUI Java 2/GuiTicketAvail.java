import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GuiTicketAvail extends JFrame {
    JTable tb_TicketAvail;
    JScrollPane spane;
    JLabel lbl_judul;

    public GuiTicketAvail() {
        this.setTitle("Tiket Tersedia");
        this.setLayout(new BorderLayout());

        lbl_judul = new JLabel("Tiket Tersedia", SwingConstants.CENTER);
        lbl_judul.setFont(new Font("Tahoma", Font.BOLD, 16));
        this.add(lbl_judul, BorderLayout.NORTH);

        // Kolom dan data tiket yang tersedia
        String[] kolom = { "Nama Artis", "Kategori Tiket", "Harga Tiket" };
        Object[][] isi = {
            { "Alan Walker", "Diamond, Ruby, Gold, Silver", "4.000.000, 3.000.000, 2.000.000, 1.250.000" },
            { "Lucas", "Diamond, Ruby, Gold, Silver", "4.000.000, 3.000.000, 2.000.000, 1.250.000" },
            { "Kim Seonho", "Diamond, Ruby, Gold, Silver", "4.000.000, 3.000.000, 2.000.000, 1.250.000" },
            { "Doh Kyungsoo", "Diamond, Ruby, Gold, Silver", "4.000.000, 3.000.000, 2.000.000, 1.250.000" },
            { "IVE", "Diamond, Ruby, Gold, Silver", "4.000.000, 3.000.000, 2.000.000, 1.250.000" }
        };

        tb_TicketAvail = new JTable(new DefaultTableModel(isi, kolom));
        spane = new JScrollPane(tb_TicketAvail);
        this.add(spane, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        this.setSize(800, 300); 
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }
}