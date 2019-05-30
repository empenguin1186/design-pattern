package jp.co.penguin.designpattern.singleton.practice;

import org.springframework.boot.CommandLineRunner;

public class TripleRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Start.");
        for (int i = 0; i < 9; i++) {
            Triple triple = Triple.getInstance(i % 3);
            System.out.println(i + ":" + triple);
        }
        System.out.println("End.");
    }
}
