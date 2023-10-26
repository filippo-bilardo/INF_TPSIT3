import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpChatClient 
{
    public static void main(String[] args) 
    {
        DatagramSocket clntSocket = null;
        Scanner scanner = new Scanner(System.in);

        try 
        {
            clntSocket = new DatagramSocket();
            InetAddress srvAddr = InetAddress.getByName("localhost");
            int srvPort = 9876;

            while (true) 
            {
				//Leggo da tastiera una stringa e la invio al server
				System.out.print("> "); //prompt
				String sndMsg = scanner.nextLine();
				byte[] sndData = sndMsg.getBytes();
				DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length, srvAddr, srvPort); 
				clntSocket.send(sndPacket);
				
				//Fine della comunicazione
				if(sndMsg.equals("bye")) break;

				//Attendo la ricezione del DatagramPacket dal server 
				byte[] rcvData = new byte[1024];
				DatagramPacket rcvPacket = new DatagramPacket(rcvData, rcvData.length);																									
				clntSocket.receive(rcvPacket);
				//Visualizzo a schermo i dati del pacchetto ricevuto
				String rcvMsg = new String(rcvPacket.getData(), 0, rcvPacket.getLength());
				System.out.print("[" + rcvPacket.getAddress().getHostName() + ":" + rcvPacket.getPort() + "] ");
				System.out.println(rcvMsg);

				//Fine della comunicazione
				if(rcvMsg.equals("bye")) break;
            }
            scanner.close();
            clntSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (clntSocket != null && !clntSocket.isClosed()) {
                clntSocket.close();
            }
        }
    }
}
