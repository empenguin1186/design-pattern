package jp.co.penguin.designpattern.abstractFactory.tablefactory;

import jp.co.penguin.designpattern.abstractFactory.factory.Factory;
import jp.co.penguin.designpattern.abstractFactory.factory.Link;
import jp.co.penguin.designpattern.abstractFactory.factory.Page;
import jp.co.penguin.designpattern.abstractFactory.factory.Tray;

public class TableFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
