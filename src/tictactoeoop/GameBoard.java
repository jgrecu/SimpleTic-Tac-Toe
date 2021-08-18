package tictactoeoop;

public class GameBoard {
    private final Cell[][] board = new Cell[3][3];
    private final int BOARD_SIZE = 3;

    GameBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new Cell(CellState.EMPTY);
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(" " + board[i][j].getStatus().getName());
                if (j < 3 - 1) {
                    System.out.print(" |");
                } else {
                    System.out.println();
                }
            }
            if (i < BOARD_SIZE - 1) {
                System.out.println("---+---+---");
            }
        }
    }

    public boolean areCoordinatesValid(String input) {
        String[] rowStr = input.split(" ");
        if (!rowStr[0].matches("\\d+") || rowStr.length > 1 && !rowStr[1].matches("\\d+")) {
            System.out.println("You should enter numbers!");
            return false;
        }
        if (Integer.parseInt(rowStr[0]) > BOARD_SIZE || Integer.parseInt(rowStr[1]) > BOARD_SIZE) {
            System.out.println("Coordinates should be from 1 to " + BOARD_SIZE + "!");
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

    private CellState checkSolved(Cell[][] board) {
        for (int i = 0; i < board.length; i++) {
            // check the rows
            if(board[i][0].getStatus() != CellState.EMPTY
                    && board[i][0].getStatus() == board[i][1].getStatus()
                    && board[i][1].getStatus() == board[i][2].getStatus()) {
                return board[i][0].getStatus();
            }
            // check the columns
            if(board[0][i].getStatus() != CellState.EMPTY
                    && board[0][i].getStatus() == board[1][i].getStatus()
                    && board[1][i].getStatus() == board[2][i].getStatus()) {
                return board[0][i].getStatus();
            }
        }
        // check left top to bottom diagonal
        if (board[0][0].getStatus() != CellState.EMPTY
                && board[0][0].getStatus() == board[1][1].getStatus()
                && board[1][1].getStatus() == board[2][2].getStatus()) {
            return board[0][0].getStatus();
        }
        // check right top to bottom diagonal
        if (board[0][2].getStatus() != CellState.EMPTY
                && board[0][2].getStatus() == board[1][1].getStatus()
                && board[1][1].getStatus() == board[2][0].getStatus()) {
            return board[0][2].getStatus();
        }
        return null;
    }

    private boolean isBoardFull(Cell[][] board) {
        for(int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                if(board[i][j].getStatus() == CellState.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean gameState() {
        if (checkSolved(board) == CellState.X || checkSolved(board) == CellState.O) {
            System.out.println(checkSolved(board).getName() + " wins!\n");
            return true;
        } else if (isBoardFull(board) && checkSolved(board) == null) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
}
