package jp.co.penguin.designpattern.visitor;

import java.util.Iterator;

public class SizeVisitor extends Visitor {

    private int size;

    public SizeVisitor() {
        this.size = 0;
    }

    @Override
    public void visit(Directory directory) {
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            entry.accept(this);
        }
    }

    @Override
    public void visit(File file) {
        this.size += file.getSize();
    }

    public int getSize() {
        return size;
    }
}
