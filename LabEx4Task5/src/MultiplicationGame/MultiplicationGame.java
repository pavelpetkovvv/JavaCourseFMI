package MultiplicationGame;

import java.util.Random;
import java.util.Scanner;

public class MultiplicationGame {

    Random randomGenerator = new Random();

    public void playGame(){
        int randomNumber1 = randomGenerator.nextInt(10);
        int randomNumber2 = randomGenerator.nextInt(10);

        int answer=0;

        Scanner scanner = new Scanner(System.in);

        System.out.printf("How much is %d times %d?%n",randomNumber1, randomNumber2);

        do{
            answer = scanner.nextInt();

            if(answer != randomNumber1 * randomNumber2)
                System.out.println("No. Please try again.");
        }while (answer != randomNumber1 * randomNumber2);

        System.out.println("Very good!");
    }

}
