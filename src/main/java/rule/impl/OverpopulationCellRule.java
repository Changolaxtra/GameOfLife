package rule.impl;

import model.impl.Cell;
import rule.AbstractCellRule;

import java.util.List;

public class OverpopulationCellRule extends AbstractCellRule {

    private static final long ALIVE_NEIGHBORS_LIMIT = 3L;

    @Override
    protected boolean apply(Cell cell, List<Cell> neighborCells) {
        final long aliveNeighbors = getAliveNeighborsCount(neighborCells);
        return cell.isAlive() && areAliveNeighborsOverLimit(aliveNeighbors);
    }

    @Override
    protected void action(Cell cell) {
        cell.kill();
    }

    private boolean areAliveNeighborsOverLimit(long aliveNeighbors) {
        return aliveNeighbors > ALIVE_NEIGHBORS_LIMIT;
    }
}
