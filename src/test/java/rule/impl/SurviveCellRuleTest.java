package rule.impl;

import model.CellState;
import model.impl.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SurviveCellRuleTest {

    private SurviveCellRule surviveCellRule;

    @BeforeEach
    void setUp() {
        surviveCellRule = new SurviveCellRule();
    }

    @Test
    public void given_dead_cell_rule_should_not_apply_and_remain_dead() {
        // Given
        final Cell giveCell = new Cell(CellState.DEAD, null);

        // When
        surviveCellRule.execute(giveCell, null);

        // Then
        assertTrue(giveCell.isDead());
    }

    @Test
    public void given_alive_cell_with_3_alive_neighbors_should_apply_and_live_after_action() {
        // Given
        final Cell giveCell = new Cell(CellState.ALIVE, null);
        final List<Cell> neighborCells = Arrays.asList(
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null));

        // When
        surviveCellRule.execute(giveCell, neighborCells);

        // Then
        assertTrue(giveCell.isAlive());
    }

    @Test
    public void given_alive_cell_with_2_alive_neighbors_should_apply_and_live_after_action() {
        // Given
        final Cell giveCell = new Cell(CellState.ALIVE, null);
        final List<Cell> neighborCells = Arrays.asList(
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null));

        // When
        surviveCellRule.execute(giveCell, neighborCells);

        // Then
        assertTrue(giveCell.isAlive());
    }

    @Test
    public void given_alive_cell_with_1_alive_neighbors_not_apply_and_remain_alive() {
        // Given
        final Cell giveCell = new Cell(CellState.ALIVE, null);
        final List<Cell> neighborCells = List.of(new Cell(CellState.ALIVE, null));

        // When
        surviveCellRule.execute(giveCell, neighborCells);

        // Then
        assertTrue(giveCell.isAlive());
    }

    @Test
    public void given_alive_cell_with_4_alive_neighbors_not_apply_and_remain_alive() {
        // Given
        final Cell giveCell = new Cell(CellState.ALIVE, null);
        final List<Cell> neighborCells = Arrays.asList(
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null),
                new Cell(CellState.ALIVE, null));

        // When
        surviveCellRule.execute(giveCell, neighborCells);

        // Then
        assertTrue(giveCell.isAlive());
    }
}