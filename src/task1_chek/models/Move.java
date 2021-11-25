package task1_chek.models;

import java.util.Objects;

public class Move {
    private int priority;
    private Cell start;
    private Cell end;

    public Move(int priority, Cell start, Cell end) {
        this.priority = priority;
        this.start = start;
        this.end = end;
    }

    public Move(Cell start, Cell end) {
        this(0, start, end);
    }

    @Override
    public String toString() {
        return "Move{" +
                "priority=" + priority +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return priority == move.priority &&
                start.equals(move.start) &&
                end.equals(move.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority, start, end);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Cell getStart() {
        return start;
    }

    public void setStart(Cell start) {
        this.start = start;
    }

    public Cell getEnd() {
        return end;
    }

    public void setEnd(Cell end) {
        this.end = end;
    }
}
