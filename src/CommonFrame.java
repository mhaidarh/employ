/**
 * Part of Employ
 */

import java.awt.*;
import javax.swing.*;

public abstract class CommonFrame extends JFrame {

  JPanel commonPanel;

  // define common settings for all frame
  public CommonFrame(String section) {
    super("Employ");

    setSize(500, 300);
    setLocationRelativeTo(null);
    setLayout(new FlowLayout());

    JLabel sectionLabel = new JLabel(section);
    add(sectionLabel);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

}

