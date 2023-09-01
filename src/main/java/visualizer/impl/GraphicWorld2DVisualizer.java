package visualizer.impl;

import model.impl.World2D;
import visualizer.WorldVisualizer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GraphicWorld2DVisualizer implements WorldVisualizer {

    private static final int CELL_SIZE = 32;
    public static final long FINISH_DELAY_MILLIS = 10_000;
    public static final long START_DELAY_MILLIS = 5000L;
    private static final int THREADS = 50;
    private final JFrame frame;
    private final JPanel panel;
    private final long delay;
    private JLabel[][] grid;

    private final ExecutorService executor;

    public GraphicWorld2DVisualizer(final long delay) {
        this.panel = new JPanel();
        this.frame = new JFrame();
        this.delay = delay;
        executor = Executors.newFixedThreadPool(THREADS);
    }

    @Override
    public void visualize(final World2D world) {
        try {
            initLabelPanel(world.getSize());
            Thread.sleep(delay);
            for (int x = 0; x < world.getSize(); x++) {
                executor.execute(new PartialGraphicWorldUpdater(world, grid, x));
            }
            frame.setTitle("Generation " + world.getGeneration());
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
            executor.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void initLabelPanel(final int size) throws InterruptedException {
        if (grid == null) {
            panel.setLayout(new GridLayout(size, size));
            grid = new JLabel[size][size];
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    createLabel(x, y);
                }
            }
            configureWindowSize(size);
            frame.setVisible(true);
            Thread.sleep(START_DELAY_MILLIS);
        }
    }

    private void createLabel(int x, int y) {
        grid[x][y] = new JLabel();
        grid[x][y].setBorder(new LineBorder(Color.WHITE));
        grid[x][y].setOpaque(true);
        grid[x][y].setBackground(Color.GRAY);
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
