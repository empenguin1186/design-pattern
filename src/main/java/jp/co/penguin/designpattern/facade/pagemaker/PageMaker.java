package jp.co.penguin.designpattern.facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PageMaker {

    private PageMaker() {
    }

    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Welcome to " + username + "'s page!");
            writer.paragraph(username + "のページへようこそ。 ");
            writer.paragraph("メール待っていますね");
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(String filename) {

        try {
            Properties mailprop = Database.getProperties("maildata");
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
//            mailprop.entrySet().stream().forEach(e -> {
//                try {
//                    writer.link((String) e.getKey(), (String) e.getValue());
//                } catch (IOException el) {
//                    el.printStackTrace();
//                }
//            });
            writer.title("Link page");
            Iterator it = mailprop.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                writer.mailto((String) entry.getKey(), (String) entry.getValue());
            }
            writer.close();
            System.out.println(filename + " is created.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
