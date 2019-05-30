package jp.co.penguin.designpattern.command.drawer;

import jp.co.penguin.designpattern.command.command.Command;

import java.awt.*;

public class ColorCommand implements Command {

    private DrawCanvas canvas;
    private Color color;

    public ColorCommand(DrawCanvas canvas, Color color) {
        this.canvas = canvas;
        this.color = color;
    }

    @Override
    public void execute() {
        this.canvas.setColor(this.color);
    }
}
