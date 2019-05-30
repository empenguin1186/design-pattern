package jp.co.penguin.designpattern.factoryMethod.idcard;

import jp.co.penguin.designpattern.factoryMethod.framework.Factory;
import jp.co.penguin.designpattern.factoryMethod.framework.Product;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class IDCardFactory extends Factory {

    private Integer number = 0;
    private Map<String, Integer> ownwersMap = new HashMap<>();

    @Override
    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, number++);
    }

    @Override
    protected void registerProduct(Product product) {
        ownwersMap.put(((IDCard) product).getOwner(), ((IDCard) product).getNumber());
    }
}
