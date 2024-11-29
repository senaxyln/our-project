import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GuiJadwalArtis extends JFrame {
    JTable tb_JadwalArtis;
    JScrollPane spane;
    JLabel lbl_judul;

    public GuiJadwalArtis() {
        this.setTitle("Jadwal Konser Artis");
        this.setLayout(new BorderLayout());

        lbl_judul = new JLabel("Jadwal Konser Artis", SwingConstants.CENTER);
        lbl_judul.setFont(new Font("Tahoma", Font.BOLD, 16));
        this.add(lbl_judul, BorderLayout.NORTH);

        // Kolom dan data jadwal artis
        String[] kolom = { "Nama Artis", "Tanggal Konser", "Tempat Konser" };
        Object[][] isi = {
            { "Alan Walker", "08 Juni 2024", "Banten" },
            { "Lucas", "11 Mei 2024", "Jakarta" },
            { "Kim Seonho", "27 Juli 2024", "Jakarta" },
            { "Doh Kyungsoo", "12 Juli 2024", "Jakarta" },
            { "IVE", "24 Agustus 2024", "Banten" }
        };

        tb_JadwalArtis = new JTable(new DefaultTableModel(isi, kolom));
        spane = new JScrollPane(tb_JadwalArtis);
        this.add(spane, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        this.setSize(600, 300); 
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }
}