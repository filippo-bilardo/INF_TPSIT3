package network;

import java.net.*;
import java.io.IOException;

public class MainClient {
	
    public static void main(String[] args) throws UnknownHostException, IOException {
    	
    	EchoClient clt= new EchoClient("127.0.0.1", 12345);
    	clt.run();
    }
}