package jp.co.penguin.designpattern.proxy;

public interface Printable {
    public abstract void setName(String name);
    public abstract String getName();
    public abstract void print(String string);
}
