package task1_chek.services;

import task1_chek.models.Checker;
import task1_chek.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerService {

    // вынести магически числа // не выносим сообщения
    private static final int MAX_CHECKER_NUMBER = 12;

    public boolean hasCheck(Checker check, Map<Player, Checker> map, Player player) {
        for (int i = 0; i < map.size(); i++) {
            if (check.equals(map.get(player))) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Checker> setCheckers() {
        ArrayList<Checker> checkers = new ArrayList<>();
        for (int i = 0; i < MAX_CHECKER_NUMBER; i++) {
            checkers.add(new Checker(false));
        }
        return checkers;
    }

    public ArrayList<Player> setPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Alex"));
        players.add(new Player("Bill"));
        return players;
    }

    public Map<Player, ArrayList<Checker>> fillCheckers(ArrayList<Player> players) {      // TODO: 28.10.2021 разбить на подметод
        Map<Player, ArrayList<Checker>> map = new HashMap<>();
        for (Player value : players) {                                               // TODO: 28.10.2021 убрать лист мапов
            map.put(value, setCheckers());
        }
        return map;
    }

    //Метод для заполнения шашками из класса Player
    // Очистка
}
