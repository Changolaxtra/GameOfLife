package rule.impl;

import model.impl.Cell;
import rule.AbstractCellRule;

import java.util.List;

public class UnderpopulationCellRule extends AbstractCellRule {

    private static final int MIN_ALIVE_NEIGHBORS = 2;

    @Override
    protected boolean apply(final Cell cell, final List<Cell> neighborCells) {
        return isValidCell(cell, Cell::isAlive) && aliveNeighborUnderMinimum(neighborCells);
    }

    private boolean aliveNeighborUnderMinimum(final List<Cell> neighborCells) {
        return getAliveNeighborsCount(neighborCells) < MIN_ALIVE_NEIGHBORS;
    }

    @Override
    protected void action(final Cell cell) {
        cell.kill();
    }
}
