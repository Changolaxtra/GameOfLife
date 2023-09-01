package rule.impl.concurrent;

import model.impl.Cell;
import model.impl.World;
import rule.CellRule;

public class PartialGenerationRuleRunner implements Runnable {

    private final World world;
    private final CellRule cellRuleEngine;

    private final int partitionX;

    public PartialGenerationRuleRunner(final World world, final CellRule cellRuleEngine, final int partitionX) {
        this.world = world;
        this.cellRuleEngine = cellRuleEngine;
        this.partitionX = partitionX;
    }

    @Override
    public void run() {
        for (int y = 0; y < world.getSize(); y++) {
            final Cell worldCell = world.getCell(partitionX, y);
            cellRuleEngine.execute(worldCell, world.getCellNeighbors(worldCell));
        }
    }

}
