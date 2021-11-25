package task1_chek.models;

import java.util.ArrayList;
import java.util.*;
import java.util.Map;
import java.util.Set;

public class Game {
    private List<Player> players;
    private Map<Player, List<Checker>> checkerMap;
    private Map<Cell, Checker> cellCheckerMap;
    private Map<Checker, Cell> checkerCellMap;
    private Map<Character, List<Cell>> cellsListMap;

    public Game(List<Player> players, Map<Player, List<Checker>> checkerMap, Map<Cell, Checker> cellCheckerMap, Map<Checker, Cell> checkerCellMap, Map<Character, List<Cell>> cellsListMap) {
        this.players = players;
        this.checkerMap = checkerMap;
        this.cellCheckerMap = cellCheckerMap;
        this.checkerCellMap = checkerCellMap;
        this.cellsListMap = cellsListMap;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public char getLetter(Cell cell) {
        char lit = '0';
        Set<Map.Entry<Character, List<Cell>>> entries = this.cellsListMap.entrySet();
        for (Map.Entry<Character, List<Cell>> entry : entries) {
            if (entry.getValue().contains(cell)) {
                lit = entry.getKey();
            }
        }
        return lit;
    }

    public int getNumber(Cell cell) {
        int lit = 0;
        Set<Map.Entry<Character, List<Cell>>> entries = this.cellsListMap.entrySet();
        for (Map.Entry<Character, List<Cell>> entry : entries) {
            if (entry.getValue().contains(cell)) {
                lit = entry.getValue().indexOf(cell);
            }
        }
        return lit;
    }

    public Map<Player, List<Checker>> getCheckerMap() {
        return checkerMap;
    }

    public void setCheckerMap(Map<Player, List<Checker>> checkerMap) {
        this.checkerMap = checkerMap;
    }

    public Map<Cell, Checker> getCellCheckerMap() {
        return cellCheckerMap;
    }

    public void setCellCheckerMap(Map<Cell, Checker> cellCheckerMap) {
        this.cellCheckerMap = cellCheckerMap;
    }

    public Map<Checker, Cell> getCheckerCellMap() {
        return checkerCellMap;
    }

    public void setCheckerCellMap(Map<Checker, Cell> checkerCellMap) {
        this.checkerCellMap = checkerCellMap;
    }

    public Map<Character, List<Cell>> getCellsListMap() {
        return cellsListMap;
    }

    public void setCellsListMap(Map<Character, List<Cell>> cellsListMap) {
        this.cellsListMap = cellsListMap;
    }
}
