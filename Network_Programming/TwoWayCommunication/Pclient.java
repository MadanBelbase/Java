import java.net.*;

class Pclient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        String msg = "Hello Dear!!";
        byte[] sendBuffer = msg.getBytes();
        InetAddress serverIp = InetAddress.getLocalHost();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverIp, 6000);
        socket.send(sendPacket);

        byte[] rxBuffer = new byte[1024];
        DatagramPacket rxPacket = new DatagramPacket(rxBuffer, rxBuffer.length);
        socket.receive(rxPacket);
        String data = new String(rxPacket.getData(), rxPacket.getLength());
        System.out.println("Received from server: " + data);
        socket.close();
    }
}
