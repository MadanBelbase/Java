// create a tcp client server application where client sent a message and server response by sending the message in upper case

import java.net.*;
import java.io.*;

class TcpServer {
    public static void main(String[] args)  throws Exception{
        ServerSocket ss = new ServerSocket(4000);
        System.out.println("server runing on 4000");
        Socket s = ss.accept();
         System.out.println("client is conncet");
         DataInputStream dis = new DataInputStream(s.getInputStream());
         DataOutputStream dos = new DataOutputStream(s.getOutputStream());
         String msg = dis.readUTF();
         System.out.println("client msg is "+ msg);
         dos.writeUTF(msg.toUpperCase());
         dos.close();
         dis.close();
         s.close();
         ss.close();



    }
}