import java.net.*;
import java.io.*;
class ClassClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 4000);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        System.out.println("Client connected: " + s.getInetAddress());
        dos.writeUTF("Hello Server, this is Client!");
        String msg = dis.readUTF();
        System.out.println("Reply: " + msg);
        dos.close();
        dis.close();
        s.close();
    }
}