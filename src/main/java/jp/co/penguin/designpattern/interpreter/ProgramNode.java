package jp.co.penguin.designpattern.interpreter;

public class ProgramNode extends Node {
    private Node commandListNode;

    public Node getCommandListNode() {
        return commandListNode;
    }

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[program " + commandListNode + "]";
    }
}
