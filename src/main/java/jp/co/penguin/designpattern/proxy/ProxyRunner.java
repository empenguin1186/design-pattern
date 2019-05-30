package jp.co.penguin.designpattern.proxy;

import org.springframework.boot.CommandLineRunner;

public class ProxyRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Printable p = new PrinterProxy("Alice");
        System.out.println("Current name is " + p.getName() + ".");
        p.setName("Bob");
        System.out.println("Current name is " + p.getName() + ".");
        p.print("Hello, World.");
    }
}
