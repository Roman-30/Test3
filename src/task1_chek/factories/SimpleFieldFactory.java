package task1_chek.factories;

import task1_chek.models.Cell;
import task1_chek.models.Direction;

import java.util.*;

public class SimpleFieldFactory implements FieldFactory {

    @Override
    public Map<Character, List<Cell>> createField() {
        Map<Character, List<Cell>> cellsListMap = initCellsListMap();
        boolean flag = true;
        for (char ch = 'a'; ch < 'i'; ch++, flag = !flag) {
            List<Cell> cells = cellsListMap.get(ch);
            for (int i = 0; i < cells.size(); i++) {
                List<Cell> neighbors = new LinkedList<>();
                if (i == 0 && ch != 'a' && ch != 'h') {
                    neighbors.add(cellsListMap.get((char) (ch - 1)).get(i));
                    if (!flag) {
                        cells.get(i).getNeighborCells().put(Direction.UP, neighbors);
                        neighbors = new ArrayList<>();
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i));
                        cells.get(i).getNeighborCells().put(Direction.DOWN, neighbors);
                    } else {
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i + 1));
                        cells.get(i).getNeighborCells().put(Direction.UP, neighbors);
                        neighbors = new ArrayList<>();
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i + 1));
                        cells.get(i).getNeighborCells().put(Direction.DOWN, neighbors);
                    }
                }
                if (i == 3 && ch != 'a' && ch != 'h') {
                    neighbors.add(cellsListMap.get((char) (ch - 1)).get(i));
                    if (flag) {
                        cells.get(i).getNeighborCells().put(Direction.UP, neighbors);
                        neighbors = new ArrayList<>();
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i));
                    } else {
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i - 1));
                        cells.get(i).getNeighborCells().put(Direction.UP, neighbors);
                        neighbors = new ArrayList<>();
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i - 1));
                    }
                    cells.get(i).getNeighborCells().put(Direction.DOWN, neighbors);
                }
                if (ch == 'a') {
                    if (i == 0) {
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i + 1));
                    } else if (i == 3) {
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i));
                    } else {
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i + 1));
                    }
                    cells.get(i).getNeighborCells().put(Direction.DOWN, neighbors);
                }

                if (ch == 'h') {
                    if (i == 0) {
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i));
                    } else if (i == 3) {
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i - 1));
                    } else {
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i - 1));
                    }
                    cells.get(i).getNeighborCells().put(Direction.UP, neighbors);
                }
                if (i != 0 && i != 3 && ch != 'a' && ch != 'h') {
                    neighbors.add(cellsListMap.get((char) (ch + 1)).get(i));
                    if (!flag) {
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i - 1));
                        cells.get(i).getNeighborCells().put(Direction.DOWN, neighbors);
                        neighbors = new ArrayList<>();
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i - 1));
                    } else {
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i + 1));
                        cells.get(i).getNeighborCells().put(Direction.DOWN, neighbors);
                        neighbors = new ArrayList<>();
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i + 1));
                    }
                    cells.get(i).getNeighborCells().put(Direction.UP, neighbors);
                }
            }
        }
        return cellsListMap;
    }

    @Override
    public Map<Character, List<Cell>> initCellsListMap() {
        Map<Character, List<Cell>> cellsListMap = new LinkedHashMap<>();
        for (char ch = 'a'; ch < 'i'; ch++) {
            List<Cell> cellsList = new LinkedList<>();
            for (int i = 0; i < 4; i++) {
                cellsList.add(new Cell());
            }
            cellsListMap.put(ch, cellsList);
        }
        return cellsListMap;
    }
}

