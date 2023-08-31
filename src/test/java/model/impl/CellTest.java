package model.impl;

import model.CellState;
import model.Coordinate;
import model.PrimitiveCell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CellTest {

    @Test
    void given_alive_cell_the_state_should_be_alive() {
        //Given
        final PrimitiveCell cell = new Cell(CellState.ALIVE, new Coordinate(0, 0));
        // When
        boolean isAlive = cell.isAlive();

        //Then
        assertTrue(isAlive);
    }

    @Test
    void given_alive_cell_state_should_be_dead_after_call_kill() {
        //Given
        final PrimitiveCell cell = new Cell(CellState.ALIVE, new Coordinate(0, 0));
        // When
        cell.kill();
        boolean isDead = cell.isDead();

        //Then
        assertTrue(isDead);
    }

    @Test
    void given_dead_cell_should_be_alive_after_call_makeAlive() {
        //Given
        final PrimitiveCell cell = new Cell(CellState.DEAD, new Coordinate(0, 0));
        // When
        cell.makeAlive();
        boolean isAlive = cell.isAlive();

        //Then
        assertTrue(isAlive);
    }
}