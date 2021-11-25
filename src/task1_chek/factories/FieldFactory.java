package task1_chek.factories;

import task1_chek.models.Cell;

import java.util.List;
import java.util.Map;

public interface FieldFactory {
    Map<Character, List<Cell>> createField();
    Map<Character, List<Cell>> initCellsListMap();
}
