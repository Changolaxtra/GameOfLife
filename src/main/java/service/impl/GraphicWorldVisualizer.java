package service.impl;

import model.impl.World2D;
import service.WorldVisualizer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GraphicWorldVisualizer implements WorldVisualizer {

    private static final int CELL_SIZE = 32;
    public static final int FINISH_DELAY_MILLIS = 30000;
    private final JFrame frame;
    private final JPanel panel;
    private final long delay;
    private JLabel[][] grid;

    public GraphicWorldVisualizer(final long delay) {
        this.panel = new JPanel();
        this.frame = new JFrame();
        this.delay = delay;
    }

    @Override
    public void visualize(World2D world) {
        initLabelPanel(world.getSize());
        try {
            Thread.sleep(delay);
            for (int x = 0; x < world.getSize(); x++) {
                for (int y = 0; y < world.getSize(); y++) {
                    final Color color = world.getCell(x, y).isAlive() ? Color.GREEN : Color.BLACK;
                    grid[x][y].setBackground(color);
                }
            }
            frame.setTitle("Generation " + world.getGeneration());
            frame.setVisible(true);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void finish() {
        try {
            Thread.sleep(FINISH_DELAY_MILLIS);
            frame.setVisible(false);
            frame.dispose();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void initLabelPanel(final int size) {
        if (grid == null) {
            panel.setLayout(new GridLayout(size, size));
            grid = new JLabel[size][size];
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    createLabel(x, y);
                }
            }
            configureWindowSize(size);
        }
    }

    private void createLabel(int x, int y) {
        grid[x][y] = new JLabel();
        grid[x][y].setBorder(new LineBorder(Color.WHITE));
        grid[x][y].setOpaque(true);
        grid[x][y].setMinimumSize(new Dimension(CELL_SIZE, CELL_SIZE));
        grid[x][y].setMinimumSize(new Dimension(CELL_SIZE, CELL_SIZE));
        panel.add(grid[x][y]);
    }

    private void configureWindowSize(final int size) {
        final int calculatedSize = size * CELL_SIZE;

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, calculatedSize, calculatedSize);
    }
}
