/**
 * @(#)Receiver.java
 * 
 * TPSIT_3/UDPMulticast/Receiver application
 * 
 * @author Filippo Bilardo
 * @version 1.00 11/11/2023
 */
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receiver {

    private static final String MULTICAST_IP = "230.0.0.1";
    private static final int MULTICAST_PORT = 19876;

    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName(MULTICAST_IP);
            MulticastSocket socket = new MulticastSocket(MULTICAST_PORT);
            socket.joinGroup(group);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Receiver in ascolto. Ctrl+C per terminare.");
            
            String message = "";
            while (message != "bye") {
                socket.receive(packet);
                message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Messaggio ricevuto: " + message);
            }
            socket.leaveGroup(group);
            socket.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
