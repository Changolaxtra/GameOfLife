package service.impl;

import model.CellState;
import model.Coordinate;
import model.impl.Cell;
import model.impl.World2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rule.CellRuleEngine;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StringWorld2DVisualizerTest {

    private static final int WORLD_SIZE = 2;
    private static final String EXPECTED_WORLD_STRING = "[A][A]\n[A][A]\n";

    private StringWorld2DVisualizer visualizer;
    private World2D world;

    @BeforeEach
    void setUp() {
        visualizer = new StringWorld2DVisualizer();
        world = new World2D(WORLD_SIZE, new CellRuleEngine(new ArrayList<>()));
    }

    @Test
    public void given_world_with_4_cells_the_string_should_be_the_expected() {
        // Given
        populateWorld(world);

        //When
        final String worldString = visualizer.visualize(world);

        //Then
        assertEquals(EXPECTED_WORLD_STRING, worldString);
    }

    private void populateWorld(World2D world) {
        world.addCell(new Cell(CellState.ALIVE, new Coordinate(0, 0)));
        world.addCell(new Cell(CellState.ALIVE, new Coordinate(0, 1)));
        world.addCell(new Cell(CellState.ALIVE, new Coordinate(1, 0)));
        world.addCell(new Cell(CellState.ALIVE, new Coordinate(1, 1)));
    }
}