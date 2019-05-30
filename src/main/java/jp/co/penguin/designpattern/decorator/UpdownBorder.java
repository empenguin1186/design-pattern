package jp.co.penguin.designpattern.decorator;

public class UpdownBorder extends FullBorder {

    private char borderChar;

    public UpdownBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    @Override
    public int getColumns() {
        return display.getColumns();
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0 || row == getRows() - 1) {
            return makeLine(this.borderChar, display.getColumns());
        } else {
            return display.getRowText(row - 1);
        }
    }
}
