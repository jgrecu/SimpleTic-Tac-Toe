import java.util.Scanner;

public class Game {
    final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        GameBoard game = new GameBoard();
        

        game.printBoard();
        System.out.println("Enter the coordinates: ");
        String input = scanner.nextLine();

        if (game.isValidCoordinates(input)) {
            game.markCell(input, CellState.X);
        }
        game.printBoard();
    }
}
