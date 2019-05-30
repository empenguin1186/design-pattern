package jp.co.penguin.designpattern.chainOfResp;

import org.springframework.boot.CommandLineRunner;

public class ChainOfRespRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 300);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);

        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

        for (int i = 0; i < 500; i++) {
            alice.support(new Trouble(i));
        }
    }
}
