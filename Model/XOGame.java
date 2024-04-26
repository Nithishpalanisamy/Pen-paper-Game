package Model;

import java.util.Scanner;

public class XOGame {
    private char[] board;
    private char currentPlayer;

    public XOGame() {
        board = new char[9]; // 3x3 board represented as a 1D array
        currentPlayer = 'X'; // 'X' starts the game
        for (int i = 0; i < board.length; i++) {
            board[i] = '-'; // initialize the board with empty cells
        }
    }

    public boolean start(Scanner scanner) { // start game with given scanner for input
        int move;
        boolean playAgain;
        do {
            System.out.println(this); // print the current board
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            
            // Ensure the input is a valid integer
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number! Please enter a valid move (1-9):");
                scanner.next(); // discard invalid input
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
                    }
                }
            } else {
                playAgain = true; // continue the current game if it's not over
            }
        } while (playAgain); // continue until the user chooses not to play again
        
        return false; // return to the menu
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
