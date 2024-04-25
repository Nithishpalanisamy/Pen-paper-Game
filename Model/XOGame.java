package Model;

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

    public boolean start(Scanner scanner) { // pass the Scanner as a parameter
        int move;
        do {
            System.out.println(this);
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number! Please enter a valid move (1-9):");
                scanner.next(); // discard non-int input
            }
            move = scanner.nextInt() - 1;
            if (isValidMove(move)) {
                board[move] = currentPlayer;
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        } while (!isGameOver());
        System.out.println("Game over! Do you want to play again? (1-yes/2-no)");
        int playAgain = scanner.nextInt();
        return playAgain == 1;
    }
    private boolean isValidMove(int move) {
        return move >= 0 && move < 9 && board[move] == '-';
    }

    private boolean isGameOver() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (checkLine(i*3, (i+1)*3, 1) || checkLine(i, i+7, 3)) {
                return true;
            }
        }
        return checkLine(0, 9, 4) || checkLine(2, 7, 2);
    }

    private boolean checkLine(int start, int end, int step) {
        return board[start] != '-' && board[start] == board[start+step] && board[start] == board[end-step];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0) {
                sb.append('\n');
            }
            sb.append(board[i]);
        }
        return sb.toString();
    }
}
