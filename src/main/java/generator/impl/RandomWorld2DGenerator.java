package generator.impl;

import generator.WorldGenerator;
import model.CellState;
import model.Coordinate;
import model.impl.Cell;
import model.impl.World2D;

import java.util.concurrent.ThreadLocalRandom;

public class RandomWorld2DGenerator implements WorldGenerator {

    private final int size;

    public RandomWorld2DGenerator(final int size) {
        this.size = size;
    }

    @Override
    public World2D generateWorld() {
        final World2D world = new World2D(size);
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
