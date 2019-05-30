package jp.co.penguin.designpattern.command;

import jp.co.penguin.designpattern.command.command.Command;
import jp.co.penguin.designpattern.command.command.MacroCommand;
import jp.co.penguin.designpattern.command.drawer.ColorCommand;
import jp.co.penguin.designpattern.command.drawer.DrawCanvas;
import jp.co.penguin.designpattern.command.drawer.DrawCommand;
import org.springframework.boot.CommandLineRunner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CommandRunner extends JFrame implements CommandLineRunner, ActionListener {

    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private JButton clearButton = new JButton("clear");
    private JButton colorButton = new JButton("change color");
    private JButton undoButton = new JButton("undo");
    private Color color = Color.red;

    public CommandRunner(String title) {
        super(title);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Command cmd = new DrawCommand(canvas, e.getPoint(), color);
                history.append(cmd);
                cmd.execute();
            }
        });

        // Listner 追加
        clearButton.addActionListener(this);
        colorButton.addActionListener(this);
        undoButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(colorButton);
        buttonBox.add(undoButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }

    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if (event == clearButton) {
            history.clear();
            canvas.repaint();
        } else if (event == colorButton) {
            color = Color.black;
            Command cmd = new ColorCommand(canvas, color);
            history.append(cmd);
            cmd.execute();
        } else if (event == undoButton) {
            history.undo();
            canvas.repaint();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        new CommandRunner("Command Pattern Sample.");
    }
}
