// deklarasi pustaka
import java.util.Scanner;

// main class
class Persegi2 {

    //main method
    public static void main(String[]args){
        
        //deklarasi object scanner
        Scanner sc = new Scanner(System.in);
        
        //deklarasi variabel
        double sisi;
        double luas;

        //input program
        System.out.println("Program Penghitung bangun datar");
        System.out.print("Masukan sisi: ");
        sisi = sc.nextDouble();
        System.out.print("Masukan sisi: ");
        sisi = sc.nextDouble();

        luas= sisi * sisi;

        // output program
        System.out.println("");
        System.out.print("Luas Persegi: " +luas);
        System.out.print(" cm");

        sc.close();
    }
}