package jp.co.penguin.designpattern.observer;

public class SquareObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        int number = generator.getNumber() + 2;
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (i == 0 || i == number - 1) {
                    if (j == 0 || j == number - 1) {
                        System.out.print(" ");
                    } else {
                        System.out.print("--");
                    }
                } else {
                    if (j == 0 || j == number -1) {
                        System.out.print("|");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println("");
        }
    }
}
