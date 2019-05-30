package jp.co.penguin.designpattern.proxy;

public class Printer implements Printable {
    private String name;

    public Printer() {
        heavyJob("Creating Printer instance");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob("Creating Printer instance [" + name + "]");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void print(String string) {
        System.out.println("=== " + name + " ===");
        System.out.println(string);
    }

    private void heavyJob(String msg) {
        System.out.println(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("Completed.");
    }
}
