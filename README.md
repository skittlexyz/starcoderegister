# Star Code Register ⭐
Made in Java, this system is a register program that stores user data in a dynamically resizable <code>ArrayList&lt;&gt;</code>.<br>
The program has the following options:
- Register an user
- Search for an user
- Show all the users
#
The program uses the following libraries:<br>

````
java.awt.Dimension;
java.awt.event.ActionEvent;
java.awt.event.ActionListener;
java.util.ArrayList;
javax.swing.JOptionPane;
javax.swing.JScrollPane;
javax.swing.JTextArea;
javax.swing.JFrame;
javax.swing.JLabel;
javax.swing.JButton;
java.text.Normalizer;
java.util.regex.Pattern;
````

#
It also has verification methods to ensure that the user enters the information correctly. It works like this example:<br>

````java
javax.swing.JOptionPane;

public static main(String[] args) {
  // Calling the method
  String name = checkForString(JOptionPane.showInputDialog(null, "Type your info!", windowTitle, JOptionPane.QUESTION_MESSAGE));
}

private String checkForString(String current) {
  // If the user close the input window, the method returns nothing
  if (current == null) {
    return "";
  } else {
    // If the user type nothing and click "Ok", the method dialogs the user and calls itself
    if (current == "" || current.length() <= 0) {
      JOptionPane.showMessageDialog(null, "The text can't be empty!", windowTitle, JOptionPane.INFORMATION_MESSAGE);
      return checkForString(JOptionPane.showInputDialog(null, "Type your info!", windowTitle, JOptionPane.QUESTION_MESSAGE), 1);				
    } 
    // If the user type the info correctly and press ok, the method returns the info
    else {
      return current;
    }
  }
  // This return isn't used, it is here just for good practices
  return "";
}
````
###### ~ 2023
