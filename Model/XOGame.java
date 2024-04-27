package Model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class XOGame {
    private char[] board;
    private char currentPlayer;

    public XOGame() {
        board = new char[9]; 
        currentPlayer = 'X'; 
        for (int i = 0; i < board.length; i++) {
            board[i] = '-'; 
        }
    }

<<<<<<< HEAD
    public boolean start(Scanner scanner) {
        int move;
        boolean playAgain;
        do {
            System.out.println(this); 
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            
            
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number! Please enter a valid move (1-9):");
                scanner.next();
            }
            
            move = scanner.nextInt() - 1; // map 1-9 to 0-8
            if (isValidMove(move)) { // check if the move is valid
                board[move] = currentPlayer; // make the move
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // switch players
            } else {
                System.out.println("Invalid move. Try again.");
            }
            
            if (isGameOver()) { // check if the game is over
                System.out.println("Game over! Would you like to play again? (1-yes/0-no)");
                playAgain = scanner.nextInt() == 1; // get user's choice to play again
                if (playAgain) {
                    // Reset the game
                    board = new char[9];
                    currentPlayer = 'X';
                    for (int i = 0; i < board.length; i++) {
                        board[i] = '-'; // initialize the board with empty cells
=======
    public boolean start(Scanner scanner) { // start game with given scanner for input
        int move = -1;
        boolean validInput;
        do {
            System.out.println(this); // print the current board
            validInput = false;
            
            while (!validInput) {
                try {
                    System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
                    move = scanner.nextInt() - 1; // map 1-9 to 0-8
                    
                    if (isValidMove(move)) { // check if the move is valid
                        board[move] = currentPlayer; // make the move
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // switch players
                        validInput = true; // the move was valid
                    } else {
                        System.out.println("Invalid move. Try again.");
>>>>>>> a1045692468586795e5e04e2d7d1a5585ffcecb5
                    }
                } catch (InputMismatchException e) {
                    System.out.println("That's not a valid number! Please enter a valid move (1-9).");
                    scanner.next(); // discard the invalid input
                } catch (Exception e) {
                    System.out.println("An error occurred. Please try again.");
                }
            }
        } while (!isGameOver()); // continue until the game is over
        System.out.println(this);
        System.out.println("Game over! Would you like to play again? (1-yes/2-no)");
        int playAgain = -1;

        try {
            playAgain = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Ending game.");
            return false;
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            return false;
        }
        
        return playAgain == 1; // return whether to play again
    }

    private boolean isValidMove(int move) {
        return move >= 0 && move < 9 && board[move] == '-'; // move must be within range and on an empty cell
    }

    private boolean isGameOver() {
        
        return checkRows() || checkColumns() || checkDiagonals(); // check for win or tie
    }

    private boolean checkRows() {
        // Check each row for identical symbols (not empty)
        for (int i = 0; i < 3; i++) {
            if (board[i * 3] == board[i * 3 + 1] && board[i * 3 + 1] == board[i * 3 + 2] && board[i * 3] != '-') {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        // Check each column for identical symbols (not empty)
        for (int i = 0; i < 3; i++) {
            if (board[i] == board[i + 3] && board[i + 3] == board[i + 6] && board[i] != '-') {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        // Check primary diagonal
        if (board[0] == board[4] && board[4] == board[8] && board[0] != '-') {
            return true;
        }

        // Check secondary diagonal
        if (board[2] == board[4] && board[4] == board[6] && board[2] != '-') {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0) { // new row
                sb.append('\n');
            }
            sb.append(board[i]); // append the cell value
        }
        return sb.toString(); // return the current board state as a string
    }
}
//if we print current object the string method will be called.
