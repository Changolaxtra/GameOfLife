package visualizer;

import model.impl.World2D;

public interface WorldVisualizer {
    void visualize(World2D world);
    void finish();
}
