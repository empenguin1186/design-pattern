package jp.co.penguin.designpattern.interpreter;

import org.springframework.boot.CommandLineRunner;

import java.io.BufferedReader;
import java.io.FileReader;

public class InterpreterRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/jp/co/penguin/designpattern/interpreter/program.txt"))) {
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                CommandExecutor executor = new CommandExecutor();
                executor.execute(node);
                System.out.println("position = " + executor.getPoint());
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
