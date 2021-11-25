package task1_chek.services;

import task1_chek.models.Cell;
import task1_chek.models.Checker;
import task1_chek.models.Player;

import java.util.List;
import java.util.Map;

public class FieldService {
    public FieldService() {
    }

    public void placeCheckers(Map<Cell, Checker> cellCheckerMap, Map<Checker, Cell> checkerCellMap, Map<Character, List<Cell>> cellsListMap, List<Player> players, Map<Player, List<Checker>> checkerMap) {
        int n = 0;
        for (int i = 0; i < 2; i++) {
            for (char ch = 'a'; ch < 'i'; ch++) {
                List<Cell> current = cellsListMap.get(ch);
                for (Cell cell : current) {
                    Checker check = checkerMap.get(players.get(i)).get(n);
                    cellCheckerMap.put(cell, check);
                    checkerCellMap.put(check, cell);
                    n++;
                }
                if (n == 12 && ch < 'd') {
                    n = 0;
                    ch = 'e';
                    i = 1;
                }
            }
        }
    }
}
