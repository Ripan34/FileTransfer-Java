import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {
    /**
     * Constructor
     */
    public Server(int port) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
    }
    public void run(File file) throws Exception
    {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            OutputStream outputStream = socket.getOutputStream();
            byte data[] = new byte[(int) file.length()];
            int length;
            while ((length = fileInputStream.read(data)) > 0) {
                outputStream.write(data, 0, length);
            }
            socket.close();
            outputStream.close();
            fileInputStream.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("file Not found");
        }

    }
    public String getIpOfClient()
    {
        return socket.getRemoteSocketAddress().toString();
    }
    private Socket socket;
}
