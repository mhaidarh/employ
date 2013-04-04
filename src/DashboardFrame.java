/**
 * SMTI06, M Haidar Hanif, 54411850
 * Part of Employ
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DashboardFrame extends CommonFrame implements ActionListener {

  // panels on frame
  JPanel panelInput = new JPanel();
  JPanel panelType = new JPanel();
  JPanel panelMore = new JPanel();
  JPanel panelButton = new JPanel();
  JPanel panelOutput = new JPanel();

  // input components
  JLabel labelSSNInput = new JLabel("SSN:");
  JTextField textSSNInput = new JTextField(8);
  JLabel labelNameFirst = new JLabel("First Name:");
  JTextField textNameFirst = new JTextField(15);
  JLabel labelNameLast = new JLabel("Last Name:");
  JTextField textNameLast = new JTextField(15);

  JLabel labelType = new JLabel("Employee Type:");
  ButtonGroup eType = new ButtonGroup();
  JRadioButton eSalaried = new JRadioButton("Salaried", true);
  JRadioButton eHourly = new JRadioButton("Hourly", false);
  JRadioButton eCommission = new JRadioButton("Commission", false);
  JRadioButton eCommissionPlus = new JRadioButton("Commission Plus", false);

  JLabel labelSalary = new JLabel("Weekly Salary ($):");
  JTextField textSalary = new JTextField();
  JLabel labelWage = new JLabel("Wage ($):");
  JTextField textWage = new JTextField();
  JLabel labelHours = new JLabel("Hours (0-168):");
  JTextField textHours = new JTextField();
  JLabel labelRate = new JLabel("Commission Rate (%):");
  JTextField textRate = new JTextField();
  JLabel labelSales = new JLabel("Gross Sales ($):");
  JTextField textSales = new JTextField();
  JLabel labelPieces = new JLabel("Pieces Produced (>0):");
  JTextField textPieces = new JTextField();

  // output components
  JLabel labelSSNOutput = new JLabel("Registered SSN: ");
  JTextField textSSNOutput = new JTextField(10);
  JLabel labelNameFull = new JLabel("Full Name: ");
  JTextField textNameFull = new JTextField(31);
  JLabel labelTypeOutput = new JLabel("Employee Type: ");
  JTextField textTypeOutput = new JTextField(16);

  // control components
  JButton buttonAddData = new JButton("Add");
  JButton buttonDeleteData = new JButton("Delete");
  JButton buttonClearData = new JButton("Clear");
  JButton buttonDisplayData = new JButton("Display");

  // reuse variables
  int ssnInput;
  String warnSSN = "Type SSN (Social Security Number)!";
  String warnName = "Type first name with/without last name!";

  // define dashboard for special frame
  public DashboardFrame() {
    super("Dashboard");

    // define event action listener
    buttonAddData.setActionCommand("addData");
    buttonDeleteData.setActionCommand("deleteData");
    buttonClearData.setActionCommand("clearData");
    buttonDisplayData.setActionCommand("displayData");

    buttonAddData.addActionListener(this);
    buttonDeleteData.addActionListener(this);
    buttonClearData.addActionListener(this);

    eSalaried.setActionCommand("typeSalaried");
    eHourly.setActionCommand("typeHourly");
    eCommission.setActionCommand("typeCommission");
    eCommissionPlus.setActionCommand("typeCommissionPlus");

    // put components on panel
    panelInput.setLayout(new BoxLayout(panelInput, BoxLayout.Y_AXIS));
    panelInput.add(labelSSNInput);
    panelInput.add(textSSNInput);
    panelInput.add(labelNameFirst);
    panelInput.add(textNameFirst);
    panelInput.add(labelNameLast);
    panelInput.add(textNameLast);

    panelType.setLayout(new BoxLayout(panelType, BoxLayout.Y_AXIS));
    panelType.add(labelType);
    eType.add(eSalaried);
    eType.add(eHourly);
    eType.add(eCommission);
    eType.add(eCommissionPlus);
    panelType.add(eSalaried);
    panelType.add(eHourly);
    panelType.add(eCommission);
    panelType.add(eCommissionPlus);

    panelMore.setLayout(new BoxLayout(panelMore, BoxLayout.Y_AXIS));
    panelMore.add(labelSalary);
    panelMore.add(textSalary);
    panelMore.add(labelWage);
    panelMore.add(textWage);
    panelMore.add(labelHours);
    panelMore.add(textHours);
    panelMore.add(labelRate);
    panelMore.add(textRate);
    panelMore.add(labelSales);
    panelMore.add(textSales);
    panelMore.add(labelPieces);
    panelMore.add(textPieces);
    textSalary.setEditable(false);
    textWage.setEditable(false);
    textHours.setEditable(false);
    textRate.setEditable(false);
    textSales.setEditable(false);
    textPieces.setEditable(false);

    panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.X_AXIS));
    panelButton.add(buttonAddData);
    panelButton.add(buttonDeleteData);
    panelButton.add(buttonClearData);
    panelButton.add(buttonDisplayData);

    panelOutput.setLayout(new BoxLayout(panelOutput, BoxLayout.Y_AXIS));
    panelOutput.add(labelSSNOutput);
    panelOutput.add(textSSNOutput);
    panelOutput.add(labelNameFull);
    panelOutput.add(textNameFull);
    panelOutput.add(labelTypeOutput);
    panelOutput.add(textTypeOutput);
    textSSNOutput.setEditable(false);
    textNameFull.setEditable(false);
    textTypeOutput.setEditable(false);

    // put panels on frame
    add(panelInput);
    add(panelType);
    add(panelMore);
    add(panelButton);
    add(panelOutput);
  }

  // get number input in text input
  // also define exception if input is not number
  void getInputAll() {
    String numberInputString = textSSNInput.getText();
    try {
      ssnInput = Integer.parseInt(numberInputString);
      textSSNOutput.setText(ssnInput + "");
      textNameFull.setText(textNameFirst.getText() + " " + textNameLast.getText());
      textTypeOutput.setText(getSelectedButtonText(eType));
    } catch (Exception ex) {
      textSSNOutput.setText(warnSSN);
    }
  }

  // clear number output in text output
  void clearOutputAll() {
    textSSNOutput.setText("");
    textNameFull.setText("");
    textTypeOutput.setText("");
  }

  // clear number input & output in text input & output
  void clearInputOutputAll() {
    textSSNInput.setText("");
    textNameFirst.setText("");
    textNameLast.setText("");
    textSSNOutput.setText("");
    textNameFull.setText("");
    textTypeOutput.setText("");
  }

  // give warning message in SSN output if SSN input is empty
  void warnSSNInput() {
    textSSNOutput.setText(warnSSN);
  }

  // give warning message in full name output if first and/or last name is empty
  void warnNameInput() {
    textNameFull.setText(warnName);
  }

  // define listener action when specific button is clicked
  public void actionPerformed(ActionEvent event) {
    if (event.getActionCommand().equals("addData")) {
      clearOutputAll();
      if (textSSNInput.getText().equals("") || (textNameFirst.getText().equals(""))) {
          if (!textSSNInput.getText().equals("")) {
            warnNameInput();
          } else if (!textNameFirst.getText().equals("")) {
            warnSSNInput();
          } else {
            warnSSNInput();
            warnNameInput();
          }
        } else {
          getInputAll();
        }
    } else if (event.getActionCommand().equals("deleteData")) {
      clearOutputAll();
    } else if (event.getActionCommand().equals("clearData")) {
      clearInputOutputAll();
    } else {
      getContentPane().setBackground(Color.white);
    }
    repaint();
  }

}
