package task1_chek.services;

import task1_chek.models.Cell;
import task1_chek.models.Checker;
import task1_chek.models.Color;
import task1_chek.models.Game;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphicService {
    private static final int cellNum = 8;

    public Color[][] createMatrix(Game game) {
        int v = 0;
        Color[][] color = new Color[cellNum][cellNum];
        for (char ch = 'a'; ch < 'i'; ch++) {
            List<Cell> currList = game.getCellsListMap().get(ch);
            for (int i = 0; i < currList.size(); i++) {
                Checker currCheck = game.getCellCheckerMap().get(currList.get(i));
                int n = ch % 2 != 0 ? i * 2 + 1 : i * 2;
                if (checkList(game, currCheck) == 1) color[v][n] = Color.WHITE;
                else if (checkList(game, currCheck) == 2) color[v][n] = Color.BLACK;
                else color[ch - 97][n] = null;
            }
            v++;
        }
        return color;
    }

    private int checkList(Game game, Checker checker) {
        AtomicInteger num = new AtomicInteger();
        List<Checker> checkerFir = game.getCheckerMap().get(game.getPlayers().get(0));
        checkerFir.forEach(checker1 -> {
            if (checker1.equals(checker)) num.set(1);
        });

        List<Checker> checkerSec = game.getCheckerMap().get(game.getPlayers().get(1));
        checkerSec.forEach(checker1 -> {
            if (checker1.equals(checker)) num.set(2);
        });
        return num.get();
    }
}
