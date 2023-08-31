package rule.impl;

import model.impl.Cell;
import rule.AbstractCellRule;

import java.util.List;

public class SurviveCellRule extends AbstractCellRule {

    public static final int TWO_ALIVE_NEIGHBORS = 2;
    public static final int THREE_ALIVE_NEIGHBORS = 3;

    @Override
    protected boolean apply(final Cell cell, final List<Cell> neighborCells) {
        return isValidCell(cell, Cell::isAlive) && hasNeededAliveNeighborsToSurvive(neighborCells);
    }

    private boolean hasNeededAliveNeighborsToSurvive(final List<Cell> neighborCells) {
        long aliveNeighborsCount = getAliveNeighborsCount(neighborCells);
        return aliveNeighborsCount == TWO_ALIVE_NEIGHBORS || aliveNeighborsCount == THREE_ALIVE_NEIGHBORS;
    }

    @Override
    protected void action(final Cell cell) {
        cell.makeAlive();
    }

}
