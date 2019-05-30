package jp.co.penguin.designpattern.decorator;

import org.springframework.boot.CommandLineRunner;

public class DecoratorRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
//        Display b1 = new StringDisplay("Hello, world.");
//        Display b2 = new SideBorder(b1, '#');
//        Display b3 = new FullBorder(b2);
//        b1.show();
//        b2.show();
//        b3.show();
//        Display b4 = new FullBorder(
//                new UpdownBorder(
//                        new SideBorder(
//                                new UpdownBorder(
//                                        new SideBorder(
//                                                new StringDisplay("こんにちは。"),
//                                                '*'
//                                        ),
//                                        '='
//                                ),
//                                '|'
//                        ),
//                        '/'
//                )
//        );
//        b4.show();

        MultiStringDisplay md = new MultiStringDisplay();
        md.add("おはようございます。");
        md.add("こんにちは。");
        md.add("お休みなさい。また明日。");
        md.show();

        Display d1 = new SideBorder(md, '#');
        d1.show();

        Display d2 = new FullBorder(md);
        d2.show();
    }
}
