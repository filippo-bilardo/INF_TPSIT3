package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler extends ClientServer {
	
    private Socket socket;
    private int clnt_port;
    private BufferedReader clnt_br = new BufferedReader(new InputStreamReader(System.in));

    public ClientHandler(Socket socket) {
        this.socket = socket;
        this.clnt_port = socket.getPort();
    }

    public void run() {
        try {
        	writeToSocket(socket, "Ciao, come stai? \n");
    		String clntMsg;
			String srvMsg;

    		do {
    			clntMsg = readFromSocket(socket);

    			if (clntMsg.toLowerCase().equals("goodbye")) {
    				writeToSocket(socket, clntMsg);
    				System.out.println("CLIENT "+clnt_port+" "+ clntMsg);
    			} else {
    				System.out.println("CLIENT "+clnt_port+" "+ clntMsg);

    				srvMsg = clnt_br.readLine();
    				writeToSocket(socket, srvMsg + "\n");
    			}
    		} while (!clntMsg.toLowerCase().equals("goodbye"));
    		
			socket.close();
			System.out.println("Connessione chiusa! \n");
             
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
