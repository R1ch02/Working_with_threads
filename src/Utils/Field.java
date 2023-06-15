package Utils;

import Ants.AntWorker;
import Ants.AntWarrior;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Field extends JFrame {
    private final ArrayList<AntWorker> antWorkers = new ArrayList<>();
    private final ArrayList<AntWarrior> antWarriors = new ArrayList<>();

    final Point corner1;
    final Point corner2;
    final Point corner3;
    final Point corner4;

    public Field() {

        this.setTitle("Лабораторная работа № 3");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 500);
         corner1 = new Point(0,0);
         corner2 = new Point(0,this.getHeight());
         corner3 = new Point(this.getWidth(),this.getHeight());
         corner4 = new Point(this.getWidth(),0);
    }



    public Point getRandomCorner(){

        double r = Math.random();

        if ( r < 0.25) {return corner1;}
        if ( r >= 0.25 && r < 0.5) {return corner2;}
        if ( r >= 0.5 && r < 0.75) {return corner3;}
        if ( r >= 0.75) {return corner4;}

        return corner1;

    }

    public Point getRandomPoint() {


                return new Point(
                        (int) (Math.random() * (this.getWidth() - 20)) + 10,
                        (int) (Math.random() * (this.getHeight() - 50)) + 40
                );
    }

    @Override
    public void paint(Graphics g) {
        int width = this.getWidth(), height = this.getHeight();

        g.setColor(Color.yellow);
        g.fillRect(0, 0, width, height);


        for (AntWorker antWorker : antWorkers) {
            g.setColor(Color.black);
            g.drawString("O", antWorker.getCurrentPoint().x() - 2, antWorker.getCurrentPoint().y() - 4);


        }

        for (AntWarrior antWarrior : antWarriors) {
            g.setColor(Color.black);
            g.drawString("@", antWarrior.getCurrentPoint().x() - 2, antWarrior.getCurrentPoint().y() - 4);


        }
    }

      public void addWorker(AntWorker antWorker){
        antWorkers.add(antWorker);

        }

        public void addWorker(AntWarrior antWarrior){
            antWarriors.add(antWarrior);
        }


}
