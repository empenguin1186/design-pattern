package jp.co.penguin.designpattern.memento;

import jp.co.penguin.designpattern.memento.game.Gamer;
import jp.co.penguin.designpattern.memento.game.Memento;
import org.springframework.boot.CommandLineRunner;

public class MementoRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);
            System.out.println("status: " + gamer);

            gamer.bet();

            System.out.println("Money held is " + gamer.getMoney());

            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("This status should be saved.");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("Should restore last state.");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            System.out.println("");
        }
    }
}
