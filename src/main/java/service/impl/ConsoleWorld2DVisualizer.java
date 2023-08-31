package service.impl;

import model.impl.World2D;
import service.WorldVisualizer;

public class StringWorld2DVisualizer implements WorldVisualizer {

    @Override
    public void visualize(World2D world) {
        final StringBuilder builder = new StringBuilder();
        for (int x = 0; x < world.getSize(); x++) {
            for (int y = 0; y < world.getSize(); y++) {
                final char icon = world.getCell(x, y).isAlive() ? 'A' : 'D';
                builder.append('[').append(icon).append(']');
            }
            builder.append('\n');
        }
        System.out.println(builder);
    }
}
