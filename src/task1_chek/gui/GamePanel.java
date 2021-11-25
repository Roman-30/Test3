package task1_chek.gui;

import task1_chek.models.Color;
import task1_chek.models.Game;
import task1_chek.services.GraphicService;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JTable {
    private static final int cellNum = 8;

    private final int size;
    private final GraphicService gu;
    private Color[][] color;

    public GamePanel(int size, GraphicService gu, Color[][] color) {
        this.size = size;
        this.gu = gu;
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gr = (Graphics2D) g;
        drawPanel(gr, color);
    }

    public void setBoard(Game game) {
        this.color = gu.createMatrix(game);
    }

    private void drawPanel(Graphics2D gr, Color[][] color) {
        int x = 0;
        int y = 0;
        int num = size / cellNum;
        for (int i = 0; i < cellNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                gr.setColor((i + j) % 2 != 0 ? java.awt.Color.BLACK : java.awt.Color.WHITE);
                gr.fillRect(x, y, num, num);
                if (color[i][j] == Color.BLACK) {
                    java.awt.Color c = gr.getColor();
                    gr.setColor(java.awt.Color.RED);
                    gr.fillOval(x + 2, y + 2, num - 5, num - 5);
                    gr.setColor(c);
                } else if (color[i][j] == Color.WHITE) {
                    java.awt.Color c = gr.getColor();
                    gr.setColor(java.awt.Color.BLUE);
                    gr.fillOval(x + 2, y + 2, num - 5, num - 5);
                    gr.setColor(c);
                }
                x += num;
            }
            x = 0;
            y += num;
        }
        gr.setColor(java.awt.Color.BLACK);
        gr.drawLine(size - 5, 0, size - 5, size - 5);
        gr.drawLine(0, 0, size - 5, 0);
        gr.drawLine(0, 0, 0, size - 5);
        gr.drawLine(0, size - 5, size - 5, size - 5);
    }
}
