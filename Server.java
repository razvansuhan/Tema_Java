import java.io.*;
import java.net.*;
import java.sql.PseudoColumnUsage;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

// Server class
class Server {
    static ArrayList<Human> humans=new ArrayList<Human>();
    public static void main(String[] args)
    {
        ServerSocket server = null;
        int portNumber = 1200;
        try {

            // server is listening on port
            server = new ServerSocket(portNumber);
            // server.setReuseAddress(true);

            // running infinite loop for getting
            // client request
            while (true) {

                // socket object to receive incoming client
                // requests
                Socket client = server.accept();

                // Displaying that new client is connected
                // to server
                System.out.println("New client connected"
                        + client.getInetAddress()
                        .getHostAddress());

                // create a new thread object
                ClientHandler clientSock
                        = new ClientHandler(client);

                // This thread will handle the client
                // separately
                clientSock.start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // ClientHandler class
    //private static class ClientHandler implements Runnable {
    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        // Constructor
        public ClientHandler(Socket socket)
        {
            this.clientSocket = socket;
        }

        public void run()
        {
            PrintWriter out = null;
            BufferedReader in = null;
            BufferedReader stdIn = null;
            ArrayList<Human>facultate=new ArrayList<Human>();
            try {
                while(true) {
                    // get the outputstream of client
                    out = new PrintWriter(
                            clientSocket.getOutputStream(), true);

                    // get the inputstream of client
                    in = new BufferedReader(
                            new InputStreamReader(
                                    clientSocket.getInputStream()));

                    stdIn =                                       // 4th statement
                            new BufferedReader(
                                    new InputStreamReader(System.in));
                    String line = null;
                    while ((line = in.readLine()) != null) {
                        if(line.equals("Bye."))
                            break;

                        String received = line;
                        String split[]=received.split(" ");


                        if(split[0].equals("Student"))
                        {
                            facultate.add(new Student(split[1],split[2],Integer.parseInt(split[3]),split[4],Integer.parseInt(split[5])));
                        }
                        if(split[0].equals("Profesor")){
                            facultate.add(new Profesor(split[1],split[2],split[3],Integer.parseInt(split[4]),split[5]));
                        }
                    }
                    Collections.sort(facultate);
                    for(Human h:facultate){
                        System.out.println(h.toString());
                    }

                    String text = stdIn.readLine();
                    System.out.println(text);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}