package jp.co.penguin.designpattern.singleton.practice;

public class TicketMaker {

    private static TicketMaker ticketMaker = new TicketMaker();

    private TicketMaker() {
        System.out.println("Created Singleton Instance.");
    }

    public static TicketMaker getInstance() {
        return ticketMaker;
    }

    private int ticket = 1000;

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }
}
