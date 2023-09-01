package rule.impl;

import model.impl.World;
import rule.CellRule;
import rule.GenerationRuleRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentGenerationRuleRunner implements GenerationRuleRunner {

    private static final int THREADS = 50;
    private final ExecutorService executor;

    public ConcurrentGenerationRuleRunner() {
        executor = Executors.newFixedThreadPool(THREADS);
    }

    @Override
    public void run(final World world, final CellRule cellRuleEngine) {
        for (int x = 0; x < world.getSize(); x++) {
            executor.execute(new PartialGenerationRuleRunner(world, cellRuleEngine, x));
        }
        world.increaseGeneration();
    }

    @Override
    public void stop() {
        executor.shutdown();
    }
}
