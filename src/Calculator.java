import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    // Declare variables for the components
    private JRadioButton binaryRadioButton, decimalRadioButton, hexRadioButton;
    private ButtonGroup radioButtonGroup;
    private JTextField inputField, outputField;
    private JButton[] buttons;
    private String[] buttonLabels = {"And", "Or", "Xor", "Not", "Shift Left",
            "Shift Right", "A", "B", "C", "D", "E", "F", "0",
            "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public Calculator() {
        // Set the layout to GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Create the radio buttons and add them to a button group
        binaryRadioButton = new JRadioButton("Binary");
        decimalRadioButton = new JRadioButton("Decimal");
        hexRadioButton = new JRadioButton("Hexadecimal");
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(binaryRadioButton);
        radioButtonGroup.add(decimalRadioButton);
        radioButtonGroup.add(hexRadioButton);

        // Add action listeners to the radio buttons
        binaryRadioButton.addActionListener(this);
        decimalRadioButton.addActionListener(this);
        hexRadioButton.addActionListener(this);

        // Set the default input radix to decimal
        decimalRadioButton.setSelected(true);

        // Add the radio buttons to the frame
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.anchor = GridBagConstraints.WEST;
        add(binaryRadioButton, constraints);
        constraints.gridy = 1;
        add(decimalRadioButton, constraints);
        constraints.gridy = 2;
        add(hexRadioButton, constraints);

        // Create the input and output fields
        inputField = new JTextField(10);
        outputField = new JTextField(10);
        outputField.setEditable(false);

        // Add the input and output fields to the frame
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        add(inputField, constraints);
        constraints.gridy = 1;
        add(outputField, constraints);

        // Create the buttons
        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
        }

        // Add the buttons to the frame
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        // Add the first row of buttons
        for (int i = 6; i < 10; i++) {
            add(buttons[i], constraints);
            constraints.gridx++;
        }

        // Add the second row of buttons
        constraints.gridx = 0;
        constraints.gridy = 4;
        for (int i = 10; i < 14; i++) {
            add(buttons[i], constraints);
            constraints.gridx++;
        }

        // Add the third row of buttons
        constraints.gridx = 0;
        constraints.gridy = 5;
        for (int i = 14; i < 18; i++) {
            add(buttons[i], constraints);
            constraints.gridx++;
        }

        // Add the fourth row of buttons
        constraints.gridx = 0;
        constraints.gridy = 6;
        for (int i = 18; i < 22; i++) {
            add(buttons[i], constraints);
            constraints.gridx++;
        }

        // Add the logical operation buttons
        constraints.gridx = 3;
        constraints.gridy = 3;
        add(buttons[0], constraints);
        constraints.gridx++;
        add(buttons[1], constraints);
        constraints.gridx++;
        add(buttons[2], constraints);
        constraints.gridx++;
        add(buttons[3], constraints);
        constraints.gridx = 3;
        constraints.gridy = 4;
        add(buttons[4], constraints);
        constraints.gridx++;
        add(buttons[5], constraints);

        // Set the size and title of the frame, and set the default close operation
        setSize(300, 300);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {
        // Get the source of the event
        Object source = event.getSource();

        // If a radio button was selected, enable or disable the appropriate buttons
        if (source == binaryRadioButton) {
            enableButtons(false, false, true);
        } else if (source == decimalRadioButton) {
            enableButtons(true, true, true);
        } else if (source == hexRadioButton) {
            enableButtons(false, true, true);
        } else {
            // A button was clicked, so perform the appropriate operation
            String input = inputField.getText();
            int radix = 10;
            if (binaryRadioButton.isSelected()) {
                radix = 2;
            } else if (hexRadioButton.isSelected()) {
                radix = 16;
            }

            // Parse the input value
            long value = 0;
            try {
                value = Long.parseLong(input, radix);
            } catch (NumberFormatException e) {
                outputField.setText("Invalid Input");
                return;
            }

            // Perform the appropriate operation
            if (source == buttons[0]) {
                // And
                value &= value;
                // Or
            } else if (source == buttons[1]) {
                value |= value;
            } else if (source == buttons[2]) {
                // Xor
                value ^= value;
            } else if (source == buttons[3]) {
                // Not
                value = ~value;
            } else if (source == buttons[4]) {
                // Shift left
                value <<= 1;
            } else if (source == buttons[5]) {
                // Shift right
                value >>= 1;
            } else {
                // A number button was clicked, so append the button label to the input field
                inputField.setText(inputField.getText() + ((JButton) source).getText());
                return;
            }

            // Update the output field with the result of the operation
            outputField.setText(Long.toString(value, radix));
        }
    }

        // Enable or disable the buttons based on the input radix
        private void enableButtons ( boolean enableDecimal, boolean enableHex, boolean enableLogical){
            // Enable or disable the decimal buttons
            for (int i = 14; i < 22; i++) {
                buttons[i].setEnabled(enableDecimal);
            }

            // Enable or disable the hex buttons
            for (int i = 6; i < 14; i++) {
                buttons[i].setEnabled(enableHex);
            }

            // Enable or disable the logical buttons
            for (int i = 0; i < 6; i++) {
                buttons[i].setEnabled(enableLogical);
            }
        }

        public static void main(String[] args) {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        }
    }


