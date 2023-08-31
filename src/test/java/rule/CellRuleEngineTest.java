package rule;

import model.CellState;
import model.Coordinate;
import model.impl.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

class CellRuleEngineTest {

    @Spy
    private CellRule rule1;
    @Spy
    private CellRule rule3;
    @Spy
    private CellRule rule2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_list_of_rules_all_should_be_executed_over_cell_and_neighbors(){
        // Given
        final CellRuleEngine cellRuleEngine = new CellRuleEngine(Arrays.asList(rule1, rule2, rule3));
        final Cell cell = new Cell(CellState.ALIVE, new Coordinate(0,0));
        final List<Cell> neighbors = new ArrayList<>();

        // When
        cellRuleEngine.execute(cell, neighbors);

        // Then
        verify(rule1, only()).execute(cell, neighbors);
        verify(rule2, only()).execute(cell, neighbors);
        verify(rule3, only()).execute(cell, neighbors);
    }

}