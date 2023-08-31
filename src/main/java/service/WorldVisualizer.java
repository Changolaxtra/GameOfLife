package service;

import model.impl.World2D;

public interface WorldVisualizer<T> {
    T visualize(World2D world);
}
