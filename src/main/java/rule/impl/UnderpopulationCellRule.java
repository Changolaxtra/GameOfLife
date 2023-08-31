package rule.impl;

import model.impl.Cell;
import rule.AbstractCellRule;

import java.util.List;

public class UnderpopulationCellRule extends AbstractCellRule {

    private static final int MIN_ALIVE_NEIGHBORS = 2;

    @Override
    protected boolean apply(Cell cell, List<Cell> neighborCells) {
        return cell.isAlive() && aliveNeighborUnderMinimum(neighborCells);
    }

    private boolean aliveNeighborUnderMinimum(List<Cell> neighborCells) {
        return getAliveNeighborsCount(neighborCells) < MIN_ALIVE_NEIGHBORS;
    }

    @Override
    protected void action(Cell cell) {
        cell.kill();
    }
}
