import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class Authentication {
    private User[] users;

    // Konstruktor (tidak berubah)
    public Authentication() {
        // Inisialisasi data user (bisa dari database)
        users = new User[]{
                new User("admin", "54321", "Admin"),
                new User("customer", "12345", "Customer")
        };
    }

    // Method untuk melakukan login (tidak berubah)
    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Jika credentials cocok, kembalikan user
            }
        }
        return null; // Jika credentials tidak cocok, kembalikan null
    }
}

class User {
    private String username;
    private String password;
    private String role; // Admin atau Customer

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}

public class Main {
    private static final String CSV_FILE = "data.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Deklarasi scanner di dalam main
        while (true) { // Loop utama
            System.out.println("Selamat datang!");
            System.out.println("Silakan pilih peran Anda:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Keluar");
            System.out.print("Pilih peran (1/2/3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Menu Admin
                    menuAdmin(scanner); // Pass scanner ke metode menuAdmin
                    break;
                case 2:
                    // Menu Customer
                    menuCustomer(scanner); // Pass scanner ke metode menuCustomer
                    break;
                case 3:
                    // Keluar dari program
                    System.out.println("Terima kasih! Sampai jumpa lagi.");
                    scanner.close(); // Tutup scanner sebelum keluar
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih peran yang sesuai.");
                    break;
            }
        }
    }

    public static void menuAdmin(Scanner scanner) { // Terima scanner sebagai parameter
        Authentication authentication = new Authentication();

        // Meminta pengguna untuk memasukkan username dan password
        System.out.print("Masukkan username: ");
        String username = scanner.next();
        System.out.print("Masukkan password: ");
        String password = scanner.next();

        // Melakukan login menggunakan metode login dari Authentication
        User loggedInUser = authentication.login(username, password);

        // Memeriksa apakah login berhasil
        if (loggedInUser != null && loggedInUser.getRole().equals("Admin")) {
            System.out.println("Login berhasil sebagai Admin.");
            // Lanjutkan dengan menu Admin
            while (true) {
                System.out.println("\nMenu Admin:");
                System.out.println("1. Lihat data customer");
                System.out.println("2. Kembali ke menu awal");
                System.out.print("Pilih opsi: ");
                int adminChoice = scanner.nextInt();

                switch (adminChoice) {
                    case 1:
                        // Tampilkan data customer
                        displayDataCSV(CSV_FILE);
                        break;
                    case 2:
                        // Kembali ke menu awal
                        return;
                    default:
                        System.out.println("Opsi tidak valid.");
                        break;
                }
            }
        } else {
            System.out.println("Login gagal. Periksa kembali username dan password Anda.");
        }
    }

    public static void menuCustomer(Scanner scanner) { // Terima scanner sebagai parameter
        Authentication authentication = new Authentication();

        // Meminta pengguna untuk memasukkan username dan password
        System.out.print("Masukkan username: ");
        String username = scanner.next();
        System.out.print("Masukkan password: ");
        String password = scanner.next();

        // Melakukan login menggunakan metode login dari Authentication
        User loggedInUser = authentication.login(username, password);

        // Memeriksa apakah login berhasil
        if (loggedInUser != null && loggedInUser.getRole().equals("Customer")) {
            System.out.println("Login berhasil sebagai Customer.");
            // Lanjutkan dengan menu Customer
            while (true) {
                System.out.println("\nMenu Customer:");
                System.out.println("1. Tersedia Tiket Konser");
                System.out.println("2. Tambah Data Customer");
                System.out.println("3. Kembali ke menu awal");
                System.out.print("Pilih opsi: ");
                int customerChoice = scanner.nextInt();

                switch (customerChoice) {
                    case 1:
                    displayConcertTickets();
                    break;
                    case 2:
                        // Tambah data customer
                        inputDataCSV(CSV_FILE, scanner);
                        break;
                    case 3:
                        // Kembali ke menu awal
                        return;
                    default:
                        System.out.println("Opsi tidak valid.");
                        break;
                }
            }
        } else {
            System.out.println("Login gagal. Periksa kembali username dan password Anda.");
        }
    }

    public static void displayDataCSV(String csvFile) {
        try {
            // Baca semua baris dari file CSV
            Files.lines(Paths.get(csvFile))
                    .forEach(System.out::println); // Cetak setiap baris
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void inputDataCSV(String csvFile, Scanner scanner) { // Terima scanner sebagai parameter
        try {
            // Inisialisasi BufferedWriter untuk menulis ke file
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true));

            // Input data dari customer
            System.out.println("Masukkan data customer (Nama Customer,NIK,Email,Tanggal Lahir,Kategori Tiket): ");
            System.out.print("Nama: ");
            String nama = scanner.next();
            System.out.print("NIK: ");
            String nik = scanner.next();
            System.out.print("Email: ");
            String email = scanner.next();
            System.out.print("Tanggal Lahir: ");
            String tanggalLahir = scanner.next();
            System.out.print("Kategori Tiket: ");
            String kategoriTiket = scanner.next(); // Menambahkan permintaan input untuk kategori tiket

            // Tulis data ke file CSV
            writer.write(nama + "," + nik + "," + email + "," + tanggalLahir + "," + kategoriTiket + "\n");
            System.out.println("Data customer berhasil ditambahkan.");

            // Tutup writer setelah selesai
            writer.close();
        } catch (IOException e) {
            System.err.println("Error: Gagal menambahkan data customer. " + e.getMessage());
        }
    }

    public static void displayConcertTickets() {
        // Tambahkan logika untuk menampilkan tiket konser yang tersedia di sini
        System.out.println("Daftar Tiket Konser yang Tersedia:");
        // Contoh:
        System.out.println("1. Diamond --> Rp4.000.000 --> 80");
        System.out.println("2. Ruby ------> Rp3.000.000 --> 100");
        System.out.println("3. Gold ------> Rp2.000.000 --> 150");
        System.out.println("4. Silver ----> Rp1.250.000 --> 200");
        // Anda dapat mengganti dengan logika yang sesuai dengan aplikasi Anda
    }
}
