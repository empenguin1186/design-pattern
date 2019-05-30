package jp.co.penguin.designpattern.singleton;

import org.springframework.boot.CommandLineRunner;

public class SingletonRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Start.");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if (obj1 == obj2) {
            System.out.println("obj1とobj2は同じインスタンスです。");
        } else {
            System.out.println("obj1とobj2は同じインスタンスではありません。");
        }
        System.out.println("End.");
    }
}
