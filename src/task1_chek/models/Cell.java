package task1_chek.models;

import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

public class Cell {
   // private int number;
   // private char letter;
    //private Enum position;
   // private Checker check;
    private Map<Direction, List<Cell>> neighborCells;

    public Cell() {
        neighborCells = new LinkedHashMap<>();
    }


    public Map<Direction, List<Cell>> getNeighborCells() {
        return neighborCells;
    }

    public void setNeighborCells(Map<Direction, List<Cell>> neighborCells) {
        this.neighborCells = neighborCells;
    }
}
