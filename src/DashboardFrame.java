/**
 * Part of Employ
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DashboardFrame extends CommonFrame implements ActionListener {

  JPanel panelInput = new JPanel();
  JPanel panelType = new JPanel();
  JPanel panelButton = new JPanel();
  JPanel panelOutput = new JPanel();

  JLabel labelNumberInput = new JLabel("Number Input: ");
  JTextField textNumberInput = new JTextField(10);

  ButtonGroup employeeType = new ButtonGroup();
  JRadioButton eSalaried = new JRadioButton("Salaried", true);
  JRadioButton eHourly = new JRadioButton("Hourly", false);
  JRadioButton eCommission = new JRadioButton("Commission", false);
  JRadioButton eCommissionPlus = new JRadioButton("Commission Plus", false);

  JLabel labelNumberOutput = new JLabel("Number Output: ");
  JTextField textNumberOutput = new JTextField(10);
  JLabel labelTypeOutput = new JLabel("Employee Type: ");
  JTextField textTypeOutput = new JTextField(15);

  JButton buttonAddData = new JButton("Add");
  JButton buttonDeleteData = new JButton("Delete");
  JButton buttonClearData = new JButton("Clear");

  double numberInput = 0;
  String warnInput = "Type number (dot-decimal)";

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

    eSalaried.setActionCommand("typeSalaried");
    eHourly.setActionCommand("typeHourly");
    eCommission.setActionCommand("typeCommission");
    eCommissionPlus.setActionCommand("typeCommissionPlus");
    employeeType.add(eSalaried);
    employeeType.add(eHourly);
    employeeType.add(eCommission);
    employeeType.add(eCommissionPlus);
    panelType.setLayout(new BoxLayout(panelType, BoxLayout.Y_AXIS));
    panelType.add(eSalaried);
    panelType.add(eHourly);
    panelType.add(eCommission);
    panelType.add(eCommissionPlus);

    panelInput.add(labelNumberInput);
    panelInput.add(textNumberInput);

    panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.X_AXIS));
    panelButton.add(buttonAddData);
    panelButton.add(buttonDeleteData);
    panelButton.add(buttonClearData);

    panelOutput.setLayout(new BoxLayout(panelOutput, BoxLayout.Y_AXIS));
    panelOutput.add(labelNumberOutput);
    panelOutput.add(textNumberOutput);
    panelOutput.add(labelTypeOutput);
    panelOutput.add(textTypeOutput);

    add(panelInput);
    add(panelType);
    add(panelButton);
    add(panelOutput);
  }

  // get number input in text input
  // also define exception if input is not number
  void getInputAll() {
    String numberInputString = textNumberInput.getText();
    try {
      numberInput = Double.parseDouble(numberInputString);
      textNumberOutput.setText(numberInput + "");
      textTypeOutput.setText(getSelectedButtonText(employeeType));
    } catch (Exception ex) {
      textNumberOutput.setText(warnInput);
    }
  }

  // clear number output in text output
  void clearOutputAll() {
    textNumberOutput.setText("");
    textTypeOutput.setText("");
  }

  // clear number input & output in text input & output
  void clearInputOutputAll() {
    textNumberInput.setText("");
    textNumberOutput.setText("");
    textTypeOutput.setText("");
  }

  // give warning message in text output if number input is empty
  void warnInput() {
    textNumberOutput.setText(warnInput);
  }

  // define listener action when button is clicked
  public void actionPerformed(ActionEvent event) {
    if (event.getActionCommand().equals("addData")) {
      if (textNumberInput.getText().equals("")) {
        warnInput();
      } else {
        getInputAll();
      }
    } else if (event.getActionCommand().equals("deleteData")) {
      clearOutputAll();
    } else if (event.getActionCommand().equals("clearData")) {
      clearInputOutputAll();
    } else {
      textNumberOutput.setText("Use the button!");
    }

    repaint();
  }

}
