package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    JTextField display; // Change to JTextField for Swing
    ButtonPanel buttonPanel;
    ActionHandler actionHandler;

    public Calculator() {
        // Set up the layout and basic properties of the frame
        setLayout(new BorderLayout());

        // Initialize the display (use JTextField instead of TextField)
        display = new JTextField();
        display.setEditable(false); // Prevent editing of the display field console
        display.setFont(new Font("Arial", Font.BOLD, 30)); // Increase font size for the display console
        add(display, BorderLayout.NORTH);//to display the console top

        // Initialize ActionHandler and ButtonPanel
        actionHandler = new ActionHandler(display);
        buttonPanel = new ButtonPanel(actionHandler);

        // Add the ButtonPanel to the center of the frame
        add(buttonPanel, BorderLayout.CENTER);

        // Frame properties (JFrame-specific)
        setTitle("Calculator");
        setSize(300, 400); // Window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the window and exit the application when closed
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
