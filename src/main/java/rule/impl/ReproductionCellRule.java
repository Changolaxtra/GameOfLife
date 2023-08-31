package rule.impl;

import model.impl.Cell;
import rule.AbstractCellRule;

import java.util.List;

public class ReproductionCellRule extends AbstractCellRule {

    public static final long EXACT_ALIVE_NEIGHBORS = 3L;

    @Override
    protected boolean apply(Cell cell, List<Cell> neighborCells) {
        final long aliveNeighbors = getAliveNeighborsCount(neighborCells);
        return cell.isDead() && hasExactCountAliveNeighbors(aliveNeighbors);
    }

    private boolean hasExactCountAliveNeighbors(long aliveNeighbors) {
        return aliveNeighbors == EXACT_ALIVE_NEIGHBORS;
    }

    @Override
    protected void action(Cell cell) {
        cell.makeAlive();
    }
}
