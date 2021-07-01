package tictactoe;

import java.util.Scanner;

public class Main {
    enum State { Empty, X, O }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        char[][] board = new char[3][3];
        System.out.println("Enter cells: ");
        String input = scanner.nextLine();

        int index = 0;
        int x = 0;
        int o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = input.charAt(index) == '_' ? ' ' : input.charAt(index);
                x += input.charAt(index) == 'X' ? 1 : 0;
                o += input.charAt(index) == 'O' ? 1 : 0;
                index++;
            }
        }
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
                board[row - 1][col - 1] = 'X';
                break;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }

        printBoard(board);

//        boolean gameOver = isBoardFull(board);
//        char winner = checkSolved(board);
//
//        if (Math.abs(x - o) > 1) {
//            System.out.println("Impossible");
//        } else if (gameOver && winner == '0') {
//            System.out.println("Draw");
//        } else if (!gameOver && winner == '0') {
//            System.out.println("Game not finished");
//        } else if (winner == 'X') {
//            System.out.println("X wins");
//        } else if (winner == 'O') {
//            System.out.println("O wins");
//        } else if (winner == 'I') {
//            System.out.println("Impossible");
//        }
     }

    public static void printBoard(char[][] board) {
        System.out.println("---------");
        for (char[] row : board) {
            System.out.print('|' + " ");
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println('|');
        }
        System.out.println("---------");
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

}
