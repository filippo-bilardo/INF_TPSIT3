package network;

import java.io.IOException;

public class MainServer {
	
    public static void main(String[] args) throws IOException {      
    	EchoServer srv = new EchoServer(12345, 3);
    	srv.start();
    }
}