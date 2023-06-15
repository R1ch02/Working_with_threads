import Utils.Field;
import Utils.Input;
import Ants.AntWarrior;
import Ants.AntWorker;

public class Main {
    public static void main(String[] args) throws InterruptedException {
    Field field = new Field();

        int WorkersCount = Input.getUserInput("Enter amount of AntsWorkers:");
        int WarriorsCount = Input.getUserInput("Enter amount of AntsWarriors:");

        for (int i = 0; i < WorkersCount; i++) {
            AntWorker antWorker = new AntWorker(field);


            field.addWorker(antWorker);

            new Thread(antWorker).start();

        }


        for (int i = 0; i < WarriorsCount; i++) {
            AntWarrior antWarrior = new AntWarrior(field);


            field.addWorker(antWarrior);

            new Thread(antWarrior).start();


        }


        field.setVisible(true);

    }
}
