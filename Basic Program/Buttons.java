// create a gui application with a textfield  WHENA BUTTON IS CLICKED change the text in the textfield to uppercase

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Buttons  extends JFrame implements ActionListener {
    JTextField textField;
    JButton button;

    public Buttons() {
        setTitle("Button Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(20);
        button = new JButton("Click Me");

        button.addActionListener(this);

        add(textField);
        add(button);
    }

    public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        textField.setText(text.toUpperCase());
    }
}