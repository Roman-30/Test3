//package task1_chek;
//
//import task1_chek.models.Field;
//import task1_chek.models.Game;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class GamePanel extends JTable {
//    private final int size;
//    private Game game;
//
//    public GamePanel(int size, Game game) {
//        this.size = size;
//        this.game = game;
//    }
//
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//
//        Graphics2D gr = (Graphics2D) g;
//
//        drawPanel(gr, game);
//    }
//
//    private void drawPanel(Graphics2D gr, Game game) {
//        int x = 0;
//        int y = 0;
//        int cellNum = 8;
//        int num = size / cellNum;
//        for (int i = 0; i < cellNum; i++) {
//            for (int j = 0; j < cellNum; j++) {
//                gr.setColor((i + j) % 2 != 0 ? Color.BLACK : Color.WHITE);
//                gr.fillRect(x, y, num, num);
//                if (game.getField().getCellGraph() == Board.BLACK) {
//                    Color c = gr.getColor();
//                    gr.setColor(Color.RED);
//                    gr.fillOval(x + 2, y + 2, num - 5, num - 5);
//                    gr.setColor(c);
//                } else if (board[i][j] == Board.WHITE) {
//                    Color c = gr.getColor();
//                    gr.setColor(Color.BLUE);
//                    gr.fillOval(x + 2, y + 2, num - 5, num - 5);
//                    gr.setColor(c);
//                }
//                x += num;
//            }
//            x = 0;
//            y += num;
//        }
//
//        gr.setColor(Color.BLACK);
//        gr.drawLine(size - 5, 0, size - 5, size - 5);
//        gr.drawLine(0, 0, size - 5, 0);
//        gr.drawLine(0, 0, 0, size - 5);
//        gr.drawLine(0, size - 5, size - 5, size - 5);
//    }
//}
