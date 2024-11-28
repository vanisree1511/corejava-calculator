package calculator;

import javax.swing.*;
import java.awt.event.*;

public class ActionHandler implements ActionListener {
	JTextField display; // Use JTextField instead of TextField
	double num1, num2, result;
	char operator;
	boolean operatorPressed;

	public ActionHandler(JTextField display) {
		this.display = display;
		this.operatorPressed = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
			// If the user presses a number, append it to the display
			if (operatorPressed) {
				display.setText(command); // Clear display for the second number
				operatorPressed = false;
			} else {
				display.setText(display.getText() + command); // Append to the current number
			}
		} else if (command.charAt(0) == 'C') {
			// Clear the display when 'C' is pressed
			display.setText("");
			num1 = num2 = result = 0;
			operatorPressed = false;
		} else if (command.charAt(0) == '=') {
			// Perform the calculation when '=' is pressed
			num2 = Double.parseDouble(display.getText());
			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				if (num2 != 0) {
					result = num1 / num2;
				} else {
					display.setText("Error");
					return;
				}
				break;
			}
			display.setText(String.valueOf(result));
			operatorPressed = false;
		} else {
			// If the user presses an operator, store the first number and operator
			if (!display.getText().isEmpty()) {
				num1 = Double.parseDouble(display.getText());
				operator = command.charAt(0);
				operatorPressed = true;
			}
		}
	}
}
