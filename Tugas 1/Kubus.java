// deklarasi pustaka
import java.util.Scanner;

// main class
class Kubus {

    //main method
    public static void main(String[]args){
        
        //deklarasi object scanner
        Scanner sc = new Scanner(System.in);
        
        //deklarasi variabel
        double sisi;
        double volume;

        //input program
        System.out.println("Program Penghitung bangun ruang");
        System.out.print("Masukan sisi: ");
        sisi = sc.nextDouble();
        System.out.print("Masukan sisi: ");
        sisi = sc.nextDouble();
        System.out.print("Masukan sisi: ");
        sisi = sc.nextDouble();

        volume= sisi * sisi * sisi;

        // output program
        System.out.println("");
        System.out.print("Volume Kubus: " +volume);
        System.out.print(" cm^3");

        sc.close();
    }
}