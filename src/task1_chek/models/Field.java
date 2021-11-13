package task1_chek.models;

import task1_chek.utils.Graph;

public class Field {
    private Graph<Cell> cellGraph;

    public Field(Graph<Cell> cellGraph) {
        this.cellGraph = cellGraph;
    }

    public Graph<Cell> getCellGraph() {
        return cellGraph;
    }

    public void setCellGraph(Graph<Cell> cellGraph) {
        this.cellGraph = cellGraph;
    }
}
