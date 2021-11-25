package task1_chek.models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Cell {
    private static final Random RND = new Random();

    int num;
    private Map<Direction, List<Cell>> neighborCells;

    public Cell() {
        neighborCells = new LinkedHashMap<>();
        num = RND.nextInt(Integer.MAX_VALUE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return num == cell.num;
    }

    public int getNum() {
        return num;
    }


    public Map<Direction, List<Cell>> getNeighborCells() {
        return neighborCells;
    }

    public void setNeighborCells(Map<Direction, List<Cell>> neighborCells) {
        this.neighborCells = neighborCells;
    }
}
