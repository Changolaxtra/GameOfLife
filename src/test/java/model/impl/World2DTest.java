package model.impl;

import model.CellState;
import model.Coordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import rule.CellRuleEngine;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class World2DTest {

    private static final int WORLD_SIZE = 2;

    private World2D world;

    @BeforeEach
    void setUp() {
        world = new World2D(WORLD_SIZE);
    }

    @Test
    public void given_cell_should_be_added_and_retrieved_from_world_and_be_the_same() {
        // Given
        final Cell cell = new Cell(CellState.ALIVE, new Coordinate(0, 0));

        // When
        world.addCell(cell);
        final Cell worldCell = world.getCell(0, 0);

        //Then
        assertEquals(cell, worldCell);
    }

    @Test
    public void given_world_with_4_cells_getCellNeighbors_should_return_3_cells() {
        // Given
        populateWorld(world);
        final Cell worldCell = world.getCell(0, 0);

        //When
        final List<Cell> cellNeighbors = world.getCellNeighbors(worldCell);

        //Then
        assertNotNull(cellNeighbors);
        assertEquals(3, cellNeighbors.size());

    }

    private void populateWorld(World2D world) {
        world.addCell(new Cell(CellState.ALIVE, new Coordinate(0, 0)));
        world.addCell(new Cell(CellState.ALIVE, new Coordinate(0, 1)));
        world.addCell(new Cell(CellState.ALIVE, new Coordinate(1, 0)));
        world.addCell(new Cell(CellState.ALIVE, new Coordinate(1, 1)));
    }
}