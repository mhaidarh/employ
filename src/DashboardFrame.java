/**
 * Part of Employ
 */

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DashboardFrame extends CommonFrame implements ActionListener {

  // define dashboard for special frame
  public DashboardFrame() {
    super("Dashboard");
    JButton buttonAddData = new JButton("Add");
    buttonAddData.addActionListener(this);
    getContentPane().add(buttonAddData);
    setVisible(true);
  }

  // define listener action when "Add" is clicked
  public void actionAddData(ActionListener event) {
    getContentPane().setBackground(Color.white);
    repaint();
  }

}
