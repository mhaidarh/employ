/**
 * Part of Employ
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DashboardFrame extends CommonFrame implements ActionListener {

  JButton buttonAddData       = new JButton("Add");
  JButton buttonDeleteData    = new JButton("Delete");
  JButton buttonClearData     = new JButton("Clear");
  JTextField textInputNumber  = new JTextField(20);
  JTextField textOutputNumber = new JTextField(20);

  // define dashboard for special frame
  public DashboardFrame() {
    super("Dashboard");

    buttonAddData.setActionCommand("addData");
    buttonDeleteData.setActionCommand("deleteData");
    buttonClearData.setActionCommand("clearData");

    buttonAddData.addActionListener(this);
    buttonDeleteData.addActionListener(this);
    buttonClearData.addActionListener(this);
    textInputNumber.addActionListener(this);
    textOutputNumber.setEditable(false);

    add(buttonAddData);
    add(buttonDeleteData);
    add(buttonClearData);
    add(textInputNumber);
    add(textOutputNumber);
  }

  // get number input in text input
  void getNumberInput() {
    String inputNumber = textInputNumber.getText();
    textOutputNumber.setText(inputNumber);
  }

  // clear number output in text output
  void clearNumberOutput() {
    textOutputNumber.setText("");
  }

  // clear number input & output in text input & output
  void  clearNumberInputOutput() {
    textInputNumber.setText("");
    textOutputNumber.setText("");
  }

  // give warning message in text output if number input is empty
  void  warnInputNumber() {
    textOutputNumber.setText("Type input text!");
  }

  // define listener action when button is clicked
  public void actionPerformed(ActionEvent event) {
    if (event.getActionCommand().equals("addData")) {
      if (textInputNumber.getText().equals(""))
        warnInputNumber();
      else
        getNumberInput();
    }
    else if (event.getActionCommand().equals("deleteData"))
      clearNumberOutput();
    else  if (event.getActionCommand().equals("clearData"))
      clearNumberInputOutput();
    else
      getContentPane().setBackground(Color.white);

    repaint();
  }

}
