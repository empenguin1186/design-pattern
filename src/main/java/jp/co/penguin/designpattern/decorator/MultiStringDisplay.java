package jp.co.penguin.designpattern.decorator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MultiStringDisplay extends Display {

    private List<String> stringList = new ArrayList<String>();

    @Override
    public int getColumns() {
        String str = stringList.stream().max(Comparator.comparingInt(String::length)).toString();
        return str.getBytes().length;
    }

    public void add(String str) {
        stringList.add(str);
    }

    @Override
    public int getRows() {
        return stringList.size();
    }

    @Override
    public String getRowText(int row) {
        return row < stringList.size() ? stringList.get(row) : null;
    }
}
