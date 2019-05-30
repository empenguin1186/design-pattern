package jp.co.penguin.designpattern.adapter;

public class TransferedPrintBanner extends TransferedPrint {

    private Banner banner;

    public TransferedPrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printString() {
        banner.showWithAster();
    }
}
