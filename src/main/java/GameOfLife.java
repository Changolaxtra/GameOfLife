import model.impl.World2D;
import rule.CellRule;
import rule.CellRuleEngine;
import rule.impl.OverpopulationCellRule;
import rule.impl.ReproductionCellRule;
import rule.impl.SurviveCellRule;
import rule.impl.UnderpopulationCellRule;
import service.impl.RandomWorld2DGeneratorService;
import service.impl.StringWorld2DVisualizer;
import service.impl.SwingWorldVisualizer;

import java.util.Arrays;
import java.util.List;

public class GameOfLife {

    private static final int WORLD_SIZE = 20;
    private static final int GENERATIONS = 100;

    public static void main(String[] args) throws InterruptedException {
        final CellRule ruleEngine = createRuleEngine();
        final RandomWorld2DGeneratorService worldGeneratorService =
                new RandomWorld2DGeneratorService(WORLD_SIZE, ruleEngine);

        final World2D world = worldGeneratorService.generateWorld();
        final StringWorld2DVisualizer visualizer = new StringWorld2DVisualizer();
        final SwingWorldVisualizer guiVisualizer = new SwingWorldVisualizer();

        for (int i = 0; i < GENERATIONS; i++) {
            world.runGeneration();
            Thread.sleep(500);
            //System.out.println(visualizer.visualize(world));
            guiVisualizer.visualize(world);
        }

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
}
