package jp.co.penguin.designpattern.command.drawer;

import jp.co.penguin.designpattern.command.command.MacroCommand;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {

    private Color color = Color.red;
    private int radius = 6;
    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    public void paint(Graphics g) {
        history.execute();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y, Color color) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
