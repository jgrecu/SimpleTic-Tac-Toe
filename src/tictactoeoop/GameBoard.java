package tictactoeoop;

public class GameBoard {
    Cell[][] board = new Cell[3][3];

    GameBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new Cell(CellState.EMPTY);
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j].getStatus().getName());
                if (j < 3 - 1) {
                    System.out.print(" |");
                } else {
                    System.out.println();
                }
            }
            if (i < 3 - 1) {
                System.out.println("---+---+---");
            }
        }
    }

    public boolean isValidCoordinates(String input) {
        String[] rowStr = input.split(" ");
        if (!rowStr[0].matches("\\d+") || rowStr.length > 1 && !rowStr[1].matches("\\d+")) {
            System.out.println("You should enter numbers!");
            return false;
        }
        if (Integer.parseInt(rowStr[0]) > 3 || Integer.parseInt(rowStr[1]) > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        int row = Integer.parseInt(rowStr[0]);
        int col = Integer.parseInt(rowStr[1]);
        
        if (board[row - 1][col - 1].getStatus() != CellState.EMPTY) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        return true;
    }

    public void markCell(String input, CellState cellState) {
        String[] rowStr = input.split(" ");
        int row = Integer.parseInt(rowStr[0]);
        int col = Integer.parseInt(rowStr[1]);
        board[row - 1][col - 1].setStatus(cellState);
    }
}
