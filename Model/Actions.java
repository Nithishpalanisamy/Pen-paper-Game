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
        //generate random number
    public int generate() {
        int randomNumber = new Random().nextInt((upperBound - lowerBound) + 1) + lowerBound;
        return randomNumber;
    }

    public boolean start(Scanner scanner) {
        System.out.print("Enter a number: ");

        int userInputedNumber = scanner.nextInt();
        if (userInputedNumber < this.lowerBound || userInputedNumber > this.upperBound) {
            System.out.println("Enter the valid number");
            return playAgain(scanner);
        } else {
            int generatedNumber = generate();

            if (userInputedNumber == generatedNumber) {
                System.out.println("Congratulation!");
                return playAgain(scanner);
            } else {
                System.out.println("You are loss!\n Program generate= " + generatedNumber);
                return playAgain(scanner);
            }
        }
    }
        //ask play again
        public boolean playAgain(Scanner scanner) {
            System.out.println("Game over! Do you want to play again? (1-yes/0-no)");
            int playAgain = scanner.nextInt();
            if (playAgain == 1) {
                // Restart the game
                return start(scanner);
            } else if (playAgain == 0) {
                // Go back to the menu
                return false;
            } else {
                System.out.println("Invalid input. Please enter 1 for yes or 0 for no.");
                return playAgain(scanner);
            }
        }
        
}
