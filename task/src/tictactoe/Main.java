package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        char[][] chars = new char[3][3];
        System.out.println("Enter cells: ");
        String input = scanner.nextLine();

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                chars[i][j] = input.charAt(index);
                index++;
            }
        }
        printBoard(chars);
    }

    public static void printBoard(char[][] chars) {
        System.out.println("---------");
        for (char[] row : chars) {
            System.out.print('|' + " ");
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println('|');
        }
        System.out.println("---------");
    }
}
