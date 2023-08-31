package rule;

import model.impl.Cell;

import java.util.List;

public interface CellRule {
    void execute(Cell cell, List<Cell> neighborCells);
}
