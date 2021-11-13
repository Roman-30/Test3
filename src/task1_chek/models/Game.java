package task1_chek.models;


import java.util.List;

import java.util.ArrayList;
import java.util.Map;


public class Game {
   // private Field field;
    private ArrayList<Player> players;
    private Map<Player, ArrayList<Checker>> checkerMap;
    private Map<Cell, Checker> cellCheckerMap;
    private Map<Checker, Cell> checkerCellMap;
    private Map<Character, List<Cell>> cellsListMap;

    public Game(Map<Character, List<Cell>> cellsListMap, ArrayList<Player> players, Map<Player, ArrayList<Checker>> checkerMap) {
        this.cellsListMap = cellsListMap;
        this.players = players;
        this.checkerMap = checkerMap;
    }

    @Override
    public String toString() {
        return "Game{" +
                "cellsListMap=" + cellsListMap +
                '}';
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Map<Player, ArrayList<Checker>> getCheckerMap() {
        return checkerMap;
    }

    public void setCheckerMap(Map<Player, ArrayList<Checker>> checkerMap) {
        this.checkerMap = checkerMap;
    }
}
