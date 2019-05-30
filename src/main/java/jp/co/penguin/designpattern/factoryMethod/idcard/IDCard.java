package jp.co.penguin.designpattern.factoryMethod.idcard;

import jp.co.penguin.designpattern.factoryMethod.framework.Product;
import lombok.Getter;

@Getter
public class IDCard extends Product {

    private String owner;

    private Integer number;

    IDCard(String owner, Integer number) {
        System.out.println(owner + "(" + number + ")" + "のカードを作ります。");
        this.owner = owner;
        this.number = number;
    }

    @Override
    public void use() {
        System.out.println(owner + "(" + number + ")" + "のカードを使います。");
    }
}
