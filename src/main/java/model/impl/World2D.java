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

    private int generation = 0;

    public World2D(int size) {
        this.size = size;
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
    public void increaseGeneration() {
        generation++;
    }

    @Override
    public int getGeneration() {
        return generation;
    }

    @Override
    public int getSize() {
        return size;
    }

    private boolean insideLimits(final Coordinate coordinate) {
        return (coordinate.getX() < size) && (coordinate.getY() < size);
    }
}
