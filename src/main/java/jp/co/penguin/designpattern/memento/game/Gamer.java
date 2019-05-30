package jp.co.penguin.designpattern.memento.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;
    private List<String> fruits = new ArrayList<>();
    private Random random = new Random();
    private static String[] fruitsname = {
            "apple", "grape", "banana", "orange"
    };

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        switch (dice) {
            case 1:
                this.money += 100;
                System.out.println("Money held increased.");
            case 2:
                this.money /= 2;
                System.out.println("Money held has been halved.");
            case 6:
                String fruit = getFruit();
                this.fruits.add(fruit);
                System.out.println("got the fruit (" + fruit + ").");
            default:
                System.out.println("Nothing occured");
        }
    }
    
    public Memento createMemento() {
        Memento m = new Memento(this.money);
        this.fruits.stream().forEach(e -> {
            if (e.startsWith("おいしい")) {
                m.addFruit(e);
            }
        });
        return m;
    }

    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "[money = " + this.money + ", fruits" + fruits + "]";
    }

    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "おいしい";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }
}
