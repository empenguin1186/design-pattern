package jp.co.penguin.designpattern.visitor;

public interface Element {
    public abstract void accept(Visitor v);
}
