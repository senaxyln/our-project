import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LaporanPenjualan extends JFrame {
    JTable tbLaporanPenjualan;
    DefaultTableModel model;
    JScrollPane spane;
    JLabel lblJudul;
    JTextField txtSearch;
    JButton btnSearch, btnRefresh, btnTambah, btnUbah, btnHapus;

    public LaporanPenjualan() {
        this.setTitle("Laporan Penjualan");
        this.setLayout(new BorderLayout());

        lblJudul = new JLabel("Laporan Penjualan", SwingConstants.CENTER);
        lblJudul.setFont(new Font("Tahoma", Font.BOLD, 16));
        this.add(lblJudul, BorderLayout.NORTH);

        // Kolom untuk tabel
        String[] kolom = {
            "Nama Pelanggan",
            "Jenis Kelamin",
            "Kategori Tiket",
            "Harga Tiket",
            "Jumlah Tiket",
            "Nama Artis",
            "Total Harga"
        };

        model = new DefaultTableModel(kolom, 0);

        // Tambahkan data penjualan ke model tabel
        for (Object[] data : Penjualan.dataPenjualan) {
            model.addRow(data);
        }

        tbLaporanPenjualan = new JTable(model);
        spane = new JScrollPane(tbLaporanPenjualan);
        this.add(spane, BorderLayout.CENTER);

        // Panel pencarian dengan tombol "Search" dan "Refresh"
        JPanel panelSearch = new JPanel(new FlowLayout());
        txtSearch = new JTextField(15);
        btnSearch = new JButton("Search");
        btnRefresh = new JButton("Refresh");

        panelSearch.add(new JLabel("Cari Pelanggan:"));
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
                    for (Object[] row : Penjualan.dataPenjualan) {
                        if (row[0].toString().contains(searchQuery)) {
                            searchModel.addRow(row);
                        }
                    }
                    tbLaporanPenjualan.setModel(searchModel);
                }
            }
        });

        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengembalikan tabel ke data asli
                model.setRowCount(0); // Hapus semua baris
                for (Object[] data : Penjualan.dataPenjualan) {
                    model.addRow(data);
                }
                tbLaporanPenjualan.setModel(model);
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

        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fungsi tambah data
                Object[] newRow = {
                    "Pelanggan Baru",
                    "Jenis Kelamin",
                    "Kategori",
                    "Harga Tiket",
                    1,
                    "Artis",
                    "Total Harga"
                };
                model.addRow(newRow);
                Penjualan.dataPenjualan.add(newRow);
            }
        });

        btnUbah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tbLaporanPenjualan.getSelectedRow();
                if (selectedRow >= 0) {
                    Object[] rowData = new Object[kolom.length];
                    for (int i = 0; i < kolom.length; i++) {
                        rowData[i] = tbLaporanPenjualan.getValueAt(selectedRow, i);
                    }

                    // Ubah nama pelanggan
                    String newName = JOptionPane.showInputDialog("Masukkan Nama Pelanggan Baru:");
                    if (newName != null && !newName.trim().isEmpty()) {
                        rowData[0] = newName;
                    }

                    // Ubah jenis kelamin
                    String newGender = JOptionPane.showInputDialog("Masukkan Jenis Kelamin Baru:");
                    if (newGender != null && !newGender.trim().isEmpty()) {
                        rowData[1] = newGender;
                    }

                    // Ubah kategori tiket
                    String newCategory = JOptionPane.showInputDialog("Masukkan Kategori Tiket Baru:");
                    if (newCategory != null && !newCategory.trim().isEmpty()) {
                        rowData[2] = newCategory;
                    }

                    // Ubah harga tiket
                    String newPrice = JOptionPane.showInputDialog("Masukkan Harga Tiket Baru:");
                    if (newPrice != null && !newPrice.trim().isEmpty()) {
                        rowData[3] = newPrice;
                        // Menghitung total harga
                        int quantity = Integer.parseInt(rowData[4].toString());
                        int price = Integer.parseInt(newPrice.replace(".", ""));
                        rowData[6] = quantity * price;
                    }

                    // Ubah jumlah tiket
                    String newQuantity = JOptionPane.showInputDialog("Masukkan Jumlah Tiket Baru:");
                    if (newQuantity != null && !newQuantity.trim().isEmpty()) {
                        rowData[4] = newQuantity;
                        // Menghitung total harga
                        int quantity = Integer.parseInt(newQuantity);
                        int price = Integer.parseInt(rowData[3].toString().replace(".", ""));
                        rowData[6] = quantity * price;
                    }

                    // Memperbarui model tabel dengan data yang telah diubah
                    for (int i = 0; i < kolom.length; i++) {
                        model.setValueAt(rowData[i], selectedRow, i);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang akan diubah.");
                }
            }
        });

        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tbLaporanPenjualan.getSelectedRow();
                if (selectedRow >= 0) {
                    model.removeRow(selectedRow);
                    Penjualan.dataPenjualan.remove(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang akan dihapus.");
                }
            }
        });

        this.add(panelOperasi, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}