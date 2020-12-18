package Barcode;

import java.util.Scanner;

public class BarcodeTest {
    public static void main(String[] args) {

        int zip111 = 111;
        int zip254 = 254;

        Barcode barcode = new Barcode();

        System.out.println("zip 111: ");
        System.out.println(barcode.decode(zip111));

        System.out.println("zip 254: ");
        System.out.println(barcode.decode(zip254));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ZIP code: ");
        int userZIP = sc.nextInt();
        System.out.println(barcode.decode(userZIP));
    }
}
