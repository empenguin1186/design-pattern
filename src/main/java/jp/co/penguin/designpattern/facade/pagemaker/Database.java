package jp.co.penguin.designpattern.facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class Database {

    private Database() {
    }

    public static Properties getProperties(String dbname) {
        Properties prop = new Properties();
        String filename = "src/main/java/jp/co/penguin/designpattern/facade/" + dbname + ".txt";
        try (FileInputStream stream = new FileInputStream(filename)) {
            prop.load(stream);
        } catch (IOException e) {
            System.out.println("Warning: " + filename + " is not found.");
        }
        return prop;
    }

}
