import java.util.Scanner;

public class ConcertTicketAdmin {
    private static int totalTicketsAvailable = 100;
    private static int ticketsSold = 7;
    private static double ticketPrice = 2_000_000;

    // Metode untuk menjual tiket
    public static void sellTickets(int quantity) {
        if (quantity <= totalTicketsAvailable) {
            ticketsSold += quantity;
            totalTicketsAvailable -= quantity;
            System.out.println("Penjualan " + quantity + " tiket berhasil.");
        } else {
            System.out.println("Maaf, tiket tidak mencukupi.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu admin
        System.out.println("=== Admin Menu ===");
        System.out.println("1. Lihat Jumlah Tiket Terjual");
        System.out.println("2. Lihat Pendapatan");
        System.out.println("3. Keluar");
        
        boolean isAdminLoggedIn = true;

        while (isAdminLoggedIn) {
            System.out.print("Pilih opsi: ");
            if (scanner.hasNextInt()) { 
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Jumlah Tiket Terjual: " + ticketsSold);
                        break;
                    case 2:
                        double totalRevenue = ticketsSold * ticketPrice;
                        System.out.println("Pendapatan Total: Rp" + totalRevenue);
                        break;
                    case 3:
                        isAdminLoggedIn = false;
                        System.out.println("Keluar dari Menu Admin.");
                        break;
                    default:
                        System.out.println("Opsi tidak valid. Silakan pilih opsi 1, 2, atau 3.");
                }
            } else {
                System.out.println("Input tidak valid. Silakan masukkan nomor.");
                scanner.next(); 
            }
        }

        scanner.close();
    }
}
