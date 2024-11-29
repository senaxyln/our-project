// deklarasi pustaka
import java.util.Scanner;

// main class
class Prisma {

    //main method
    public static void main(String[]args){
        
        //deklarasi object scanner
        Scanner sc = new Scanner(System.in);
        
        //deklarasi variabel
        double alas;
        double tinggi;
        double volume;

        //input program
        System.out.println("Program Penghitung bangun ruang");
        System.out.print("Masukan alas: ");
        alas = sc.nextDouble();
        System.out.print("Masukan tinggi: ");
        tinggi = sc.nextDouble();

        volume= alas * tinggi;

        // output program
        System.out.println("");
        System.out.print("Volume Prisma: " +volume);
        System.out.print(" cm^3");

        sc.close();
    }
}