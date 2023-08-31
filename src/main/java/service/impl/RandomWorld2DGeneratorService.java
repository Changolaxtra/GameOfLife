package service.impl;

import model.CellState;
import model.Coordinate;
import model.impl.Cell;
import model.impl.World2D;
import rule.CellRule;
import service.WorldGeneratorService;

import java.util.concurrent.ThreadLocalRandom;

public class RandomWorld2DGeneratorService implements WorldGeneratorService {

    private final int size;
    private final CellRule cellRuleEngine;

    public RandomWorld2DGeneratorService(final int size, final CellRule cellRuleEngine) {
        this.size = size;
        this.cellRuleEngine = cellRuleEngine;
    }

    @Override
    public World2D generateWorld() {
        final World2D world = new World2D(size, cellRuleEngine);
        populateWorld(world);
        return world;
    }

    private void populateWorld(final World2D world) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                world.addCell(createCell(new Coordinate(x, y)));
            }
        }
    }

    private Cell createCell(final Coordinate coordinate) {
        return new Cell(getState(), coordinate);
    }

    private CellState getState() {
        final int randomNumber = ThreadLocalRandom.current().nextInt();
        return randomNumber % 2 == 0 ? CellState.ALIVE : CellState.DEAD;
    }

}
