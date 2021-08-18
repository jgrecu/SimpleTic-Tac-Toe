package tictactoeoop;

import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final GameBoard gameBoard = new GameBoard();

    public void play() {
        printMenu();
        gameBoard.printBoard();
        startGame();
    }

    private void getCoordinates(int num) {
        while (true) {
            System.out.println("Enter the coordinates: ");
            String input = scanner.nextLine();
            if (gameBoard.areCoordinatesValid(input)) {
                if (num % 2 != 0) {
                    gameBoard.markCell(input, CellState.X);
                } else {
                    gameBoard.markCell(input, CellState.O);
                }
                break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Simple Tic-Tac-Toe\n\n");
        System.out.println("The coordinates are \"X Y\" from top left corner \"1 1\" to bottom right corner \"3 3\"");
    }

    private void startGame() {
        int player = 1;
        while (true) {
            getCoordinates(player++);
            gameBoard.printBoard();
            if (gameBoard.gameState()) {
                scanner.close();
                break;
            }
        }
    }
}
