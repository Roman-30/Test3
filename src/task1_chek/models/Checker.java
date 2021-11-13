package task1_chek.models;

import java.awt.*;

public class Checker {
    private boolean isKing;
    private Color checColor;

    public Checker(boolean isKing) {
        this.isKing = isKing;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean king) {
        isKing = king;
    }
}
