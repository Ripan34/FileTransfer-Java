import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.*;

public class Client {
     /**
     * constructor
     */
    public Client(String ip, int portN) throws IOException {
        iPAddress = ip;
        portNumber = portN;
        try {
            sock = new Socket(iPAddress, portNumber);
        }
        catch(UnknownHostException e)
        {
            throw e;
        }
    }
    public void run() throws Exception
    {
        try {
            InputStreamReader IR = new InputStreamReader(sock.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            int c;
            while ((c = IR.read()) != -1) {
                fileOutputStream.write(c);
            }
            IR.close();
            fileOutputStream.close();
        }
        catch(UnknownHostException e)
        {
            throw e;
        }

    }
    public long getAmountOfData()
    {
        return outputFile.length();
    }
    private String fileName;
    private String iPAddress;
    private int portNumber;
    Socket sock;
    File outputFile = new File("fileReceived.txt");

}
