package Controller;

import Model.SOSGame;
import Model.XOGame;

import java.util.Scanner;

public class Homepage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Welcome to Pen Paper Games!");
            System.out.println("1. XO Game");
            System.out.println("2. SOS Game");
            System.out.println("3. Close");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                     // Call XO Game code here
                     System.out.println("Starting XO Game...");
                     XOGame xoGame = new XOGame();
                     if (!xoGame.start(scanner)) {
                         choice = 0; // go back to the main menu
                     }
                     break;
                case 2:
                    // Call your SOS Game code here
                    System.out.println("Starting SOS Game...");
                    SOSGame sosGame = new SOSGame();
                    if (!sosGame.start(scanner)) { // pass the Scanner to the start method
                        choice = 0; // go back to the main menu
                    }
                    break;
                case 3:
                    System.out.println("Closing the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 3);
        scanner.close();
    }
}
