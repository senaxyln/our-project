import java.util.ArrayList;
import java.util.List;

public class Penjualan {
    public static List<Object[]> dataPenjualan = new ArrayList<>();

    // Menambahkan data penjualan baru
    public static void tambahPenjualan(Object[] data) {
        dataPenjualan.add(data);
    }

    // Mendapatkan semua data penjualan
    public static List<Object[]> getAllPenjualan() {
        return dataPenjualan;
    }

    // Mengubah data penjualan berdasarkan indeks
    public static void ubahPenjualan(int index, Object[] data) {
        if (index >= 0 && index < dataPenjualan.size()) {
            dataPenjualan.set(index, data);
        } else {
            System.err.println("Indeks tidak valid untuk ubahPenjualan");
        }
    }

    // Menghapus data penjualan berdasarkan indeks
    public static void hapusPenjualan(int index) {
        if (index >= 0 && index < dataPenjualan.size()) {
            dataPenjualan.remove(index);
        } else {
            System.err.println("Indeks tidak valid untuk hapusPenjualan");
        }
    }
}
