package jp.co.penguin.designpattern.flyweight;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.springframework.boot.CommandLineRunner;

public class FlyWeightRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        System.out.println("Shared Case:");
        printObjectSize(true);
        System.out.println("Non-Shared Case:");
        printObjectSize(false);

    }

    private void printObjectSize(boolean shared) {
        BigString[] bsarray = new BigString[1000];
        for (int i = 0; i < bsarray.length; i++) {
            bsarray[i] = new BigString("1212123", shared);
        }
        System.out.println(ObjectSizeCalculator.getObjectSize(bsarray));
    }

}
