package visualizer.impl;

import model.impl.World;

import javax.swing.*;
import java.awt.*;

public class PartialGraphicWorldUpdater implements Runnable {

    private final World world;
    private final JLabel[][] grid;
    private final int partitionX;

    public PartialGraphicWorldUpdater(final World world, final JLabel[][] grid, final int partitionX) {
        this.world = world;
        this.grid = grid;
        this.partitionX = partitionX;
    }

    @Override
    public void run() {
        for (int y = 0; y < world.getSize(); y++) {
            final Color color = world.getCell(partitionX, y).isAlive() ? Color.GREEN : Color.BLACK;
            grid[partitionX][y].setBackground(color);
        }
    }
}
