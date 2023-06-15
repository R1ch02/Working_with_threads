package Ants;

import Utils.Field;
import Utils.Point;

import java.time.Duration;
import java.time.Instant;

public class AntWarrior extends Ant {
    final double R = 30;

    public AntWarrior(Field field) {
        super(field, 1);

        this.destination = parent.getRandomPoint();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Override
    void compute(){

        Duration duration = Duration.between(startTime, Instant.now());
        int x = (int)computeCoordinateX(startPoint.x(),R,velocity,duration.getSeconds()+duration.getNano()/1000000000.0);
        int y = (int)computeCoordinateY(startPoint.y(),R,velocity,duration.getSeconds()+duration.getNano()/1000000000.0);
        currentPoint = new Point(x,y);


        parent.repaint();
    }

    /*@Override
    double computeCoordinate(int startCoordinate, double R, int velocity, double time) {
        return startCoordinate + R*(Math.cos(velocity*time));
    }
*/
    double computeCoordinateX(int startCoordinate, double R, int velocity, double time){
        return startCoordinate + R*(Math.cos(velocity*time));
    }

    double computeCoordinateY(int startCoordinate, double R, int velocity, double time){
        return startCoordinate + R*(Math.sin(velocity*time));
    }
}
