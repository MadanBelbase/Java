import java.net.*;
import java.io.*;

class ClassServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(4000);
        System.out.println("Server is running and waiting for client connection...");
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        System.out.println("Client connected: " + s.getInetAddress());
        String msg = dis.readUTF();
        dos.writeUTF(msg.toUpperCase());
        dos.close();
        dis.close();
        s.close();
        ss.close();
    }
}


