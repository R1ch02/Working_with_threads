package Ants;

import Utils.Field;
import Utils.Point;

import java.time.Duration;
import java.time.Instant;

public class AntWorker extends Ant {
    double delta[];
    public AntWorker(Field field) {
        super(field, 10);
        this.destination = parent.getRandomCorner();
        delta = normalize( destination.x()-startPoint.x(),destination.y()-startPoint.y());
        this.arrivalTime = Math.hypot(destination.x() - startPoint.x(), destination.y() - startPoint.y()) / velocity;
    }

    @Override
    void compute() {
        Duration duration = Duration.between(startTime, Instant.now());
        int x = (int)computeCoordinate(startPoint.x(),delta[0],velocity,duration.getSeconds()+duration.getNano()/1000000000.0);
        int y = (int)computeCoordinate(startPoint.y(),delta[1],velocity,duration.getSeconds()+duration.getNano()/1000000000.0);
        currentPoint = new Point(x,y);
    parent.repaint();
    if (duration.getSeconds()+duration.getNano()/1000000000.0 >= arrivalTime){
        Point save = destination;
        destination = startPoint;
        startPoint = save;
        delta = normalize( destination.x()-startPoint.x(),destination.y()-startPoint.y());
        startTime = Instant.now();
    }
    }

   // @Override
    double computeCoordinate(int startCoordinate, double delta, int velocity, double time) {
        return startCoordinate + delta * velocity * time;
    }
}
