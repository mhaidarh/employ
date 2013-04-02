/**
 * Part of Employ
 */

import javax.swing.*;

public abstract class CommonFrame extends JFrame {

  JPanel panelHeading = new JPanel();

  // define common settings for all frame
  public CommonFrame(String heading) {
    super("Employ - " + heading);

    setSize(400, 200);
    setResizable(false);
    setLocationRelativeTo(null);
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

    JLabel labelHeading = new JLabel(heading);
    panelHeading.add(labelHeading);
    add(panelHeading);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

}

