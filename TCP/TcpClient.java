// create a tcp client server application where client sent a message and server response by sending the message in upper case

import java.net.*;
import java.io.*;

class TcpClient {
    public static void main(String[] args)  throws Exception{
        Socket s = new Socket("localhost",4000);
         DataInputStream dis = new DataInputStream(s.getInputStream());
         DataOutputStream dos = new DataOutputStream(s.getOutputStream());
         dos.writeUTF("madan");
        String reply = dis.readUTF();
        System.out.println("sever msg is :"+ reply);
         dos.close();
         dis.close();
         s.close();
        



    }
}