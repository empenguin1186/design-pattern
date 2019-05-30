package jp.co.penguin.designpattern.visitor;

public abstract class Visitor {
    public abstract void visit(Directory directory);
    public abstract void visit(File file);
}
