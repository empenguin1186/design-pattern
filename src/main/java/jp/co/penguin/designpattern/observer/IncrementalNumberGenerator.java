package jp.co.penguin.designpattern.observer;

public class IncrementalNumberGenerator extends NumberGenerator {

    private int start;
    private int end;
    private int span;
    private int current;

    public IncrementalNumberGenerator(int start, int end, int span) {
        this.start = start;
        this.end = end;
        this.span = span;
        this.current = start;
    }

    @Override
    public int getNumber() {
        return current;
    }

    @Override
    public void execute() {
        for (int i = start; i < end; i = i + span) {
            this.current = i;
            notifyObservers();
        }
    }
}
