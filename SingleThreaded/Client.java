import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client
{
    public void run() throws IOException
    {
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");
        try
        {
            Socket socket = new Socket(address, port);
        }
    }
}
