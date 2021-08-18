package tictactoeoop;

public enum CellState {
    EMPTY(" "),
    X("X"),
    O("O");
    
    String name;

    CellState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
