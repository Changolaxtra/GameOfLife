package service;

import model.impl.Cell;
import model.impl.World2D;
import org.junit.jupiter.api.Test;
import rule.CellRuleEngine;
import service.impl.RandomWorld2DGeneratorService;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RandomWorldGeneratorServiceTest {

    @Test
    public void given_size_of_3_should_generate_world_with_9_valid_cells(){
        // Given
        final RandomWorld2DGeneratorService randomWorldGeneratorService = new RandomWorld2DGeneratorService(3);

        // When
        final World2D world = randomWorldGeneratorService.generateWorld();

        // Then
        assertNotNull(world);
        final Cell cell = world.getCell(0, 0);
        assertNotNull(cell);
        assertNotNull(cell.getCoordinate());
    }
}