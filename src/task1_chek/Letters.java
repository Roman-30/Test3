package task1_chek;

public enum Letters {
    A(1, 'A'),
    B(2, 'B'),
    C(3, 'C'),
    D(4, 'D'),
    E(5, 'E'),
    F(6, 'F'),
    G(7, 'G'),
    H(8, 'H');

    private final int number;
    private final char letter;

    Letters(int number, char litter) {
        this.number = number;
        this.letter = litter;
    }

    public int getNumber() {
        return number;
    }

    public char getLetter() {
        return letter;
    }
}
