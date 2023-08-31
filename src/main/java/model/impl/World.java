package model.impl;

import java.util.List;

public interface World {
    void addCell(Cell cell);
    Cell getCell(int coordinateX, int coordinateY);
    List<Cell> getCellNeighbors(Cell cell);
    void runGeneration();
    int getGeneration();
}
