import java.net.*;

class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6000);

        byte[] rBuffer = new byte[1024];
        DatagramPacket rPacket = new DatagramPacket(rBuffer, rBuffer.length);
        socket.receive(rPacket);
        String msg = new String(rPacket.getData(), 0, rPacket.getLength());
        System.out.println("Client Msg: " + msg);

        byte[] snBuffer = msg.toUpperCase().getBytes();
        InetAddress clientIp = rPacket.getAddress();
        int clientPort = rPacket.getPort();
        DatagramPacket snPacket = new DatagramPacket(snBuffer, snBuffer.length, clientIp, clientPort);
        socket.send(snPacket);
        socket.close();
    }
}

