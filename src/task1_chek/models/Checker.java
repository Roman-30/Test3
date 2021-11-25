package task1_chek.models;

public class Checker {
    private boolean isKing;

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
