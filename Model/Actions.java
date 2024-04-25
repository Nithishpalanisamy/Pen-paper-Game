package Model;

import java.util.Random;
import java.util.Scanner;

public class Actions {
    private int lowerBound;
    private int upperBound;

    public void setDetails( int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int generate() {
        int randomNumber = new Random().nextInt((upperBound - lowerBound) + 1) + lowerBound;
        return randomNumber;
    }

    public boolean start(Scanner scanner) {
        System.out.print("Enter a number: ");

        // take user input
        int userInputedNumber = scanner.nextInt();
        // if user inputed number less then of lowerBound or more then of upperBound
        if (userInputedNumber < this.lowerBound || userInputedNumber > this.upperBound) {
            System.out.println("Enter the valid number");
            return playAgain(scanner);
        } else {
            int generatedNumber = generate(); // generate random number

            if (userInputedNumber == generatedNumber) {
                System.out.println("Congratulation!");
                return playAgain(scanner);
            } else {
                System.out.println("You are loss!\n Program generate= " + generatedNumber);
                return playAgain(scanner);
            }
        }
    }

    public boolean playAgain(Scanner scanner) {
        System.out.println("Game over! Do you want to play again? (1-yes/2-no)");
        int playAgain = scanner.nextInt();
        return playAgain == 1;
    }
}
