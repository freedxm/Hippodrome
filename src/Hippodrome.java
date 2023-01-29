//axion

import java.util.ArrayList;
import java.util.List;

/**
 * Запускай программу с наблюдай гонку лошадей!
 **/

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > winner.getDistance()) {
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Arya", 3, 0));
        horses.add(new Horse("Saphire", 3, 0));
        horses.add(new Horse("Brom", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }


}
