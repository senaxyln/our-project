import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LaporanJadwalArtis extends JFrame implements ActionListener {
    JTable tbLaporanJadwalArtis;
    JScrollPane spane;
    JLabel lblJudul;
    JTextField txtSearch;
    JButton btnSearch, btnRefresh, btnTambah, btnHapus;

    String[] kolom = {"Nama Artis", "Tanggal Konser", "Tempat Konser"};
    Object[][] isi = {
        {"Alan Walker", "08 Juni 2024", "Banten"},
        {"Lucas", "11 Mei 2024", "Jakarta"},
        {"Kim Seonho", "27 Juli 2024", "Jakarta"},
        {"Doh Kyungsoo", "12 Juli 2024", "Jakarta"},
        {"IVE", "24 Agustus 2024", "Banten"}
    };

    public LaporanJadwalArtis() {
        this.setTitle("Laporan Jadwal Artis");
        this.setLayout(new BorderLayout());

        lblJudul = new JLabel("Laporan Jadwal Artis", SwingConstants.CENTER);
        lblJudul.setFont(new Font("Tahoma", Font.BOLD, 16));
        this.add(lblJudul, BorderLayout.NORTH);

        tbLaporanJadwalArtis = new JTable(new DefaultTableModel(isi, kolom));
        spane = new JScrollPane(tbLaporanJadwalArtis);
        this.add(spane, BorderLayout.CENTER);

        // Panel pencarian dengan tombol "Search" dan "Refresh"
        JPanel panelSearch = new JPanel(new FlowLayout());
        txtSearch = new JTextField(15);
        btnSearch = new JButton("Search");
        btnRefresh = new JButton("Refresh");

        panelSearch.add(new JLabel("Cari Artis:"));
        panelSearch.add(txtSearch);
        panelSearch.add(btnSearch);
        panelSearch.add(btnRefresh);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fungsi pencarian
                String searchQuery = txtSearch.getText().trim();
                if (!searchQuery.isEmpty()) {
                    DefaultTableModel searchModel = new DefaultTableModel(kolom, 0);
                    for (Object[] row : isi) {
                        if (row[0].toString().toLowerCase().contains(searchQuery.toLowerCase())) {
                            searchModel.addRow(row);
                        }
                    }
                    tbLaporanJadwalArtis.setModel(searchModel);
                }
            }
        });

        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengembalikan tabel ke data asli
                DefaultTableModel originalModel = new DefaultTableModel(isi, kolom);
                tbLaporanJadwalArtis.setModel(originalModel);
            }
        });

        this.add(panelSearch, BorderLayout.NORTH);

        // Panel operasi dengan tombol "Tambah" dan "Hapus"
        JPanel panelOperasi = new JPanel(new FlowLayout());
        btnTambah = new JButton("Tambah");
        btnHapus = new JButton("Hapus");

        panelOperasi.add(btnTambah);
        panelOperasi.add(btnHapus);

        btnTambah.addActionListener(this);
        btnHapus.addActionListener(this);

        this.add(panelOperasi, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTambah) {
            // Fungsi untuk menambah jadwal artis
            String namaArtis = JOptionPane.showInputDialog(null, "Masukkan Nama Artis:");
            String tanggalKonser = JOptionPane.showInputDialog(null, "Masukkan Tanggal Konser:");
            String tempatKonser = JOptionPane.showInputDialog(null, "Masukkan Tempat Konser:");

            // Tambahkan data baru ke tabel
            DefaultTableModel model = (DefaultTableModel) tbLaporanJadwalArtis.getModel();
            model.addRow(new Object[]{namaArtis, tanggalKonser, tempatKonser});
        } else if (e.getSource() == btnHapus) {
            // Fungsi untuk menghapus jadwal artis
            int selectedRow = tbLaporanJadwalArtis.getSelectedRow();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) tbLaporanJadwalArtis.getModel();
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(null, "Pilih baris yang akan dihapus.");

                lJadwalArtis.addActionListener(e -> new LaporanJadwalArtis().setVisible(true));
            }
        }
    }
}