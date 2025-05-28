// Create an application with two labels:
// The first one should display whether the mouse is inside the label or not.
// The second one should display the x and y coordinates of the mouse when it is inside the label.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Mouse implements MouseListener, MouseMotionListener {
    JLabel label1, label2;
    JFrame frame;

    public Mouse() {
        frame = new JFrame("Mouse Event");
        label1 = new JLabel();
        label2 = new JLabel();

        label1.setBounds(50, 50, 250, 30);
        label2.setBounds(50, 100, 250, 30);

        frame.add(label1);
        frame.add(label2);

        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
    }

    @Override  
    public void mouseEntered(MouseEvent e) {
        label1.setText("Mouse is inside the label");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label1.setText("Mouse is outside the label");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        label2.setText("X: " + x + ", Y: " + y);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Not used
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Not used
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Not used
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Not used
    }

    public static void main(String[] args) {
        new Mouse();
    }
}
