// deklarasi pustaka
import java.util.Scanner;

// main class
class Balok {

    //main method
    public static void main(String[]args){
        
        //deklarasi object scanner
        Scanner sc = new Scanner(System.in);
        
        //deklarasi variabel
        double panjang;
        double lebar;
        double tinggi;
        double volume;

        //input program
        System.out.println("Program Penghitung bangun ruang");
        System.out.print("Masukan panjang: ");
        panjang = sc.nextDouble();
        System.out.print("Masukan lebar: ");
        lebar = sc.nextDouble();
        System.out.print("Masukan tinggi: ");
        tinggi = sc.nextDouble();

        volume= panjang * lebar * tinggi;

        // output program
        System.out.println("");
        System.out.print("Volume Balok: " +volume);
        System.out.print(" cm^3");

        sc.close();
    }
}