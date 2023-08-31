package model.impl;

import model.Coordinate;
import model.PrimitiveCell;
import model.CellState;

public class Cell implements PrimitiveCell {
    private CellState state;
    private final Coordinate coordinate;

    public Cell(final CellState state, final Coordinate coordinate) {
        this.state = state;
        this.coordinate = coordinate;
    }

    @Override
    public boolean isAlive() {
        return CellState.ALIVE == this.state;
    }

    @Override
    public boolean isDead() {
        return CellState.DEAD == this.state;
    }

    @Override
    public void kill() {
        this.state = CellState.DEAD;
    }

    @Override
    public void makeAlive() {
        this.state = CellState.ALIVE;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
