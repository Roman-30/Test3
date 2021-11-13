package task1_chek.services;

import task1_chek.models.Cell;
import task1_chek.models.Direction;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FieldService {
    public FieldService() {
    }

    public void initCellsListMap(Map<Character, List<Cell>> cellsListMap) {
        for (char ch = 'a'; ch < 'i'; ch++) {
            List<Cell> cellsList = new LinkedList<>();
            for (int i = 0; i < 4; i++) {
                cellsList.add(new Cell());
            }
            cellsListMap.put(ch, cellsList);
        }
    }

    public void createNeighbors(Map<Character, List<Cell>> cellsListMap) {
        boolean flag = true;
        for (char ch = 'a'; ch < 'i'; ch++, flag = !flag) {
            List<Cell> cells = cellsListMap.get(ch);
            for (int i = 0; i < cells.size(); i++) {
                List<Cell> neighbors = new LinkedList<>();
                if (i == 0 && ch != 'a' && ch != 'h') {
                    if (!flag) {
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(0));
                        cells.get(i).getNeighborCells().put(Direction.UP, neighbors);
                        neighbors.clear();
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(0));
                        cells.get(i).getNeighborCells().put(Direction.DOWN, neighbors);
                    } else {
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i + 1));
                        cells.get(i).getNeighborCells().put(Direction.UP, neighbors);
                        neighbors.clear();
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i + 1));
                    }
                    cells.get(i).getNeighborCells().put(Direction.DOWN, neighbors);
                }
                if (i == 3 && ch != 'a' && ch != 'h') {
                    if (!flag) {
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(2));
                        cells.get(i).getNeighborCells().put(Direction.UP, neighbors);
                        neighbors.clear();
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(2));
                    } else {
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i - 1));
                        cells.get(i).getNeighborCells().put(Direction.UP, neighbors);
                        neighbors.clear();
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i - 1));
                    }
                    cells.get(i).getNeighborCells().put(Direction.DOWN, neighbors);
                }
                if (ch == 'a') {
                    if (i == 0) {
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(0));
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(1));
                    } else if (i == 3) {
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(3));
                    } else {
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch + 1)).get(i + 1));
                    }
                    cells.get(i).getNeighborCells().put(Direction.UP, neighbors);
                }

                if (ch == 'h') {
                    if (i == 0) {
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(0));
                    } else if (i == 3) {
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(2));
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(3));
                    } else {
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i));
                        neighbors.add(cellsListMap.get((char) (ch - 1)).get(i - 1));
                    }
                    cells.get(i).getNeighborCells().put(Direction.DOWN, neighbors);
                }
                if (i != 0 && i != 3 && ch != 'a' && ch != 'h') {
                    neighbors.add(cellsListMap.get((char) (ch + 1)).get(i));
                    neighbors.add(cellsListMap.get((char) (ch + 1)).get(i + 1));
                    cells.get(i).getNeighborCells().put(Direction.UP, neighbors);
                    neighbors.clear();
                    neighbors.add(cellsListMap.get((char) (ch - 1)).get(i));
                    neighbors.add(cellsListMap.get((char) (ch - 1)).get(i + 1));
                    cells.get(i).getNeighborCells().put(Direction.DOWN, neighbors);

                }
            }
        }
    }

}
