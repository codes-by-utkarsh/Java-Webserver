import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {
    
    public Consumer<Socket> getConsumer() {
        return clientSocket -> {
            try {
                PrintWriter toClient=new PrintWriter(clientSocket.getOutputStream(), true);
                toClient.println("Hello From the Server");
                toClient.close();
            }
            catch (IOException e) {
                System.out.println("Error handling client");
                e.printStackTrace();
            }
        };
    }
    
    public static void main(String[] args) {
        int port = 8010;
        try
        {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.getSoTimeout(10000);
            System.out.println("Server is running on port " + port);
            while (true) {
                Socket acceptedSocket = serverSocket.accept();
                System.out.println("Client connected to the server");
                Thread thread = new Thread();
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error starting server");
            e.printStackTrace();
        }
    }
}
