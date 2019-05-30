package jp.co.penguin.designpattern.abstractFactory;

import jp.co.penguin.designpattern.abstractFactory.factory.Factory;
import jp.co.penguin.designpattern.abstractFactory.factory.Link;
import jp.co.penguin.designpattern.abstractFactory.factory.Page;
import jp.co.penguin.designpattern.abstractFactory.factory.Tray;
import org.springframework.boot.CommandLineRunner;

public class AbstractFactoryRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java Main class.name.of.ConcreteFactory");
            System.out.println("Example: java Main listfactory.ListFactory");
        }

        Factory factory = Factory.getFactory(args[0]);

        Link asahi = factory.createLink("朝日新聞", "http://asahi.com/");
        Link yomiuri = factory.createLink("読売新聞", "http://www.yomiuri.co.jp/");

        Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
        Link jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
        Link excite = factory.createLink("Excite", "http://www.excite.com/");
        Link google = factory.createLink("Google", "http://www.google.com/");

        Tray traynews = factory.createTray("新聞");
        traynews.add(asahi);
        traynews.add(yomiuri);

        Tray trayyahoo = factory.createTray("Yahoo!");
        trayyahoo.add(us_yahoo);
        trayyahoo.add(jp_yahoo);

        Tray traysearch = factory.createTray("サーチエンジン");
        traysearch.add(trayyahoo);
        traysearch.add(excite);
        traysearch.add(google);

        Page page = factory.createPage("LinkPage", "結城 浩");
        page.add(traynews);
        page.add(traysearch);
        page.output();
    }
}
