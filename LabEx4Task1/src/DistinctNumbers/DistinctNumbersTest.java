package DistinctNumbers;

import java.util.Scanner;

public class DistinctNumbersTest {


    public static void main(String[] args) {

        DistinctNumbers distinctNumbers = new DistinctNumbers();

        System.out.println("How many numbers would you like to enter? ");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        distinctNumbers.enterNumbersInArray(count);

        distinctNumbers.displayDistinctNumbers();
    }
}
