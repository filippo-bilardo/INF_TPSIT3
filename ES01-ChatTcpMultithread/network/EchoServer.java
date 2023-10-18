package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer extends Thread {
	
    private ServerSocket port;
    
    public EchoServer(int portNum, int nBacklog) throws IOException {
        port = new ServerSocket(portNum, nBacklog);
    }
    
    public void start() {
        System.out.println("SERVER AVVIATO!!!");
        while (true) {
            try {
                Socket socket = port.accept();
                System.out.println("Accettata la connessione da " + socket.getInetAddress() + " " + socket.getPort());
                
                ClientHandler clnt = new ClientHandler(socket);
                clnt.start();
				
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
    