/**
 * Part of Employ
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DashboardFrame extends CommonFrame implements ActionListener {

  JButton buttonAddData = new JButton("Add");
  JButton buttonDeleteData = new JButton("Delete");
  JButton buttonClearData = new JButton("Clear");
  JTextField textNumberInput = new JTextField(30);
  JTextField textNumberOutput = new JTextField(30);

  double numberInput = 0;
  String warnInputNumber = "Type number (dot-decimal notation)";

  // define dashboard for special frame
  public DashboardFrame() {
    super("Dashboard");

    buttonAddData.setActionCommand("addData");
    buttonDeleteData.setActionCommand("deleteData");
    buttonClearData.setActionCommand("clearData");

    buttonAddData.addActionListener(this);
    buttonDeleteData.addActionListener(this);
    buttonClearData.addActionListener(this);
    textNumberOutput.setEditable(false);

    add(buttonAddData);
    add(buttonDeleteData);
    add(buttonClearData);
    add(textNumberInput);
    add(textNumberOutput);
  }

  // get number input in text input
  // also define exception if input is not number
  void getNumberInput() {
    String numberInputString = textNumberInput.getText();
    try {
      numberInput = Double.parseDouble(numberInputString);
      textNumberOutput.setText(numberInput + "");
    } catch (Exception ex) {
      textNumberOutput.setText(warnInputNumber);
    }
  }

  // clear number output in text output
  void clearNumberOutput() {
    textNumberOutput.setText("");
  }

  // clear number input & output in text input & output
  void clearNumberInputOutput() {
    textNumberInput.setText("");
    textNumberOutput.setText("");
  }

  // give warning message in text output if number input is empty
  void warnInputNumber() {
    textNumberOutput.setText(warnInputNumber);
  }

  // define listener action when button is clicked
  public void actionPerformed(ActionEvent event) {
    if (event.getActionCommand().equals("addData")) {
      if (textNumberInput.getText().equals("")) {
        warnInputNumber();
      } else {
        getNumberInput();
      }
    } else if (event.getActionCommand().equals("deleteData")) {
      clearNumberOutput();
    } else if (event.getActionCommand().equals("clearData")) {
      clearNumberInputOutput();
    } else {
      textNumberOutput.setText("Use the button!");
    }

    repaint();
  }

}
