package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int round = 0;

        char[][] board = new char[3][3];

        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }

        printMenu();
        printBoard(board);

        while (true) {
            System.out.println("Enter the coordinates: ");
            String[] rowStr = scanner.nextLine().split(" ");
            if (!rowStr[0].matches("\\d+")) {
                System.out.println("You should enter numbers!");
                continue;
            } else if (rowStr.length > 1 && !rowStr[1].matches("\\d+")) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int row = Integer.parseInt(rowStr[0]);
            int col = Integer.parseInt(rowStr[1]);

            if (row > 3 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (board[row - 1][col - 1] == ' ') {
                board[row - 1][col - 1] = round % 2 == 0 ? 'X': 'O';
                round++;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            printBoard(board);

            if (checkSolved(board) == 'X' || checkSolved(board) == 'O') {
                char winner = checkSolved(board);
                System.out.println(winner + " wins");
                break;
            } else if (isBoardFull(board) && checkSolved(board) == '0') {
                System.out.println("Draw");
                break;
            }
        }
     }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(" " + board[i][j]);
                if (j < board[0].length -1) {
                    System.out.print(" |");
                } else {
                    System.out.println();
                }
            }
            if (i < board.length - 1) {
                System.out.println("---+---+---");
            }
        }
    }

    public static char checkSolved(char[][] board) {
        char winner = '0';
        for (int i = 0; i < board.length; i++) {
            // check the rows
            if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                winner = winner != '0' ? 'I' : board[i][0];
            }
            // check the columns
            if(board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                winner = winner != '0' ? 'I' : board[0][i];
            }
        }
        // check left top to bottom diagonal
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            winner = board[0][0];
            // check right top to bottom diagonal
        } else if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            winner = board[0][2];
        }
        return winner;
    }

    public static boolean isBoardFull(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void printMenu() {
        System.out.println("Simple Tic-Tac-Toe\n\n" + 
                           "The coordinates are \"X Y\" from top left corner \"1 1\" to bottom right corner \"3 3\"");
    }
}
