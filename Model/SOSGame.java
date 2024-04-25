package Model;

import java.util.Scanner;

public class SOSGame {
    private char[][] board;
    private char currentPlayer;
    private int scoreS, scoreO;

    public SOSGame() {
        board = new char[5][5];
        currentPlayer = 'S';
        scoreS = 0;
        scoreO = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean start(Scanner scanner) {
        int row, col;
        boolean gameWon = false;
        do {
            System.out.println(this);
            System.out.print("Player " + currentPlayer + ", enter your move (row col): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                if (checkForSOS(row, col)) {
                    if (currentPlayer == 'S') {
                        scoreS++;
                    } else {
                        scoreO++;
                    }
                } else {
                    currentPlayer = (currentPlayer == 'S') ? 'O' : 'S';
                }
                gameWon = isGameOver();
                if (gameWon) {
                    System.out.println("Player " + (scoreS > scoreO ? 'S' : 'O') + " wins!");
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        } while (!gameWon);
        System.out.println("Game over! Do you want to play again? (1-yes/2-no)");
        int playAgain = scanner.nextInt();
        return playAgain == 1;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 5 && col >= 0 && col < 5 && board[row][col] == '-';
    }

    private boolean checkForSOS(int row, int col) {
        // Define the eight directions: up, down, left, right, and the four diagonals
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    
        // Check each direction
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
    
            // Check if the new cell is within the board and contains 'O'
            if (newRow >= 0 && newRow < 5 && newCol >= 0 && newCol < 5 && board[newRow][newCol] == 'O') {
                int nextRow = newRow + dir[0];
                int nextCol = newCol + dir[1];
    
                // Check if the next cell is within the board and contains 'S'
                if (nextRow >= 0 && nextRow < 5 && nextCol >= 0 && nextCol < 5 && board[nextRow][nextCol] == 'S') {
                    return true;
                }
            }
        }
    
        return false;
    }
    

    private boolean isGameOver() {
        // Check if the board is full
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
