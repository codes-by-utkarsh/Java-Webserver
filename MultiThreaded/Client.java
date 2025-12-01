import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public Runnable getRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                int port = 8010;

                try {
                    InetAddress address = InetAddress.getByName("localhost");
                    Socket socket = new Socket(address, port);

                    PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    // Send and receive
                    toSocket.println("Hello From the Client");
                    String line = fromSocket.readLine();
                    System.out.println("Response from the server: " + line);

                    socket.close();

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) {
        Client client = new Client();

        for (int i = 1; i < 100; i++) {
            try {
                Thread thread = new Thread(client.getRunnable());
                thread.start();
            } catch (Exception e) {
                System.out.println("Error Occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
