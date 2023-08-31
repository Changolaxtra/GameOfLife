package rule.impl;

import model.CellState;
import model.impl.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnderpopulationCellRuleTest {

    private UnderpopulationCellRule underpopulationCellRule;

    @BeforeEach
    void setUp() {
        underpopulationCellRule = new UnderpopulationCellRule();
    }

    @Test
    public void given_dead_cell_rule_should_not_apply_and_remain_dead() {
        // Given
        final Cell givenCell = new Cell(CellState.DEAD, null);

        // When
        underpopulationCellRule.execute(givenCell, null);

        // Then
        assertTrue(givenCell.isDead());
    }

    @Test
    public void given_alive_cell_with_1_live_neighbor_cells_should_dead_after_action() {
        // Given
        final Cell givenCell = new Cell(CellState.ALIVE, null);
        final List<Cell> neighborCells = List.of(
                new Cell(CellState.ALIVE, null));

        // When
        underpopulationCellRule.execute(givenCell, neighborCells);

        // Then
        assertTrue(givenCell.isDead());
    }

    @Test
    public void given_alive_cell_with_0_live_neighbor_cells_should_dead_after_action() {
        // Given
        final Cell givenCell = new Cell(CellState.ALIVE, null);
        final List<Cell> neighborCells = new ArrayList<>();

        // When
        underpopulationCellRule.execute(givenCell, neighborCells);

        // Then
        assertTrue(givenCell.isDead());
    }
}