package jp.co.penguin.designpattern.adapter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AdapterRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        TransferedPrint p = new TransferedPrintBanner("Hello");
        p.printWeak();
        p.printString();
    }
}
