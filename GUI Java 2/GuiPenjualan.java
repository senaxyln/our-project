import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;

public class GuiPenjualan extends JFrame {
    JLabel lbl_judul, lbl_nama, lbl_kategori, lbl_harga, lbl_artis, lbl_jumlah, lbl_jenisKelamin, lbl_totalHarga;
    JTextField txtNama, txtJumlah;
    JComboBox<String> cmbKategori, cmbHarga, cmbArtis;
    JRadioButton rbLaki, rbPerempuan;
    ButtonGroup bgJenisKelamin;
    JButton btnBeli;

    HashMap<String, String[]> hargaPerKategori = new HashMap<>(); // Daftar harga berdasarkan kategori

    public GuiPenjualan() {
        this.setTitle("Menu Penjualan");
        this.setLayout(null);

        lbl_judul = new JLabel("Menu Penjualan");
        lbl_judul.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbl_judul.setBounds(10, 5, 180, 22);
        this.add(lbl_judul);

        lbl_nama = new JLabel("Nama Pelanggan");
        lbl_nama.setBounds(10, 40, 120, 22);
        txtNama = new JTextField();
        txtNama.setBounds(140, 40, 200, 22);
        this.add(lbl_nama);
        this.add(txtNama);

        lbl_jenisKelamin = new JLabel("Jenis Kelamin");
        lbl_jenisKelamin.setBounds(10, 70, 120, 22);
        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");
        bgJenisKelamin = new ButtonGroup();
        bgJenisKelamin.add(rbLaki);
        bgJenisKelamin.add(rbPerempuan);
        rbLaki.setBounds(140, 70, 100, 22);
        rbPerempuan.setBounds(240, 70, 100, 22);
        this.add(lbl_jenisKelamin);
        this.add(rbLaki);
        this.add(rbPerempuan);

        lbl_kategori = new JLabel("Kategori Tiket");
        lbl_kategori.setBounds(10, 100, 120, 22);
        cmbKategori = new JComboBox<>(new String[]{"Diamond", "Ruby", "Gold", "Silver"});
        cmbKategori.setBounds(140, 100, 200, 22);
        this.add(lbl_kategori);
        this.add(cmbKategori);

        lbl_harga = new JLabel("Harga Tiket");
        lbl_harga.setBounds(10, 130, 120, 22);
        cmbHarga = new JComboBox<>(new String[]{"4.000.000", "3.000.000", "2.000.000", "1.250.000"});
        cmbHarga.setBounds(140, 130, 200, 22);
        this.add(lbl_harga);
        this.add(cmbHarga);

        lbl_jumlah = new JLabel("Jumlah Tiket");
        lbl_jumlah.setBounds(10, 160, 120, 22);
        txtJumlah = new JTextField();
        txtJumlah.setBounds(140, 160, 200, 22);
        this.add(lbl_jumlah);
        this.add(txtJumlah);

        lbl_artis = new JLabel("Nama Artis");
        lbl_artis.setBounds(10, 190, 120, 22);
        cmbArtis = new JComboBox<>(new String[]{"Alan Walker", "Lucas", "Kim Seonho", "Doh Kyungsoo", "IVE"});
        cmbArtis.setBounds(140, 190, 200, 22);
        this.add(lbl_artis);
        this.add(cmbArtis);

        lbl_totalHarga = new JLabel("Total Harga");
        lbl_totalHarga.setBounds(10, 220, 120, 22);
        JLabel lblTotalValue = new JLabel("-");
        lblTotalValue.setBounds(140, 220, 200, 22);
        this.add(lbl_totalHarga);
        this.add(lblTotalValue);

        // Daftar harga untuk setiap kategori
        hargaPerKategori.put("Diamond", new String[]{"4.000.000", "4.500.000", "5.000.000"});
        hargaPerKategori.put("Ruby", new String[]{"3.000.000", "3.500.000", "4.000.000"});
        hargaPerKategori.put("Gold", new String[]{"2.000.000", "2.500.000", "3.000.000"});
        hargaPerKategori.put("Silver", new String[]{"1.250.000", "1.500.000", "1.750.000"});

        cmbKategori.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateHarga();
            }
        });

        cmbKategori.setSelectedIndex(0); // Memicu perubahan item untuk mengisi harga tiket

        btnBeli = new JButton("Beli");
        btnBeli.setBounds(10, 250, 120, 30);
        btnBeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nama = txtNama.getText();
                    String kategori = cmbKategori.getSelectedItem().toString();
                    String hargaTiket = cmbHarga.getSelectedItem().toString();
                    int jumlah = Integer.parseInt(txtJumlah.getText());

                    // Menghitung total harga
                    int hargaPer = Integer.parseInt(hargaTiket.replace(".", ""));
                    int totalHarga = hargaPer * jumlah;

                    // Mengambil jenis kelamin
                    String jenisKelamin = rbLaki.isSelected() ? "Laki-laki" : rbPerempuan.isSelected() ? "Perempuan" : "Tidak Diketahui";

                    lblTotalValue.setText("Rp " + totalHarga);

                    JOptionPane.showMessageDialog(
                        null,
                        "Data pelanggan:\nNama: " + nama + "\nJenis Kelamin: " + jenisKelamin + "\nKategori Tiket: " + kategori 
                        + "\nJumlah Tiket: " + jumlah + "\nTotal Harga: Rp " + totalHarga
                    );
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Masukkan jumlah tiket yang valid", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.add(btnBeli);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        this.setSize(400, 400); 
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }

    private void updateHarga() {
        String kategori = cmbKategori.getSelectedItem().toString();
        String[] hargaOptions = hargaPerKategori.get(kategori);
        cmbHarga.removeAllItems(); // Hapus semua item sebelum menambahkan yang baru
        for (String harga : hargaOptions) {
            cmbHarga.addItem(harga);
        }
        cmbHarga.setSelectedIndex(0); // Pilih item pertama secara default
    }
}