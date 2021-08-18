public class Cell {
    CellState status;

    Cell(CellState cellState) {
        this.status = cellState;
    }

    public CellState getStatus() {
        return status;
    }

    public void setStatus(CellState status) {
        this.status = status;
    }

    
}
