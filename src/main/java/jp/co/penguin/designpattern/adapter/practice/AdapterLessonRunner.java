package jp.co.penguin.designpattern.adapter.practice;

import org.springframework.boot.CommandLineRunner;

import java.io.IOException;

public class AdapterLessonRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        FileIO f = new FileProperties();
        try {
            f.readFromFile("src/main/java/jp/co/penguin/designpattern/adapter/practice/file.txt");
            f.setValue("year", "2004");
            f.setValue("month", "4");
            f.setValue("day", "21");
            f.writeToFile("src/main/java/jp/co/penguin/designpattern/adapter/practice/newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
