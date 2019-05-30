package jp.co.penguin.designpattern.bridge;

public class IncreaseDisplayImpl implements DisplayImpl {

    private String start;
    private String content;
    private String end;

    public IncreaseDisplayImpl(String start, String content, String end) {
        this.start = start;
        this.content = content;
        this.end = end;
    }

    @Override
    public void rawOpen() {
        System.out.print(start);
    }

    @Override
    public void rawPrint() {
        System.out.print(content);
    }

    @Override
    public void rawClose() {
        System.out.println(end);
    }
}
