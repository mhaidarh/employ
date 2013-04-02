/**
 * Part of Employ
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DashboardFrame extends CommonFrame implements ActionListener {

  JPanel panelFieldInput = new JPanel();
  JPanel panelFieldOutput = new JPanel();
  JPanel panelButton = new JPanel();

  JLabel labelNumberInput = new JLabel("Number Input: ");
  JTextField textNumberInput = new JTextField(20);
  JLabel labelNumberOutput = new JLabel("Number Output: ");
  JTextField textNumberOutput = new JTextField(20);

  JButton buttonAddData = new JButton("Add");
  JButton buttonDeleteData = new JButton("Delete");
  JButton buttonClearData = new JButton("Clear");

  double numberInput = 0;
  String warnInputNumber = "Type number (dot-decimal)";

  // define dashboard for special frame
  public DashboardFrame() {
    super("Dashboard");

    // define event action listener
    buttonAddData.setActionCommand("addData");
    buttonDeleteData.setActionCommand("deleteData");
    buttonClearData.setActionCommand("clearData");

    buttonAddData.addActionListener(this);
    buttonDeleteData.addActionListener(this);
    buttonClearData.addActionListener(this);
    textNumberOutput.setEditable(false);

    // put component on panel on frame
    panelFieldInput.add(labelNumberInput);
    panelFieldInput.add(textNumberInput);
    panelFieldOutput.add(labelNumberOutput);
    panelFieldOutput.add(textNumberOutput);

    panelButton.add(buttonAddData);
    panelButton.add(buttonDeleteData);
    panelButton.add(buttonClearData);

    add(panelFieldInput);
    add(panelFieldOutput);
    add(panelButton);
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
