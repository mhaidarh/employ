/**
 * Part of Employ
 */

import java.awt.*;
import java.util.Enumeration;

import javax.swing.*;

public abstract class CommonFrame extends JFrame {

  JPanel panelHeading = new JPanel();

  // define common settings for all frame
  public CommonFrame(String heading) {
    super("Employ - " + heading);

    setSize(300, 400);
    setResizable(false);
    setLocationRelativeTo(null);
    setLayout(new FlowLayout());

    JLabel labelHeading = new JLabel(heading);
    panelHeading.add(labelHeading);
    add(panelHeading);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  // custom method to get text of the selected button
  public String getSelectedButtonText(ButtonGroup buttonGroup) {
    Enumeration<AbstractButton> buttons;
    for (buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
      AbstractButton button = buttons.nextElement();
      if (button.isSelected())
        return button.getText();
    }
    return null;
  }

}

