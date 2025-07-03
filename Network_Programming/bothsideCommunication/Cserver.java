// create a tcp server that can communicated with each other until client sends "bye" message

import java.net.*;
import java.io.*;
import java.util.*;

class Cserver {
    public static void main(String[] args )throws Exception {
        Scanner scan = new Scanner(System.in);
        ServerSocket ss = new ServerSocket(4000);
        Socket s = ss.accept();
        System.out.println("Server is running " + s.getPort());
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        while(true) {
            String clientMsg = dis.readUTF();
        
            // System.out.println("Type your message: ");
            // String serverMsg = scan.nextLine();
            dos.writeUTF(clientMsg.toUpperCase());
            if(clientMsg.equalsIgnoreCase("bye")) {
                break;
            }
        }
        dos.close();
        dis.close();
        s.close();
        ss.close();
    }
}