package rule.impl;

import model.CellState;
import model.impl.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReproductionCellRuleTest {

    private ReproductionCellRule reproductionCellRule;

    @BeforeEach
    void setUp() {
        reproductionCellRule = new ReproductionCellRule();
    }

    @Test
    public void given_alive_cell_should_not_apply_and_remain_alive() {
        // Given
        final Cell givenCell = new Cell(CellState.ALIVE, null);

        // When
        reproductionCellRule.execute(givenCell, null);

        // Then
        assertTrue(givenCell.isAlive());
    }

    @Test
    public void given_dead_cell_with_3_alive_neighbors_should_apply_and_live_after_action() {
        // Given
        final Cell givenCell = new Cell(CellState.DEAD, null);
        final List<Cell> neighborCells = Arrays.asList(
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null));

        // When
        reproductionCellRule.execute(givenCell, neighborCells);

        // Then
        assertTrue(givenCell.isAlive());
    }

    @Test
    public void given_dead_cell_with_2_alive_neighbors_should_not_apply_and_remain_dead() {
        // Given
        final Cell givenCell = new Cell(CellState.DEAD, null);
        final List<Cell> neighborCells = Arrays.asList(
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null));

        // When
        reproductionCellRule.execute(givenCell, neighborCells);

        // Then
        assertTrue(givenCell.isDead());
    }

    @Test
    public void given_dead_cell_with_4_alive_neighbors_should_not_apply_and_remain_dead() {
        // Given
        final Cell givenCell = new Cell(CellState.DEAD, null);
        final List<Cell> neighborCells = Arrays.asList(
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null));

        // When
        reproductionCellRule.execute(givenCell, neighborCells);

        // Then
        assertTrue(givenCell.isDead());
    }


}