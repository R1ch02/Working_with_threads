package Ants;

import Utils.Field;
import Utils.Point;

import java.time.Instant;

public abstract class Ant implements Runnable {
    boolean going = true;
    final Field parent;
    Instant startTime;
    double arrivalTime;
    final int velocity;
    Point startPoint, destination, currentPoint;

    Ant(Field field, int velocity) {
        this.parent = field;
        this.startPoint = parent.getRandomPoint();
        this.currentPoint = startPoint;
        this.velocity = velocity;
        this.startTime = Instant.now();
    }

     abstract void compute();

    static double[] normalize(int x, int y) {
        double dx = x / Math.hypot(x, y);
        double dy = y / Math.hypot(x, y);
        return new double[]{dx, dy};
    }


    // abstract double computeCoordinate(int startCoordinate, double delta, int velocity, double time);



    @Override
    public void run() {
        while (going) this.compute();
    }


    public Point getCurrentPoint() { return currentPoint; }
}
