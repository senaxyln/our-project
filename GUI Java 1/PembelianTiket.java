import java.util.Scanner;

public class PembelianTiket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menampilkan daftar jenis tiket
        System.out.println("Tiket Konser");
        System.out.println("==============");
        System.out.println("Jenis Harga Tiket");
        System.out.println("1. Diamond --> Rp4.000.000");
        System.out.println("2. Ruby ------> Rp3.000.000");
        System.out.println("3. Gold ------> Rp2.000.000");
        System.out.println("4. Silver ----> Rp1.250.000");
        System.out.println("==============");

        // Meminta pengguna untuk memilih jenis tiket
        System.out.print("Masukkan pilihan Anda: ");
        int pilihan = scanner.nextInt();

        // Inisialisasi tiket berdasarkan pilihan pengguna
        TiketKonser tiket = null;
        switch (pilihan) {
            case 1:
                tiket = new TiketKonser("Diamond", 4000000);
                break;
            case 2:
                tiket = new TiketKonser("Ruby", 3000000);
                break;
            case 3:
                tiket = new TiketKonser("Gold", 2000000);
                break;
            case 4:
                tiket = new TiketKonser("Silver", 1250000);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                System.exit(0);
        }

        // Meminta pengguna untuk memasukkan jumlah tiket yang dibeli
        System.out.print("Masukkan jumlah tiket yang dibeli: ");
        int jumlahTiket = scanner.nextInt();

        // Menetapkan jumlah tiket yang dibeli
        tiket.setJumlahTiket(jumlahTiket);

        // Menampilkan ringkasan pembelian
        System.out.println("\nRingkasan Pembelian Tiket");
        System.out.println("===========================");
        System.out.println("Jenis Tiket   : " + tiket.getJenisTiket());
        System.out.println("Harga Tiket   : Rp " + tiket.getHargaTiket());
        System.out.println("Jumlah Tiket  : " + tiket.getJumlahTiket());
        System.out.println("Total Biaya  : Rp " + tiket.hitungTotalBiaya());
        System.out.println("===========================");

        scanner.close();
    }
}

class TiketKonser {
    private String jenisTiket;
    private int hargaTiket;
    private int jumlahTiket;

    public TiketKonser(String jenisTiket, int hargaTiket) {
        this.jenisTiket = jenisTiket;
        this.hargaTiket = hargaTiket;
    }

    public String getJenisTiket() {
        return jenisTiket;
    }

    public int getHargaTiket() {
        return hargaTiket;
    }

    public int getJumlahTiket() {
        return jumlahTiket;
    }

    public void setJumlahTiket(int jumlahTiket) {
        this.jumlahTiket = jumlahTiket;
    }

    public int hitungTotalBiaya() {
        return hargaTiket * jumlahTiket;
    }
}