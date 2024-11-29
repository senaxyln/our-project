// deklarasi pustaka
import java.util.Scanner;

// main class
class JajarGenjang {

    //main method
    public static void main(String[]args){
        
        //deklarasi object scanner
        Scanner sc = new Scanner(System.in);
        
        //deklarasi variabel
        double alas;
        double tinggi;
        double luas;

        //input program
        System.out.println("Program Penghitung bangun datar");
        System.out.print("Masukan alas: ");
        alas = sc.nextDouble();
        System.out.print("Masukan tinggi: ");
        tinggi = sc.nextDouble();

        luas= alas * tinggi;

        // output program
        System.out.println("");
        System.out.print("Luas Jajar Genjang: " +luas);
        System.out.print(" cm");

        sc.close();
    }
}