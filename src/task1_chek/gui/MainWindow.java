package task1_chek.gui;

import task1_chek.models.Game;
import task1_chek.services.GameService;
import task1_chek.services.GraphicService;

import javax.swing.*;

public class MainWindow extends JFrame {
    private static final int COORDINATE_X = 410;
    private static final int COORDINATE_Y = 135;

    private static final int WIDTH = 510;
    private static final int HEIGHT = 535;

    private final GamePanel dp;

    public MainWindow(Game game, GraphicService gu, GameService gs) throws InterruptedException {
        this.setBounds(COORDINATE_X, COORDINATE_Y, WIDTH, HEIGHT);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        dp = new GamePanel(500, gu, gu.createMatrix(game));
        this.add(dp);

        this.setVisible(true);
        gs.runGame(game, this);
    }

    public GamePanel getDp() {
        return dp;
    }

    public JFrame getFr() {
        return this;
    }
}
