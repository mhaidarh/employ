/**
 * Part of Employ
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DashboardFrame extends CommonFrame implements ActionListener {

  // define dashboard for special frame
  public DashboardFrame() {
    super("Dashboard");

    JButton buttonAddData = new JButton("Add");
    buttonAddData.addActionListener(this);
    add(buttonAddData);
  }

  // define listener action when button "Add" is clicked
  public void actionPerformed(ActionEvent event) {
    getContentPane().setBackground(Color.white);
    repaint();
  }

}
