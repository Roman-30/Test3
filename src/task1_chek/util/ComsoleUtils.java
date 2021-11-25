package task1_chek.util;

import task1_chek.models.*;

import java.util.List;

public class ComsoleUtils {

    public static void print(Color[][] color) {
        for (Color[] colors : color) {
            for (Color value : colors) {
                if (Color.BLACK == value) System.out.print(1 + " ");
                else if (Color.WHITE == value) System.out.print(2 + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }
    }

    public static void check(Game game) {
        for (char ch = 'a'; ch < 'i'; ch++) {
            List<Cell> list = game.getCellsListMap().get(ch);
            for (Cell cell : list) {
                for (int j = 0; j < 2; j++) {
                    Direction dir = j % 2 == 0 ? Direction.DOWN : Direction.UP;
                    System.out.println("Текущая ячейка " + game.getLetter(cell) + "  " + game.getNumber(cell));
                    System.out.println("Направление " + (dir == Direction.DOWN ? "down" : "up"));
                    System.out.println("Соседи");
                    List<Cell> list1 = cell.getNeighborCells().get(dir);
                    if (list1 != null)
                        list1.forEach((itemCell) -> System.out.println("Ячейка сосед " + game.getLetter(itemCell) + "  " + game.getNumber(itemCell)));
                    System.out.println("\n--------------------------------");
                }
            }
        }
    }

    public static void print(Game game) {
        List<Player> players = game.getPlayers();
        for (Player player : players) {
            System.out.println("Игрок = " + player.getName());
            List<Checker> checkers = game.getCheckerMap().get(player);
            for (Checker checker : checkers) {
                print(game, game.getCheckerCellMap().get(checker));
            }
        }
    }

    public static void print(Game game, Cell cell) {
        for (char ch = 'a'; ch < 'i'; ch++) {
            List<Cell> list = game.getCellsListMap().get(ch);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getNum() == cell.getNum()) {
                    System.out.println("Буква = " + ch + "\n" + "Позиция = " + i);
                    System.out.println();
                }
            }
        }
    }
}
