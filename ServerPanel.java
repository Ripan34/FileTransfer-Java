import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * a class for server panel
 */
public class ServerPanel extends JPanel {
    /**
     * constructor
     */
    public ServerPanel()
    {
        setLayout(new BorderLayout());
        JPanel firstPanel = new JPanel();
        JLabel portLabel = new JLabel("Enter the Port of the Server"); //ipAddress label
        portLabel.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 30));
        JTextField portField = new JTextField(); //text field for Port Number
        portField.setPreferredSize( new Dimension( 200, 30 ));
        JButton enterIpButton = new JButton("Enter"); //IPAddress button
        enterIpButton.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        JLabel waiting = new JLabel("Waiting for a Client");

        add(portLabel, BorderLayout.PAGE_START);
        firstPanel.add(portField);
        firstPanel.add(enterIpButton);
        add(firstPanel, BorderLayout.LINE_START);

        //second panel for file choosing
        JPanel choosingPanel = new JPanel();
        JLabel chooseLabel = new JLabel("Choose your File"); //file choose label
        chooseLabel.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 30));
        choosingPanel.add(chooseLabel); //add the choose label
        JLabel empty = new JLabel("                        ");
        choosingPanel.add(empty);
        JLabel fileLabel = new JLabel("//");
        choosingPanel.add(fileLabel);
        JButton chooseButton = new JButton("Choose");
        chooseButton.addActionListener(event->{JFileChooser fileChooser = new JFileChooser("d:");
            int status = fileChooser.showOpenDialog(null);

            if (status == JFileChooser.APPROVE_OPTION) {
                fileToSend = fileChooser.getSelectedFile();
                fileLabel.setText(fileToSend.getAbsolutePath());
                choosingPanel.revalidate();
            }
        });
        JButton sendButton = new JButton("Send");

            sendButton.addActionListener(event -> {
                try {
                    server.run(fileToSend);
                } catch (Exception e) {
                    System.out.println("cant send");
                }
            });


        sendButton.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        choosingPanel.add(chooseButton);
        choosingPanel.add(sendButton);
        choosingPanel.show(false);

        /*listener for enter button*/
        enterIpButton.addActionListener(event->{
            firstPanel.add(waiting);
            firstPanel.revalidate();

            portNumber = Integer.parseInt(portField.getText());
            try {
                server = new Server(portNumber);
            } catch (IOException e) {
                e.printStackTrace();
            }
            firstPanel.remove(waiting);
            JLabel connected = new JLabel("connected to IP: " + server.getIpOfClient());
            firstPanel.add(connected);
            choosingPanel.show(true);
            revalidate();});

        add(choosingPanel, BorderLayout.PAGE_END);
    }
    private Server server;
    private int portNumber;
    private File fileToSend;
}
