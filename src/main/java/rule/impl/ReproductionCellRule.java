package rule.impl;

import model.impl.Cell;
import rule.AbstractCellRule;

import java.util.List;

public class ReproductionCellRule extends AbstractCellRule {

    public static final long EXACT_ALIVE_NEIGHBORS = 3L;

    @Override
    protected boolean apply(final Cell cell, final List<Cell> neighborCells) {
        final long aliveNeighbors = getAliveNeighborsCount(neighborCells);
        return isValidCell(cell, Cell::isDead) && hasExactCountAliveNeighbors(aliveNeighbors);
    }

    private boolean hasExactCountAliveNeighbors(final long aliveNeighbors) {
        return aliveNeighbors == EXACT_ALIVE_NEIGHBORS;
    }

    @Override
    protected void action(final Cell cell) {
        cell.makeAlive();
    }
}
