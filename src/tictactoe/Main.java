package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int round = 0;

        char[][] board = createBoard();

        printMenu();
        printBoard(board);
        
        while (true) {
            System.out.println("Enter the coordinates: ");
            String[] rowStr = scanner.nextLine().split(" ");

            if (!areValidCoordinates(rowStr)) {
                continue;
            }
            
            int row = Integer.parseInt(rowStr[0]);
            int col = Integer.parseInt(rowStr[1]);

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
                scanner.close();
                break;
            } else if (isBoardFull(board) && checkSolved(board) == '0') {
                System.out.println("Draw");
                scanner.close();
                break;
            }
        }
    }

    public static char[][] createBoard() {
        char[][] board = new char[3][3];
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
        return board;
    }

    private static boolean areValidCoordinates(String[] rowStr) {
        if (!rowStr[0].matches("\\d+") || rowStr.length > 1 && !rowStr[1].matches("\\d+")) {
            System.out.println("You should enter numbers!");
            return false;
        }
        if (Integer.parseInt(rowStr[0]) > 3 || Integer.parseInt(rowStr[1]) > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        return true;
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
                return board[i][0];
            }
            // check the columns
            if(board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i];
            }
        }
        // check left top to bottom diagonal
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
            // check right top to bottom diagonal
        } else if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
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
