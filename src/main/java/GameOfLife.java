import model.impl.World2D;
import rule.CellRule;
import rule.CellRuleEngine;
import rule.impl.OverpopulationCellRule;
import rule.impl.ReproductionCellRule;
import rule.impl.SurviveCellRule;
import rule.impl.UnderpopulationCellRule;
import service.WorldVisualizer;
import service.impl.ConsoleWorld2DVisualizer;
import service.impl.GraphicWorldVisualizer;
import service.impl.RandomWorld2DGeneratorService;

import java.util.Arrays;
import java.util.List;

public class GameOfLife {

    private static final int WORLD_SIZE = 20;
    private static final int GENERATIONS = 100;
    private static boolean USE_GUI = true;
    private static long MILLI_DELAY = 500L;

    public static void main(String[] args) {
        final RandomWorld2DGeneratorService worldGeneratorService =
                new RandomWorld2DGeneratorService(WORLD_SIZE, createRuleEngine());

        final World2D world = worldGeneratorService.generateWorld();
        final WorldVisualizer visualizer = getWorldVisualizer();

        for (int i = 0; i < GENERATIONS; i++) {
            world.runGeneration();
            System.out.println("Generation: " + (i + 1));
            visualizer.visualize(world);
        }
        visualizer.finish();
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
        return USE_GUI ? new GraphicWorldVisualizer(MILLI_DELAY) : new ConsoleWorld2DVisualizer();
    }
}
