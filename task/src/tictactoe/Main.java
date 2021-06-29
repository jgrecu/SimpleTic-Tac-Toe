package tictactoe;

public class Main {
    public static void main(String[] args) {
        char[][] chars = {{'X','O','X'},{'O','X','O'},{'X','X','O'}};
        for (char[] row : chars) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
