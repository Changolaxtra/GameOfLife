package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoordinateTest {

    @Test
    void given_coordinate_with_values_3_and_5_getX_should_be_3() {
        //Given
        final Coordinate coordinate = new Coordinate(3, 5);

        //When
        final int x = coordinate.getX();

        //Then
        assertEquals(3, x);
    }

    @Test
    void given_coordinate_with_values_3_and_5_getY_should_be_5() {
        //Given
        final Coordinate coordinate = new Coordinate(3, 5);

        //When
        final int y = coordinate.getY();

        //Then
        assertEquals(5, y);
    }

    @Test
    void given_coordinate_with_values_3_and_5_should_be_positive() {
        //Given
        final Coordinate coordinate = new Coordinate(3, 5);

        //When
        final boolean isPositive = coordinate.isPositive();

        //Then
        assertTrue(isPositive);
    }

    @Test
    void given_coordinate_with_negative_value_3_and_positive_5_should_be_positive() {
        //Given
        final Coordinate coordinate = new Coordinate(-3, 5);

        //When
        final boolean isPositive = coordinate.isPositive();

        //Then
        assertFalse(isPositive);
    }

    @Test
    void given_coordinate_with_values_1_and_1_getAdjacentCoordinate_should_return_correct_coordinates() {
        //Given
        final Coordinate coordinate = new Coordinate(1, 1);

        //When
        final List<Coordinate> adjacentCoordinates = coordinate.getAdjacentCoordinates();

        //Then
        assertNotNull(adjacentCoordinates);
        assertEquals(8, adjacentCoordinates.size());
        assertThat(getCalculatedCoordinates()).containsAll(adjacentCoordinates);
    }

    private List<Coordinate> getCalculatedCoordinates() {
        return Arrays.asList(
                new Coordinate(0, 0),
                new Coordinate(0, 1),
                new Coordinate(0, 2),
                new Coordinate(1, 0),
                new Coordinate(1, 2),
                new Coordinate(2, 0),
                new Coordinate(2, 1),
                new Coordinate(2, 2)
        );
    }
}