import java.net.*;
import java.io.*;
class Pclient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 4000);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        System.out.println("Client connected: " + s.getInetAddress());
        dos.writeUTF("papa");
        String msg = dis.readUTF();
        System.out.println("Reply: " + msg);
        dos.close();
        dis.close();
        s.close();
    }
}