package jp.co.penguin.designpattern.observer;

import org.springframework.boot.CommandLineRunner;

public class ObserverRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        NumberGenerator generator = new IncrementalNumberGenerator(10, 50, 5);
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        Observer observer3 = new SquareObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.addObserver(observer3);
        generator.execute();
    }
}
