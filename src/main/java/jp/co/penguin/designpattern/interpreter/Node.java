package jp.co.penguin.designpattern.interpreter;

public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}
