// write a program when user clicked cross button in  window  that shows the conformation box 
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class DialogBox extends JFrame implements ActionListener {
    JPopupMenu popupMenu;
    JMenuItem copy, cut, paste, close , selectAll;
    JTextArea textArea;

    public DialogBox() {
        setTitle("Popup Menu Example");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

        textArea = new JTextArea("Right-click to see the popup menu.");
        add(textArea);

        popupMenu = new JPopupMenu();

        copy = new JMenuItem("Copy");
        cut = new JMenuItem("Cut");
        paste = new JMenuItem("Paste");
        close = new JMenuItem("Close");
        selectAll = new JMenuItem("Select All");

        popupMenu.add(selectAll);
        popupMenu.add(copy);
        popupMenu.add(cut);
        popupMenu.add(paste);
        popupMenu.addSeparator();
        popupMenu.add(close);
 

        copy.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);
        close.addActionListener(this);
        selectAll.addActionListener(this);

        textArea.setComponentPopupMenu(popupMenu);

        setVisible(true);
        setLayout(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == copy) {
            textArea.copy();
        } else if (e.getSource() == cut) {
            textArea.cut();
        } else if (e.getSource() == paste) {
            textArea.paste();
        } else if (e.getSource() == close) {
            JOptionPane.showMessageDialog(this, "Closing the application.");
            System.exit(0);
        }
        else if (e.getSource() == selectAll) {
            textArea.selectAll();
        }
        else if()
    }

    public static void main(String[] args) {
        new DialogBox();
    }
}