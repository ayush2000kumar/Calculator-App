
import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;


public class CalculatorApp {

	    private JFrame frame;
	    private JTextField textField;
	    private double num1, num2, result;
	    private String operator;

	    public CalculatorApp() {
	        frame = new JFrame("Calculator");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(250, 350);
	        frame.setLayout(new BorderLayout());

	        textField = new JTextField();
	        textField.setEditable(false);
	        frame.add(textField, BorderLayout.NORTH);

	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new GridLayout(4, 4));

	        String[] buttonLabels = {
	                "7", "8", "9", "/",
	                "4", "5", "6", "*",
	                "1", "2", "3", "-",
	                "0", ".", "=", "+"
	        };

	        for (String label : buttonLabels) {
	            JButton button = new JButton(label);
	            button.addActionListener(new ButtonClickListener());
	            buttonPanel.add(button);
	        }

	        frame.add(buttonPanel, BorderLayout.CENTER);
	        frame.setVisible(true);
	    }

	    private class ButtonClickListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            String command = e.getActionCommand();

	            if (command.matches("[0-9]|\\.")) {
	                textField.setText(textField.getText() + command);
	            } else if (command.equals("/") || command.equals("*") || command.equals("-") || command.equals("+")) {
	                num1 = Double.parseDouble(textField.getText());
	                operator = command;
	                textField.setText("");
	            } else if (command.equals("=")) {
	                num2 = Double.parseDouble(textField.getText());

	                switch (operator) {
	                    case "/":
	                        result = num1 / num2;
	                        break;
	                    case "*":
	                        result = num1 * num2;
	                        break;
	                    case "-":
	                        result = num1 - num2;
	                        break;
	                    case "+":
	                        result = num1 + num2;
	                        break;
	                }

	                textField.setText(String.valueOf(result));
	            }
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new CalculatorApp();
	            }
	        });
	    }
	}


