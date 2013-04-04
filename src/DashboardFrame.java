/**
 * SMTI06, M Haidar Hanif, 54411850
 * Part of Employ
 */

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
  ButtonGroup cTypes = new ButtonGroup();
  String eSalaried = "Salaried";
  String eHourly = "Hourly";
  String eCommission = "Commission";
  String eCommissionPlus = "Commission Plus";
  String ePieceWorker = "Piece Worker";
  JRadioButton cSalaried = new JRadioButton(eSalaried, true);
  JRadioButton cHourly = new JRadioButton(eHourly, false);
  JRadioButton cCommission = new JRadioButton(eCommission, false);
  JRadioButton cCommissionPlus = new JRadioButton(eCommissionPlus, false);
  JRadioButton cPieceWorker = new JRadioButton(ePieceWorker, false);

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

  // control components
  JButton buttonAddData = new JButton("Add");
  JButton buttonDeleteData = new JButton("Delete");
  JButton buttonClearData = new JButton("Clear");
  JButton buttonDisplayData = new JButton("Display");

  // output components
  JLabel labelSSNOutput = new JLabel("Registered SSN:");
  JTextField textSSNOutput = new JTextField(10);
  JLabel labelNameFull = new JLabel("Full Name:");
  JTextField textNameFull = new JTextField(31);
  JLabel labelTypeOutput = new JLabel("Employee Type:");
  JTextField textTypeOutput = new JTextField(16);
  JLabel labelEarningsOutput = new JLabel("Earnings ($):");
  JTextField textEarningsOutput = new JTextField(31);

  // reuse variables
  private String ssnInput;
  private String firstName;
  private String lastName;
  private String eType;
  private double eEarnings;
  private String warnSSN = "Type SSN (Social Security Number)!";
  private String warnName = "Type first name with/without last name!";
  private String warnMore = "Type all required additional information!";

  double iSalary = 0;
  double iWage = 0;
  double iHours = 0;
  double iRate = 0;
  double iSales = 0;
  double iPieces = 0;

  // define dashboard for special frame
  public DashboardFrame() {
    super("Dashboard");

    // define event action listener
    cSalaried.setActionCommand("typeSalaried");
    cHourly.setActionCommand("typeHourly");
    cCommission.setActionCommand("typeCommission");
    cCommissionPlus.setActionCommand("typeCommissionPlus");
    cPieceWorker.setActionCommand("typePieceWorker");

    cSalaried.addActionListener(this);
    cHourly.addActionListener(this);
    cCommission.addActionListener(this);
    cCommissionPlus.addActionListener(this);
    cPieceWorker.addActionListener(this);

    buttonAddData.setActionCommand("addData");
    buttonDeleteData.setActionCommand("deleteData");
    buttonClearData.setActionCommand("clearData");
    buttonDisplayData.setActionCommand("displayData");
    buttonDisplayData.setEnabled(false); // temporary

    buttonAddData.addActionListener(this);
    buttonDeleteData.addActionListener(this);
    buttonClearData.addActionListener(this);

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
    cTypes.add(cSalaried);
    cTypes.add(cHourly);
    cTypes.add(cCommission);
    cTypes.add(cCommissionPlus);
    cTypes.add(cPieceWorker);
    panelType.add(cSalaried);
    panelType.add(cHourly);
    panelType.add(cCommission);
    panelType.add(cCommissionPlus);
    panelType.add(cPieceWorker);

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
    panelOutput.add(labelEarningsOutput);
    panelOutput.add(textEarningsOutput);
    textSSNOutput.setEditable(false);
    textNameFull.setEditable(false);
    textTypeOutput.setEditable(false);
    textEarningsOutput.setEditable(false);

    // put panels on frame
    add(panelInput);
    add(panelType);
    add(panelMore);
    add(panelButton);
    add(panelOutput);
  }

  // get number input in text input
  // also define exception if input is not number
  private void getInputAll() {
    ssnInput = textSSNInput.getText();
    firstName = textNameFirst.getText();
    lastName = textNameLast.getText();
    eType = getSelectedButtonText(cTypes);
    eEarnings = getEarnings();
    try {
      textSSNOutput.setText(ssnInput);
      textNameFull.setText(firstName + " " + lastName);
      textTypeOutput.setText(eType);
      textEarningsOutput.setText(eEarnings + "");
    } catch (Exception ex) {
      warnAllInput();
    }
  }

  // give warning message in SSN output if SSN input is empty
  private void warnSSNInput() {
    textSSNOutput.setText(warnSSN);
  }

  // give warning message in full name output if first and/or last name is empty
  private void warnNameInput() {
    textNameFull.setText(warnName);
  }

  private void warnMoreInput() {
    textEarningsOutput.setText(warnMore);
  }

  private void warnAllInput() {
    warnSSNInput();
    warnNameInput();
    warnMoreInput();
  }

  // clear all input in text input
  private void clearInputAll() {
    textSSNInput.setText("");
    textNameFirst.setText("");
    textNameLast.setText("");
  }

  // clear all output in text output
  private void clearOutputAll() {
    textSSNOutput.setText("");
    textNameFull.setText("");
    textTypeOutput.setText("");
    textEarningsOutput.setText("");
  }

  // clear all input & output in text input & output
  private void clearInputOutputAll() {
    clearInputAll();
    clearOutputAll();
  }

  // get earnings based on employee type
  private double getEarnings() {
    if (eType == eSalaried) {
      // iSalary = Double.parseDouble(textSalary.getText());
      // SalariedEmployee(first, last, ssn, double salary)
      Employee thisEmployee = new SalariedEmployee(ssnInput, firstName, lastName, 500);
      return thisEmployee.earnings();
    } else if (eType == eHourly) {
      // iWage = Double.parseDouble(textWage.getText());
      // iHours = Double.parseDouble(textHours.getText());
      // HourlyEmployee(first, last, ssn, double hourlyWage, double hoursWorked)
      Employee thisEmployee = new HourlyEmployee(ssnInput, firstName, lastName, 200, 20);
      return thisEmployee.earnings();
    } else if (eType == eCommission) {
      // iSales = Double.parseDouble(textSales.getText());
      // iRate = Double.parseDouble(textRate.getText());
      // CommissionEmployee(first, last, ssn, double sales, double rate)
      Employee thisEmployee = new CommissionEmployee(ssnInput, firstName, lastName, 10000, 3);
      return thisEmployee.earnings();
    } else if (eType == eCommissionPlus) {
      // iSales = Double.parseDouble(textSales.getText());
      // iRate = Double.parseDouble(textRate.getText());
      // iSalary = Double.parseDouble(textSalary.getText());
      // CommissionPlusEmployee(first, last, ssn, double sales, double rate, double salary)
      Employee thisEmployee = new CommissionPlusEmployee(ssnInput, firstName, lastName, 6000, 3, 200);
      return thisEmployee.earnings();
    } else if (eType == ePieceWorker) {
      // iPieces = Double.parseDouble(textPieces.getText());
      // iWage = Double.parseDouble(textWage.getText());
      // PieceWorker(first, last, ssn, int np, double wp)
      Employee thisEmployee = new PieceWorker(ssnInput, firstName, lastName, 100, 200);
      return thisEmployee.earnings();
    } else {
      return 0;
    }
  }

  // define listener action when specific button is clicked
  public void actionPerformed(ActionEvent event) {
    if (event.getActionCommand().equals("addData")) {
      clearOutputAll();
      if (textSSNInput.getText().equals("") || (textNameFirst.getText().equals(""))) {
        if (!textNameFirst.getText().equals("")) {
          warnSSNInput();
        } else if (!textSSNInput.getText().equals("")) {
          warnNameInput();
        } else {
          warnSSNInput();
          warnNameInput();
        }
      } else {
        getInputAll();
        getEarnings();
      }
    } else if (event.getActionCommand().equals("deleteData")) {
      clearOutputAll();
    } else if (event.getActionCommand().equals("clearData")) {
      clearInputOutputAll();
    } else {
      clearOutputAll();
    }
    repaint();
  }

}
