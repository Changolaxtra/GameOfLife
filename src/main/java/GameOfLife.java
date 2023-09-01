import model.impl.World2D;
import rule.CellRule;
import rule.CellRuleEngine;
import rule.GenerationRuleRunner;
import rule.impl.ConcurrentGenerationRuleRunner;
import rule.impl.OverpopulationCellRule;
import rule.impl.ReproductionCellRule;
import rule.impl.SurviveCellRule;
import rule.impl.UnderpopulationCellRule;
import visualizer.WorldVisualizer;
import visualizer.impl.ConsoleWorld2DVisualizer;
import visualizer.impl.GraphicWorld2DVisualizer;
import generator.impl.RandomWorld2DGenerator;

import java.util.Arrays;
import java.util.List;

public class GameOfLife {

    private static final int WORLD_SIZE = 50;
    private static final int GENERATIONS = 100;
    private static boolean USE_GUI = true;
    private static long MILLI_DELAY = 500L;

    public static void main(String[] args) {
        final RandomWorld2DGenerator worldGeneratorService = new RandomWorld2DGenerator(WORLD_SIZE);
        final World2D world = worldGeneratorService.generateWorld();

        final CellRuleEngine ruleEngine = createRuleEngine();
        final GenerationRuleRunner generationRuleRunner = new ConcurrentGenerationRuleRunner();

        final WorldVisualizer visualizer = getWorldVisualizer();

        for (int i = 0; i < GENERATIONS; i++) {
            visualizer.visualize(world);
            generationRuleRunner.run(world, ruleEngine);
        }
        visualizer.finish();
        generationRuleRunner.stop();
    }

    private static CellRuleEngine createRuleEngine() {
        final List<CellRule> rules = Arrays.asList(
                new UnderpopulationCellRule(),
                new SurviveCellRule(),
                new OverpopulationCellRule(),
                new ReproductionCellRule()
        );
        return new CellRuleEngine(rules);
    }


    private static WorldVisualizer getWorldVisualizer() {
        return USE_GUI ? new GraphicWorld2DVisualizer(MILLI_DELAY) : new ConsoleWorld2DVisualizer();
    }
}
