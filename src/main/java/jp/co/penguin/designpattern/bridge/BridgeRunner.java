package jp.co.penguin.designpattern.bridge;

import org.springframework.boot.CommandLineRunner;

public class BridgeRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Display d1 = new Display(new StringDisplayImpl("Hello, Japan."));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World."));
        RandomDisplay d3 = new RandomDisplay(new StringDisplayImpl("Hello, Universe."));
        d1.display();
        d2.display();
        d3.display();
        d3.randomDisplay(5);
    }
}
