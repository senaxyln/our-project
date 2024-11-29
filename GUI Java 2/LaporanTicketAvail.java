import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LaporanTicketAvail extends JFrame implements ActionListener {
    JTable tbLaporanTicketAvail;
    JScrollPane spane;
    JLabel lblJudul;
    JTextField txtSearch;
    JButton btnSearch, btnRefresh, btnTambah, btnUbah, btnHapus;

    String[] kolom = {"Nama Artis", "Kategori Tiket", "Harga Tiket"};
    Object[][] isi = {
        {"Alan Walker", "Diamond, Ruby, Gold, Silver", "4.000.000, 3.000.000, 2.000.000, 1.250.000"},
        {"Lucas", "Diamond, Ruby, Gold, Silver", "4.000.000, 3.000.000, 2.000.000, 1.250.000"},
        {"Kim Seonho", "Diamond, Ruby, Gold, Silver", "4.000.000, 3.000.000, 2.000.000, 1.250.000"},
        {"Doh Kyungsoo", "Diamond, Ruby, Gold, Silver", "4.000.000, 3.000.000, 2.000.000, 1.250.000"},
        {"IVE", "Diamond, Ruby, Gold, Silver", "4.000.000, 3.000.000, 2.000.000, 1.250.000"}
    };

    public LaporanTicketAvail() {
        this.setTitle("Laporan Tiket Tersedia");
        this.setLayout(new BorderLayout());

        lblJudul = new JLabel("Laporan Tiket Tersedia", SwingConstants.CENTER);
        lblJudul.setFont(new Font("Tahoma", Font.BOLD, 16));
        this.add(lblJudul, BorderLayout.NORTH);

        tbLaporanTicketAvail = new JTable(new DefaultTableModel(isi, kolom));
        spane = new JScrollPane(tbLaporanTicketAvail);
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
                    tbLaporanTicketAvail.setModel(searchModel);
                }
            }
        });

        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengembalikan tabel ke data asli
                DefaultTableModel originalModel = new DefaultTableModel(isi, kolom);
                tbLaporanTicketAvail.setModel(originalModel);
            }
        });

        this.add(panelSearch, BorderLayout.NORTH);

        // Panel operasi dengan tombol "Tambah", "Ubah", dan "Hapus"
        JPanel panelOperasi = new JPanel(new FlowLayout());
        btnTambah = new JButton("Tambah");
        btnUbah = new JButton("Ubah");
        btnHapus = new JButton("Hapus");

        panelOperasi.add(btnTambah);
        panelOperasi.add(btnUbah);
        panelOperasi.add(btnHapus);

        btnTambah.addActionListener(this);
        btnUbah.addActionListener(this);
        btnHapus.addActionListener(this);

        this.add(panelOperasi, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTambah) {
            // Fungsi untuk menambah data tiket
            String namaArtis = JOptionPane.showInputDialog(null, "Masukkan Nama Artis:");
            String kategoriTiket = JOptionPane.showInputDialog(null, "Masukkan Kategori Tiket:");
            String hargaTiket = JOptionPane.showInputDialog(null, "Masukkan Harga Tiket:");

            // Tambahkan data baru ke tabel
            DefaultTableModel model = (DefaultTableModel) tbLaporanTicketAvail.getModel();
            model.addRow(new Object[]{namaArtis, kategoriTiket, hargaTiket});
        } else if (e.getSource() == btnUbah) {
            // Fungsi untuk mengubah data tiket
            int selectedRow = tbLaporanTicketAvail.getSelectedRow();
            if (selectedRow != -1) {
                String namaArtis = JOptionPane.showInputDialog(null, "Masukkan Nama Artis Baru:");
                String kategoriTiket = JOptionPane.showInputDialog(null, "Masukkan Kategori Tiket Baru:");
                String hargaTiket = JOptionPane.showInputDialog(null, "Masukkan Harga Tiket Baru:");

                DefaultTableModel model = (DefaultTableModel) tbLaporanTicketAvail.getModel();
                model.setValueAt(namaArtis, selectedRow, 0);
                model.setValueAt(kategoriTiket, selectedRow, 1);
                model.setValueAt(hargaTiket, selectedRow, 2);
            } else {
                JOptionPane.showMessageDialog(null, "Pilih baris yang akan diubah.");
            }
        } else if (e.getSource() == btnHapus) {
            // Fungsi untuk menghapus data tiket
            int selectedRow = tbLaporanTicketAvail.getSelectedRow();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) tbLaporanTicketAvail.getModel();
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(null, "Pilih baris yang akan dihapus.");

                lTicketAvail.addActionListener(e -> new LaporanTicketAvail().setVisible(true));
            }
        }
    }
}