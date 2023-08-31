package rule.impl;

import model.CellState;
import model.impl.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OverpopulationCellRuleTest {

    private OverpopulationCellRule overpopulationCellRule;

    @BeforeEach
    void setUp() {
        overpopulationCellRule = new OverpopulationCellRule();
    }

    @Test
    public void given_dead_cell_rule_should_not_apply_and_remain_dead() {
        // Given
        final Cell givenCell = new Cell(CellState.DEAD, null);

        // When
        overpopulationCellRule.execute(givenCell, null);

        // Then
        assertTrue(givenCell.isDead());
    }

    @Test
    public void given_alive_cell_with_more_than_3_live_neighbor_cells_should_apply_and_die_after_action() {
        // Given
        final Cell givenCell = new Cell(CellState.ALIVE, null);
        final List<Cell> neighborCells = Arrays.asList(
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null));

        // When
        overpopulationCellRule.execute(givenCell, neighborCells);

        // Then
        assertTrue(givenCell.isDead());
    }

    @Test
    public void given_alive_cell_with_3_live_neighbor_cells_should_not_apply_and_live_after_action() {
        // Given
        final Cell givenCell = new Cell(CellState.ALIVE, null);
        final List<Cell> neighborCells = Arrays.asList(
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null));

        // When
        overpopulationCellRule.execute(givenCell, neighborCells);

        // Then
        assertTrue(givenCell.isAlive());
    }

    @Test
    public void given_alive_cell_with_2_live_neighbor_cells_should_not_apply_and_live_after_action() {
        // Given
        final Cell givenCell = new Cell(CellState.ALIVE, null);
        final List<Cell> neighborCells = Arrays.asList(
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null));

        // When
        overpopulationCellRule.execute(givenCell, neighborCells);

        // Then
        assertTrue(givenCell.isAlive());
    }

}