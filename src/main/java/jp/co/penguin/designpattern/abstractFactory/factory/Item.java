package jp.co.penguin.designpattern.abstractFactory.factory;

public abstract class Item implements HTMLable {

    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }
}
