package model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Coordinate {

    private final int x;
    private final int y;

    private List<Coordinate> adjacentCoordinates;

    public Coordinate(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Coordinate> getAdjacentCoordinates() {
        if (adjacentCoordinates == null) {
            adjacentCoordinates = calculateAdjacentCoordinates();
        }
        return adjacentCoordinates;
    }

    public boolean isPositive() {
        return (x >= 0) && (y >= 0);
    }

    private List<Coordinate> calculateAdjacentCoordinates() {
        return Arrays.asList(
                new Coordinate(x - 1, y),
                new Coordinate(x + 1, y),
                new Coordinate(x, y - 1),
                new Coordinate(x, y + 1),
                new Coordinate(x - 1, y - 1),
                new Coordinate(x - 1, y + 1),
                new Coordinate(x + 1, y - 1),
                new Coordinate(x + 1, y + 1)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Coordinate that = (Coordinate) o;
        return (x == that.x) && (y == that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
