package jp.co.penguin.designpattern.interpreter;

import java.awt.*;

public class CommandExecutor {

    // Direction definition
    private static final String RIGHT = "right";
    private static final String LEFT = "left";

    private Point point;
    private int angle;

    public CommandExecutor() {
        this.point = new Point(0, 0);
        this.angle = 0;
    }

    public Point getPoint() {
        return point;
    }

    public void execute(Node node) {

        if (node instanceof ProgramNode) {
            this.execute(((ProgramNode) node).getCommandListNode());
        }
        if (node instanceof CommandListNode) {
            for (Node n : ((CommandListNode) node).getList()) {
                this.execute(n);
            }
        }
        if (node instanceof CommandNode) {
            this.execute(((CommandNode) node).getNode());
        }
        if (node instanceof RepeatCommandNode) {
            for (int i = 0; i < ((RepeatCommandNode) node).getNumber(); i++) {
                this.execute(((RepeatCommandNode) node).getCommandListNode());
            }
        }
        if (node instanceof PrimitiveCommandNode) {
            movePoint(((PrimitiveCommandNode) node).getName());
        }
    }

    private void movePoint(String command) {

        switch (command) {
            case RIGHT:
                this.angle += 90;
                break;
            case LEFT:
                this.angle -= 90;
                break;
            default:
                go();
        }
    }

    private void go() {

        switch (this.angle % 360) {
            case 0:
                this.point.y += 1;
                break;
            case 90:
                this.point.x += 1;
                break;
            case 180:
                this.point.y -= 1;
                break;
            case 270:
                this.point.x -= 1;
                break;
            default:
                throw new RuntimeException();
        }
    }

}
