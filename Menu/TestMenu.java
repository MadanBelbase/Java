// write a program to create a menu using Java for copy cut paste and undo redo

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TestMenu extends JFrame implements ActionListener {
    JMenu menu;
    JMenuItem copy, cut, paste, close;
    JTextArea textArea;
    JMenuBar Mb;

    public TestMenu() {
        setTitle("Menu Example");
        setSize(500, 400);

        Mb = new JMenuBar();
        menu = new JMenu("Menu");
        Mb.add(menu);

        copy = new JMenuItem("Copy");
        cut = new JMenuItem("Cut");
        paste = new JMenuItem("Paste");
        close = new JMenuItem("Close");

        menu.add(copy);
        menu.add(cut);
        menu.add(paste);
        menu.addSeparator(); // fixed typo here
        menu.add(close);

        copy.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);
        close.addActionListener(this);

        textArea = new JTextArea("Type here...");
        textArea.setBounds(400,300,100,200);

        add(textArea);
        setJMenuBar(Mb);
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == copy) {
            textArea.copy();
        } else if (e.getSource() == cut) {
            textArea.cut();
        } else if (e.getSource() == paste) {
            textArea.paste();
        } else if (e.getSource() == close) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new TestMenu();
    }
}
