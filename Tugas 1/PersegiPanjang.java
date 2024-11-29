// deklarasi pustaka
import java.util.Scanner;

// main class
class PersegiPanjang {

    //main method
    public static void main(String[]args){
        
        //deklarasi object scanner
        Scanner sc = new Scanner(System.in);
        
        //deklarasi variabel
        double panjang;
        double lebar;
        double luas;

        //input program
        System.out.println("Program Penghitung bangun datar");
        System.out.print("Masukan panjang: ");
        panjang = sc.nextDouble();
        System.out.print("Masukan lebar: ");
        lebar = sc.nextDouble();

        luas= panjang * lebar;

        // output program
        System.out.println("");
        System.out.print("Luas Persegi Panjang: " +luas);
        System.out.print(" cm");

        sc.close();
    }
}