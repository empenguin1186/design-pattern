package jp.co.penguin.designpattern.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileFindVisitor extends Visitor {

    private List<File> foundFiles;

    private String prefix;

    public FileFindVisitor(String prefix) {
        this.prefix = prefix;
        this.foundFiles = new ArrayList<File>();
    }

    public Iterator getFoundFiles() {
        return foundFiles.iterator();
    }

    @Override
    public void visit(Directory directory) {
        Iterator it = directory.iterator();
        while(it.hasNext()) {
            Entry entry = (Entry) it.next();
            entry.accept(this);
        }
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(this.prefix)) {
            foundFiles.add(file);
        }
    }
}
