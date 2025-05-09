import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Buttons extends JFrame implements ActionListener {
    JTextField t1, t2, t3;
    JButton b1, b2;

    public Buttons() {
        setTitle("Simple Calculator");
        setSize(350, 250);
        setLayout(new FlowLayout());

        t1 = new JTextField("Enter First Number", 15);
        t2 = new JTextField("Enter Second Number", 15);
        t3 = new JTextField("Result", 15);
        t3.setEditable(false);

        b1 = new JButton("Add");
        b2 = new JButton("Subtract");

        b1.addActionListener(this);
        b2.addActionListener(this);

        add(t1);
        add(t2);
        add(t3);
        add(b1);
        add(b2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(t1.getText());
            double num2 = Double.parseDouble(t2.getText());
            double result = 0;

            if (e.getSource() == b1) {
                result = num1 + num2;
            } else if (e.getSource() == b2) {
                result = num1 - num2;
            }

            t3.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            t3.setText("Invalid Input");
        }
    }
}
