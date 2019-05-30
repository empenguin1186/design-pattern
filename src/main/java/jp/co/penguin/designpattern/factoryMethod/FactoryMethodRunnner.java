package jp.co.penguin.designpattern.factoryMethod;

import jp.co.penguin.designpattern.factoryMethod.framework.Factory;
import jp.co.penguin.designpattern.factoryMethod.framework.Product;
import jp.co.penguin.designpattern.factoryMethod.idcard.IDCardFactory;
import org.springframework.boot.CommandLineRunner;

import java.util.Map;

public class FactoryMethodRunnner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("結城浩");
        Product card2 = factory.create("とむら");
        Product card3 = factory.create("佐藤花子");
        card1.use();
        card2.use();
        card3.use();
        for (Map.Entry<String, Integer> stringIntegerEntry : ((IDCardFactory) factory).getOwnwersMap().entrySet()) {
            System.out.print(stringIntegerEntry.getKey());
            System.out.print(" | ");
            System.out.println(stringIntegerEntry.getValue());
        }
    }
}
