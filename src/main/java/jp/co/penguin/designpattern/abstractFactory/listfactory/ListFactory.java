package jp.co.penguin.designpattern.abstractFactory.listfactory;

import jp.co.penguin.designpattern.abstractFactory.factory.Factory;
import jp.co.penguin.designpattern.abstractFactory.factory.Link;
import jp.co.penguin.designpattern.abstractFactory.factory.Page;
import jp.co.penguin.designpattern.abstractFactory.factory.Tray;

public class ListFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
