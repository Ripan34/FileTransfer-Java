import javax.swing.*;
import java.awt.*;
import java.net.UnknownHostException;

public class ClientPanel extends JPanel {
    /**
     * constructor
     */
    public ClientPanel()
    {
        setLayout(new BorderLayout());
        JPanel firstPanel = new JPanel();
        JLabel infoLabel = new JLabel("Enter the IP and Port of the Server"); //ipAddress label
        infoLabel.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 30));
        JTextField portField = new JTextField("Port"); //text field for Port Number
        JTextField iPField = new JTextField("IP"); //text field for IP
        portField.setPreferredSize( new Dimension( 200, 30 ));
        iPField.setPreferredSize( new Dimension( 200, 30 ));
        JButton enterButton = new JButton("Enter"); //enter button
        enterButton.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        //labels
        JLabel ip = new JLabel("IP:  ");
        JLabel port = new JLabel("Port:  ");
        JLabel connected = new JLabel("Connected!");
        JLabel errorConnecting = new JLabel("Couldn't connect please try again");
        add(infoLabel, BorderLayout.PAGE_START);
        /*Receive Panel*/
        JPanel receivePanel = new JPanel();
        firstPanel.add(ip);
        firstPanel.add(iPField);
        firstPanel.add(port);
        firstPanel.add(portField);
        firstPanel.add(enterButton);
        add(firstPanel, BorderLayout.LINE_START);
        enterButton.addActionListener(event->{
            iPAddress = iPField.getText();
            portNumber = Integer.parseInt(portField.getText());
            try {
                Client client = new Client(iPAddress, portNumber);
                firstPanel.add(connected);
                firstPanel.revalidate();
                client.run();
                receivePanel.removeAll();
                JLabel received = new JLabel("File received from IP: " + iPAddress);
                received.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
                receivePanel.add(received);
                revalidate();
                firstPanel.add(receivePanel);
                firstPanel.revalidate();
            }
            catch (Exception e) {
                firstPanel.add(errorConnecting);
                firstPanel.revalidate();
            }
        });
    }
    private String iPAddress;
    private int portNumber;
}
