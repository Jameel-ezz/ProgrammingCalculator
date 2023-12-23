# Programming Calculator

 This Java code defines a simple calculator application with a graphical user interface (GUI) using Swing. The calculator supports binary, decimal, and hexadecimal number systems and includes logical operations (And, Or, Xor, Not, Shift Left, Shift Right). Here's a breakdown of the code:

Class Declaration and Imports:

The Calculator class extends JFrame and implements the ActionListener interface for handling button clicks.
Import statements include classes from the java.awt and javax.swing packages.
Instance Variables:

Various components of the GUI are declared as instance variables, including radio buttons, text fields, buttons, and button labels.
Constructor (Calculator()):

The constructor sets up the layout of the frame using GridBagLayout and initializes the GUI components.
Radio buttons for selecting the number system (binary, decimal, or hexadecimal) are created and added to a button group.
Input and output text fields are created.
Buttons are created using an array of button labels.
Logical operation buttons and numeric buttons are arranged in rows and columns using GridBagConstraints.
ActionListener (actionPerformed method):

This method is invoked when an action (e.g., button click) occurs.
It checks the source of the event and performs different actions accordingly.
If a radio button is selected, it enables or disables numeric buttons based on the selected number system.
If a numeric or logical operation button is clicked, it updates the input field accordingly.
Logical operation buttons perform bitwise operations on the current input.
The result of the operation is displayed in the output field.
Private Method (enableButtons):

This method is used to enable or disable numeric and logical operation buttons based on the selected number system.
main Method:

The main method creates an instance of the Calculator class and makes the calculator visible.
In summary, this code implements a basic calculator with support for different number systems and logical operations. Users can input numbers in the selected radix, perform logical operations, and see the results in the output field.
![image](https://github.com/Jameel-ezz/ProgrammingCalculator/assets/120614240/5ac1c190-d4f4-42f4-afe3-fa73ede965d4)

