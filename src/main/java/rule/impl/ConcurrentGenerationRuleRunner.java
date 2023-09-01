package rule.impl;

import model.impl.World;
import rule.CellRule;
import rule.GenerationRuleRunner;
import rule.impl.concurrent.PartialGenerationRuleRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentGenerationRuleRunner implements GenerationRuleRunner {

    @Override
    public void run(final World world, final CellRule cellRuleEngine) {
        final ExecutorService executor = Executors.newFixedThreadPool(world.getSize());
        for (int x = 0; x < world.getSize(); x++) {
            executor.execute(new PartialGenerationRuleRunner(world, cellRuleEngine, x));
        }
        world.increaseGeneration();
        executor.shutdown();
    }
}
