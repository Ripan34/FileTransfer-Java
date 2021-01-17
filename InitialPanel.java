/**
 * Initial panel
 */

import javax.swing.*;
import java.awt.*;

public class InitialPanel extends JPanel {
    public InitialPanel()
    {
        //buttons
        JButton send = new JButton("Send");
        send.setPreferredSize(new Dimension(100, 40));

        JButton receive = new JButton("Receive");
        receive.setPreferredSize(new Dimension(100, 40));

        add(send);
        add(receive);
    }
}
