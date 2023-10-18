package network;

import java.net.*;
import java.io.*;

public class EchoClient extends ClientServer {

	protected Socket socket;
	public BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public EchoClient(String url, int port) throws UnknownHostException, IOException {// COSTRUTTORE
		socket = new Socket(url, port);
		System.out.println("CLIENT: Sono connesso a " + url + ": " + port);
	}

	public void run() {
		try {
			requestAService(socket);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void requestAService(Socket socket) throws IOException {
		String servStr = readFromSocket(socket);
		if (servStr.substring(0, 4).equals("Ciao")) {
			System.out.println("SERVER: " + servStr);
			String userStr = "";
			do {
				userStr = in.readLine(); 
				writeToSocket(socket, userStr + "\n");
				servStr = readFromSocket(socket);
				System.out.println("SERVER: " + servStr);
			} while (!userStr.toLowerCase().equals("goodbye"));
		}
	}
}