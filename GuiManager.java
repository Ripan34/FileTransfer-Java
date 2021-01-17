import javax.swing.*;
import java.awt.*;

/**
 * a class to build GUI
 */
public class GuiManager extends JFrame {
    public GuiManager() {
        ServerPanel Serverpanel = new ServerPanel();
        JPanel clientPanel = new ClientPanel();
        CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);

        JPanel initialPanel = new JPanel();
        add(initialPanel, "initial");
        add(Serverpanel, "server");
        add(clientPanel, "client");

        //buttons

        initialPanel.add(Box.createRigidArea(new Dimension(0, 150)));

        JButton send = new JButton("Send");
        send.setPreferredSize(new Dimension(100, 40));
        send.addActionListener(event-> {cardLayout.show(getContentPane(), "server");});
        JButton receive = new JButton("Receive");
        receive.addActionListener(event->{cardLayout.show(getContentPane(), "client");});
        receive.setPreferredSize(new Dimension(100, 40));

        initialPanel.add(send);
        initialPanel.add(receive);

        setMinimumSize(new Dimension(400, 400));
        setVisible(true);
        setSize(1000,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GuiManager guiManager = new GuiManager();
    }
}
