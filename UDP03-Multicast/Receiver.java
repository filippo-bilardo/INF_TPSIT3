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
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class Receiver {

    private static final String RECEIVER_IP = "127.0.0.1";
    private static final String MULTICAST_IP = "230.0.0.1";
    private static final int MULTICAST_PORT = 19876;

    public static void main(String[] args) {
        try 
        {
            // Creo il MulticastSocket per lo scambio dei dati con il client
            MulticastSocket socket = new MulticastSocket(MULTICAST_PORT);
            // Ottengo l'indirizzo IP del gruppo di multicast
            InetAddress group = InetAddress.getByName(MULTICAST_IP);
            // Ottengo l'interfaccia di rete associata all'indirizzo IP del receiver
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getByName(RECEIVER_IP));
            // Ottengo l'indirizzo socket di multicast del gruppo
            InetSocketAddress groupAddress = new InetSocketAddress(group, MULTICAST_PORT);
            // Mi unisco al gruppo di multicast utilizzando l'interfaccia di rete
            socket.joinGroup(groupAddress, networkInterface);

            // Mi preparo alla ricezione dei dati
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            System.out.println("Receiver in ascolto. Ctrl+C per terminare.");
            
            // Ricevo il DatagramPacket dal client e lo stampo a schermo
            String message = "";
            while (!message.equals("bye")) {
                socket.receive(packet);
                message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Messaggio ricevuto: " + message);
            }

            // Fine della comunicazione
            socket.leaveGroup(groupAddress, networkInterface);
            socket.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
