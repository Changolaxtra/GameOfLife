package model;

public interface PrimitiveCell {
    boolean isAlive();
    boolean isDead();
    void kill();
    void makeAlive();
}
