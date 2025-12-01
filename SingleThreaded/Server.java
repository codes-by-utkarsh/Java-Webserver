import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server
{
    public void run() throws IOException
    {
        int port = 8010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);
        System.out.println("Server is running on port " + port);
        while (true) {
            try{
                Socket acceptedSocket = socket.accept();
                System.out.println("Client connected To InetAddress"+acceptedSocket.getInetAddress()+" RemoteSocketAddress: "+acceptedSocket.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedSocket.getOutputStream(), true);
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedSocket.getInputStream()));
                toClient.println("Hello From the Server");
                toClient.close();
                fromClient.close();
                acceptedSocket.close();
            } catch (SocketTimeoutException e) {
                System.out.println("Waiting for clients...");
            } catch (IOException e) {
                System.out.println("Error accepting client connection");
                e.printStackTrace();
            }   
            
            
        }
    }
    
    
    public static void main(String[] args) {
        try{
            Server server = new Server();
            server.run();
        } catch (IOException e) {
            System.out.println("Error starting server");
            e.printStackTrace();
        }
    }
}