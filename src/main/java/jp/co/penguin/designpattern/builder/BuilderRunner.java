package jp.co.penguin.designpattern.builder;

import org.springframework.boot.CommandLineRunner;

import javax.swing.*;

public class BuilderRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        if (args.length != 1) {
            System.exit(0);
        }

        if (args[0].equals("plain")) {
            TextBuilder textBuilder = new TextBuilder();
            Director director = new Director(textBuilder);
            director.construct();
            String result = textBuilder.getResult();
            System.out.println(result);
        } else if (args[0].equals("html")) {
            HTMLBuilder htmlBuilder = new HTMLBuilder();
            Director director = new Director(htmlBuilder);
            director.construct();
            String result = htmlBuilder.getResult();
            System.out.println(result);
        } else if (args[0].equals("gui")) {
            FrameBuilder frameBuilder = new FrameBuilder();
            Director director = new Director(frameBuilder);
            director.construct();
            JFrame frame = frameBuilder.getResult();
            frame.setVisible(true);
        } else {
            usage();
            System.exit(0);
        }
    }

    public void usage() {
        System.out.println("Usage: java Main plain");
        System.out.println("Usage: java Main html");
    }
}
