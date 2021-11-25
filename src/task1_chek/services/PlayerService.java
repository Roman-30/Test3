package task1_chek.services;

import task1_chek.models.Checker;
import task1_chek.models.Direction;
import task1_chek.models.Game;
import task1_chek.models.Player;

import java.util.*;

public class PlayerService {

    private static final int MAX_CHECKER_NUMBER = 12;

    public boolean hasCheck(Checker check, Map<Player, Checker> map, Player player) {
        for (int i = 0; i < map.size(); i++) {
            if (check.equals(map.get(player))) {
                return true;
            }
        }
        return false;
    }

    public Map<Player, Direction> createQueue(Game game) {
        Map<Player, Direction> queue = new LinkedHashMap<>();
        queue.put(game.getPlayers().get(0), Direction.DOWN);
        queue.put(game.getPlayers().get(1), Direction.UP);
        return queue;
    }

    public List<Player> createPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Alex"));
        players.add(new Player("Bill"));
        return players;
    }

    public List<Checker> createCheckers() {
        List<Checker> checkers = new ArrayList<>();
        for (int i = 0; i < MAX_CHECKER_NUMBER; i++) {
            checkers.add(new Checker(false));
        }
        return checkers;
    }

    public Map<Player, List<Checker>> fillCheckers(List<Player> players) {
        Map<Player, List<Checker>> map = new HashMap<>();
        for (Player value : players) {
            map.put(value, createCheckers());
        }
        return map;
    }
}
