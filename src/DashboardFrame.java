/**
 * Part of Employ
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DashboardFrame extends CommonFrame implements ActionListener {

  JButton buttonAddData = new JButton("Add");
  JButton buttonDeleteData = new JButton("Delete");
  JTextField textInputNumber = new JTextField(10);
  JTextField textOutputNumber = new JTextField(10);

  // define dashboard for special frame
  public DashboardFrame() {
    super("Dashboard");

    buttonAddData.setActionCommand("addData");
    buttonDeleteData.setActionCommand("deleteData");

    buttonAddData.addActionListener(this);
    buttonDeleteData.addActionListener(this);
    textInputNumber.addActionListener(this);
    textOutputNumber.setEditable(false);

    add(buttonAddData);
    add(buttonDeleteData);
    add(textInputNumber);
    add(textOutputNumber);
  }

  // get input number in text input
  void getTextInput() {
    String inputNumber = textInputNumber.getText();
    textOutputNumber.setText(inputNumber);
  }

  // clear input number in text input
  void clearInputNumber() {
    textOutputNumber.setText("");
  }

  // define listener action when button is clicked
  public void actionPerformed(ActionEvent event) {
    if (event.getActionCommand().equals("addData"))
      getTextInput();
    else if (event.getActionCommand().equals("deleteData"))
      clearInputNumber();
    else
      getContentPane().setBackground(Color.white);

    repaint();
  }

}
