package task1_chek.services;

import task1_chek.models.*;
import task1_chek.utils.Graph;

import java.util.ArrayList;
import java.util.Map;

//TODO тим вьюер

public class GameService {

    private static final int MAX_ROV_VAL = 8;
    private static final int MAX_COL_VAL = 8;
    private static final int MAX_CHECKER_NUMBER = 12;

    PlayerService ps = new PlayerService();

    private void doStep(Game game) {
    }

    private void makePunch(Game game) {
    }

   /* public Game createGame() {
        ArrayList<Player> players = ps.setPlayers();  // TODO: 28.10.2021 исправитьт названия методов
        Map<Player, ArrayList<Checker>> pl = ps.fillCheckers(players);
      //  Graph<Cell> board = createBoard();// TODO: 28.10.2021 сделать декомпозицию
       // fillCheckers(board, pl, players.get(0));
        /*for (int row = 0; row < MAX_ROV_VAL; row++) {
           for (int col = 0; col < MAX_COL_VAL; col++) {
                if (row % 2 != col % 2) {
                    if (row > 4) {
                        if (i == MAX_CHECKER_NUMBER) i = 0;
                        board.addVertex(new Cell(col + 1, (char) (let + row), pl.get(players.get(1)).get(i)));
                        i++;
                    } else if (row < 3) {
                        board.addVertex(new Cell(col + 1, (char) (let + row), pl.get(players.get(0)).get(i)));
                        i++;
                    } else {
                        board.addVertex(new Cell(col + 1, (char) (let + row)));
                    }
                }
            }
        }
        return new Game(new Field(null), players, pl);
    }  */

    /*private void fillCheckers(Graph<Cell> board, Map<Player, ArrayList<Checker>> pl, Player player) {
        for (int i = 0; i < pl.get(player).size(); i++) {
            for (Cell value : board) {
                if (i % 2 == 0 && value.getNumber() % 2 == 0 && value.getCheck() == null) {
                    value.setCheck(pl.get(player).get(i));
                } else if (i % 2 != 0 && value.getNumber() % 2 != 0 && value.getCheck() == null) {
                    value.setCheck(pl.get(player).get(i));
                }
            }
            for (Cell value : board) {
                System.out.println(value);
            }
        }
    }

    /*private Graph<Cell> createBoard() {
        char let = 'A';
        Graph<Cell> board = new Graph<>();
        for (int row = 0; row < MAX_ROV_VAL; row++) {
            for (int col = 0; col < MAX_COL_VAL; col++) {
                if (row % 2 != col % 2) {
                    board.addVertex(new Cell(col + 1, (char) (let + row)));
                }
            }
        }
        return board;
    }  */

    public void runGame(Game game) {

    }

    public ArrayList<Integer> getPossibleSteps(Game game) {
        return new ArrayList<>();
    }

    public boolean isGameOver(Game game) {
        return false;
    }

    public void makeKing(Checker check) {
        check.setKing(true);
    }

  /*  public void printBoard(Game game) {
        System.out.println();
        for (Cell c : game.getField().getCellGraph()) {
            System.out.println(c);
        }
    }*/
    public void searchVertex(Game game) {
    }
}
