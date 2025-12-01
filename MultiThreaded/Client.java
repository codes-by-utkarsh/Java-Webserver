public class Client
{

    public Runnable getRunnable()
    {
        return new Runnable()
        {
            @Override
            public void run()
            {
                int port = 8010;
                try {
                    InetAddress address = InetAddress.getByName("localhost");
                    Socket socket = new Socket(address, port);
                    try {
                        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
                        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    }
                    {

                        toSocket.println("Hello From the Client");
                        String line = fromSocket.readLine();
                        System.out.println("Response from the socket is " + line);
                    }
                catch(Exception e)
                    {
                        System.out.println("Error " + e.printStackTrace());

                    }
                }
                    catch(Exception e)
                    {
                        System.out.println("Error "+e.printStackTrace() );

                    }

            }
        }
    }





    public static void main(String[] args)
    {
        Client client = new Client();
        for(int i=1;i<100;i++)
        {
            try
            {
                Thread thread = new Thread(Client.getRunnable());
            }
            catch(Exception e)
            {
                System.out.println("Error Occured "+e.printStackTrace());
            }
        }
    }
}