/**
 * Part of Employ
 */

import java.awt.*;
import javax.swing.*;

public abstract class CommonFrame extends JFrame {

  JPanel panelHeading;
  JLabel labelHeading;

  // define common settings for all frame
  public CommonFrame(String heading) {
    super("Employ - " + heading);

    setSize(400, 200);
    setResizable(false);
    setLocationRelativeTo(null);
    setLayout(new FlowLayout());

    panelHeading = new JPanel();
    labelHeading = new JLabel(heading);

    add(panelHeading);
    add(labelHeading);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

}

