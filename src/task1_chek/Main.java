package task1_chek;

import java.util.LinkedHashMap;
import java.util.List;
import task1_chek.models.Cell;
import task1_chek.models.Field;
import task1_chek.models.Game;
import task1_chek.services.FieldService;
import task1_chek.services.GameService;

import java.util.Map;

public class Main {
    static FieldService service = new FieldService();

    public static void main(String[] args) {
        /*GameService gs = new GameService();
        Game game = gs.createGame();
        gs.printBoard(game);
        System.out.println();

        /*for (int i = 0; i < 5; i++) {
            System.out.println(game.getField().getCellGraph());
        }
        System.out.println(game.getField().getCellGraph().get(2));*/
        Map<Character, List<Cell>> pisun = new LinkedHashMap<>();
        service.initCellsListMap(pisun);
        service.createNeighbors(pisun);
        System.out.println();
    }
}
