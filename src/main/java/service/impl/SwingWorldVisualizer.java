package service.impl;

import model.impl.World2D;
import service.WorldVisualizer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SwingWorldVisualizer implements WorldVisualizer<Void> {

    private static final int CELL_SIZE = 32;
    private final JFrame frame;
    private final JPanel panel;
    private JLabel[][] grid;

    public SwingWorldVisualizer() {
        this.panel = new JPanel();
        this.frame = new JFrame();
    }

    @Override
    public Void visualize(World2D world) {
        initLabelPanel(world.getSize());
        for (int x = 0; x < world.getSize(); x++) {
            for (int y = 0; y < world.getSize(); y++) {
                final Color color = world.getCell(x, y).isAlive() ? Color.GREEN : Color.BLACK;
                grid[x][y].setBackground(color);
            }
        }
        frame.setVisible(true);
        return null;
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
        frame.setBounds(100, 100, calculatedSize, calculatedSize);
    }
}
