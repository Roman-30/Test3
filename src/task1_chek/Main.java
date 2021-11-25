package task1_chek;

import task1_chek.factories.FieldFactory;
import task1_chek.factories.SimpleFieldFactory;
import task1_chek.gui.MainWindow;
import task1_chek.models.Game;
import task1_chek.services.GameService;
import task1_chek.services.GraphicService;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GameService gs = new GameService();
        GraphicService gu = new GraphicService();
        FieldFactory fieldFactory = new SimpleFieldFactory();
        Game game = gs.createGame(fieldFactory);
        //gs.check(game);
        MainWindow mainWindow = new MainWindow(game, gu, gs);
        mainWindow.setVisible(true);
    }
}

