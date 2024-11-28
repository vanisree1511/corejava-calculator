package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel {
	///here we need to have buttons here
    JButton[] numberButtons;  // Use JButton instead of Button
    JButton add, subtract, multiply, divide, equals, clear;
    ActionHandler actionHandler;

    public ButtonPanel(ActionHandler actionHandler) {
        this.actionHandler = actionHandler;
        setLayout(new GridLayout(4, 4, 5, 5)); // 4x4 grid for buttons
//4=rows,4columns,5 horizontal gap 5=vertical gap
        // Create the number buttons (0-9)
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 12)); // Smaller font for buttons
            numberButtons[i].setPreferredSize(new Dimension(40, 40)); // Smaller button size
            numberButtons[i].addActionListener(actionHandler); // Add action listener to each button
            add(numberButtons[i]);
        }

        // Create operation buttons (+, -, *, /, =, C)
        add = new JButton("+");
        subtract = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        equals = new JButton("=");
        clear = new JButton("C");

        // Set font and size for operation buttons
        JButton[] operations = {add, subtract, multiply, divide, equals, clear};
        for (JButton btn : operations) {
            btn.setFont(new Font("Arial", Font.PLAIN, 12));
            btn.setPreferredSize(new Dimension(40, 40)); // Smaller button size
            btn.addActionListener(actionHandler); // Add action listener to each button
            add(btn);
        }
    }
}
