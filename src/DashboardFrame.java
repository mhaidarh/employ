/**
 * Part of Employ
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DashboardFrame extends CommonFrame implements ActionListener {

  JButton buttonAddData = new JButton("Add");
  JButton buttonDeleteData = new JButton("Delete");
  JTextField textNumber = new JTextField(10);
  JTextField textOutput = new JTextField(10);

  // define dashboard for special frame
  public DashboardFrame() {
    super("Dashboard");

    buttonAddData.setActionCommand("addData");
    buttonDeleteData.setActionCommand("deleteData");

    buttonAddData.addActionListener(this);
    buttonDeleteData.addActionListener(this);
    textNumber.addActionListener(this);

    add(buttonAddData);
    add(buttonDeleteData);
    add(textNumber);
    add(textOutput);
  }

  // define listener action when button "Add" is clicked
  public void actionPerformed(ActionEvent event) {
    String inputNumber = textNumber.getText();
    textOutput.setText(inputNumber);

    if (event.getActionCommand().equals("addData"))
      getContentPane().setBackground(Color.white);
    else if (event.getActionCommand().equals("deleteData"))
      getContentPane().setBackground(Color.darkGray);
    else
      getContentPane().setBackground(Color.black);

    repaint();
  }

}
