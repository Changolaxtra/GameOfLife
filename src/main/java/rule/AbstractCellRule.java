package rule;

import model.impl.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class AbstractCellRule implements CellRule {
    protected abstract boolean apply(Cell cell, List<Cell> neighborCells);

    protected abstract void action(Cell cell);

    public void execute(final Cell cell, final List<Cell> neighborCells) {
        if (apply(cell, neighborCells)) {
            action(cell);
        }
    }

    protected boolean isValidCell(final Cell cell, final Predicate<Cell> condition) {
        return cell != null && condition.test(cell);
    }

    protected long getAliveNeighborsCount(final List<Cell> neighborCells) {
        return getNeighborsCountByCondition(neighborCells, Cell::isAlive);
    }

    private long getNeighborsCountByCondition(final List<Cell> neighborCells,
                                              final Predicate<Cell> condition) {
        return Optional.ofNullable(neighborCells)
                .orElse(new ArrayList<>())
                .stream()
                .filter(condition)
                .count();
    }

}
