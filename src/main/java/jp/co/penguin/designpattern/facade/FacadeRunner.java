package jp.co.penguin.designpattern.facade;

import jp.co.penguin.designpattern.facade.pagemaker.PageMaker;
import org.springframework.boot.CommandLineRunner;

public class FacadeRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
//        PageMaker.makeWelcomePage("hyuki@hyuki.com", "welcome.html");
        PageMaker.makeLinkPage("linkpage.html");
    }
}
