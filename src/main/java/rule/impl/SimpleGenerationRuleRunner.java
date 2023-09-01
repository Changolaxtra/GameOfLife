package rule.impl;

import model.impl.Cell;
import model.impl.World;
import rule.CellRule;
import rule.GenerationRuleRunner;

public class SimpleGenerationRuleRunner implements GenerationRuleRunner {

    @Override
    public void run(final World world, final CellRule cellRuleEngine) {
        final int size = world.getSize();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                final Cell cell = world.getCell(x, y);
                cellRuleEngine.execute(cell, world.getCellNeighbors(cell));
            }
        }
        world.increaseGeneration();
    }

    @Override
    public void stop() {

    }
}
