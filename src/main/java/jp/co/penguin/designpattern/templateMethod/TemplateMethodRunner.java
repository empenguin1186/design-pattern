package jp.co.penguin.designpattern.templateMethod;

import org.springframework.boot.CommandLineRunner;

public class TemplateMethodRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello, world.");
        AbstractDisplay d3 = new StringDisplay("こんにちは。");
        d1.display();
        d2.display();
        d3.display();
    }
}
