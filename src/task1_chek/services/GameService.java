package task1_chek.services;

import task1_chek.factories.FieldFactory;
import task1_chek.gui.MainWindow;
import task1_chek.models.*;
import task1_chek.util.SwingUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class GameService {
    private static final Random RND = new Random();

    PlayerService ps = new PlayerService();
    FieldService fs = new FieldService();

    private void doStep(Game game, Move move) {
        Checker checker = game.getCellCheckerMap().get(move.getStart());
        game.getCheckerCellMap().remove(checker);
        game.getCellCheckerMap().remove(move.getStart());
        game.getCellCheckerMap().put(move.getEnd(), checker);
        game.getCheckerCellMap().put(checker, move.getEnd());
    }

    private Cell getMidCell(Move move) {
        Cell cells = move.getStart();
        for (int i = 0; i < Direction.values().length; i++) {
            List<Cell> startList = move.getStart().getNeighborCells().get(i % 2 == 0 ? Direction.DOWN : Direction.UP);
            List<Cell> endList = move.getEnd().getNeighborCells().get(i % 2 != 0 ? Direction.DOWN : Direction.UP);
            if (startList != null && endList != null) {
                for (Cell cell : startList) {
                    for (Cell value : endList) {
                        if (cell.equals(value)) {
                            cells = cell;
                            break;
                        }
                    }
                }
            }
        }
        return cells;
    }

    private void makePunch(Game game, Move move) {
        Cell cell = getMidCell(move);
        Checker checker = game.getCellCheckerMap().get(cell);

        Player player = playerFromCheck(game, checker);
        List<Checker> currChecks = game.getCheckerMap().get(player);
        currChecks.remove(checker);

        game.getCellCheckerMap().remove(cell);
        game.getCheckerCellMap().remove(checker);
        doStep(game, move);
    }

    public Game createGame(FieldFactory fieldFactory) {
        List<Player> players = ps.createPlayers();
        Map<Player, List<Checker>> checkerMap = ps.fillCheckers(players);
        Map<Cell, Checker> cellCheckerMap = new LinkedHashMap<>();
        Map<Checker, Cell> checkerCellMap = new LinkedHashMap<>();
        Map<Character, List<Cell>> cellsListMap = fieldFactory.createField();
        fs.placeCheckers(cellCheckerMap, checkerCellMap, cellsListMap, players, checkerMap);
        return new Game(players, checkerMap, cellCheckerMap, checkerCellMap, cellsListMap);
    }

    public void runGame(Game game, MainWindow frame) throws InterruptedException {
        Map<Player, Direction> queue = ps.createQueue(game);
        boolean process = isGameOver(game);
        Stack<Player> players = new Stack<>();
        game.getPlayers().forEach(players::push);
        Player next = null;
        while (process) {
            Player currPlayer = players.pop();
            List<Checker> currCheck = game.getCheckerMap().get(currPlayer);
            if (next != null) players.push(next);
            Move move = createSteps(currCheck, queue.get(currPlayer), game);

            isDraw(move);

            if (move.getPriority() == 1) {
                doStep(game, move);
            } else if (move.getPriority() == 2) {
                while (move.getPriority() == 2) {
                    makePunch(game, move);
                    Checker checker = game.getCellCheckerMap().get(move.getEnd());
                    move = createSteps(new ArrayList<>(Collections.singleton(checker)), queue.get(currPlayer), game);
                }
            }

            frame.getDp().setBoard(game);
            frame.getFr().repaint();

            process = isGameOver(game);

            next = currPlayer;
        }
    }

    private Move createSteps(List<Checker> currCheck, Direction dir, Game game) throws InterruptedException {
        Thread.sleep(1000);

        List<Move> moves = new ArrayList<>();

        for (Checker checker : currCheck) {
            moves.addAll(createPunch(game, checker));
            moves.addAll(createsStep(game, dir, checker));
        }

        List<Move> move = setPriorityMove(moves);

        return move.get(RND.nextInt(move.size()));
    }

    private List<Move> setPriorityMove(List<Move> moves) {
        List<Move> currMove = new ArrayList<>();
        int prior = -1;
        for (Move move : moves) {
            int curr = move.getPriority();
            if (curr > prior) {
                prior = curr;
                currMove.clear();
                currMove.add(move);
            } else if (prior == curr) {
                currMove.add(move);
            }
        }
        return currMove;
    }

    private int getDifference(Game game, Cell cell) {
        int m = 0;
        for (char ch = 'a'; ch < 'i'; ch++) {
            List<Cell> list1 = game.getCellsListMap().get(ch);
            for (int j = 0; j < list1.size(); j++) {
                if (cell.equals(list1.get(j))) {
                    m = j;
                }
            }
        }
        return m;
    }

    private List<Move> createPunch(Game game, Checker currCheck) {
        List<Move> moveList = new ArrayList<>();
        Cell cell = game.getCheckerCellMap().get(currCheck);
        for (int i = 0; i < Direction.values().length; i++) {
            try {
                List<Cell> cells = cell.getNeighborCells().get(Direction.values()[i]);
                int finalI = i;
                cells.forEach(curr -> {
                    if (!belongAnyone(game, curr) && belongsPlayer(game, playerFromCheck(game, currCheck), curr)) {
                        List<Cell> twoList = curr.getNeighborCells().get(Direction.values()[finalI]);
                        twoList.forEach(cell2 -> {
                            if (Math.abs(getDifference(game, cell) - getDifference(game, cell2)) == 1) {
                                if (belongAnyone(game, cell2)) {
                                    moveList.add(new Move(2, cell, cell2));
                                }
                            }
                        });
                    }
                });
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        return moveList;
    }

    public Player playerFromCheck(Game game, Checker currCheck) {
        AtomicReference<Player> curPlayer = new AtomicReference<>();
        List<Player> players = game.getPlayers();
        players.forEach(player -> game.getCheckerMap().get(player).forEach(checker -> {
            if (checker.equals(currCheck)) {
                curPlayer.set(player);
            }
        }));
        return curPlayer.get();
    }

    public boolean belongsPlayer(Game game, Player currPlayer, Cell currCell) {
        AtomicBoolean flag = new AtomicBoolean(true);
        game.getCheckerMap().get(currPlayer).forEach(checker -> {
            if (game.getCheckerCellMap().get(checker).equals(currCell)) {
                flag.set(false);
            }
        });
        return flag.get();
    }

    public List<Move> createsStep(Game game, Direction dir, Checker currCheck) {
        List<Move> list2 = new ArrayList<>();
        Cell cell = game.getCheckerCellMap().get(currCheck);
        list2.add(new Move(cell, cell));
        List<Cell> list = cell.getNeighborCells().get(dir);

        if (list != null) {
            list.forEach(cell1 -> {
                if (belongAnyone(game, cell1)) {
                    list2.add(new Move(1, cell, cell1));
                }
            });
        }
        return list2;
    }

    private boolean belongAnyone(Game game, Cell cell) {
        AtomicBoolean flag = new AtomicBoolean(true);
        game.getCheckerCellMap().forEach((key, value) -> {
            if (cell.equals(value)) flag.set(false);
        });
        return flag.get();
    }

    public void isDraw(Move move) {
        if (move.getPriority() == 0) {
            SwingUtils.showInfoMessageBox("Ничья");
            System.exit(0);
        }
    }

    public boolean isGameOver(Game game) {
        AtomicBoolean flag = new AtomicBoolean(true);
        List<Player> players = game.getPlayers();
        players.forEach(player -> {
            if (game.getCheckerMap().get(player).size() == 0) {
                SwingUtils.showInfoMessageBox("Проиграл " + player.getName());
                flag.set(false);
            }
        });
        return flag.get();
    }

    public void makeKing(Checker check) {
        check.setKing(true);
    }
}