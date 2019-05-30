package jp.co.penguin.designpattern.prototype;

import jp.co.penguin.designpattern.prototype.framework.Manager;
import jp.co.penguin.designpattern.prototype.framework.Product;
import org.springframework.boot.CommandLineRunner;

public class PrototypeRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        // Preparation
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        // Creation
        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");

        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");

        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");
    }
}
