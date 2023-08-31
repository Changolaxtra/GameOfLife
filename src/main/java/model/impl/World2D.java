package model.impl;

import model.Coordinate;
import rule.CellRule;
import rule.CellRuleEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class World2D implements World {

    private final Cell[][] worldMap;
    private final int size;
    private final CellRule cellRuleEngine;

    public World2D(int size, CellRule cellRuleEngine) {
        this.size = size;
        this.cellRuleEngine = cellRuleEngine;
        worldMap = new Cell[size][size];
    }

    @Override
    public void addCell(final Cell cell) {
        final int coordinateX = cell.getCoordinate().getX();
        final int coordinateY = cell.getCoordinate().getY();
        worldMap[coordinateX][coordinateY] = cell;
    }

    @Override
    public Cell getCell(int coordinateX, int coordinateY) {
        return worldMap[coordinateX][coordinateY];
    }

    @Override
    public List<Cell> getCellNeighbors(final Cell cell) {
        return Optional.ofNullable(cell)
                .map(Cell::getCoordinate)
                .map(Coordinate::getAdjacentCoordinates)
                .orElse(new ArrayList<>())
                .stream()
                .filter(Coordinate::isPositive)
                .filter(this::insideLimits)
                .map(coordinate -> getCell(coordinate.getX(), coordinate.getY()))
                .collect(Collectors.toList());
    }

    @Override
    public void runGeneration() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                final Cell cell = getCell(x, y);
                cellRuleEngine.execute(cell, getCellNeighbors(cell));
            }
        }
    }

    private boolean insideLimits(final Coordinate coordinate) {
        return (coordinate.getX() < size) && (coordinate.getY() < size);
    }

    public int getSize() {
        return size;
    }
}
