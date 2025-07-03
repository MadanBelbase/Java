 import java.net.*;
import java.io.*;
import java.util.*;

class Cclient {
     public static void main(String[] args )throws Exception {
        Scanner scan = new Scanner(System.in);
        Socket s = new Socket("localhost", 4000);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        while(true){
            System.out.println("Type your message: ");
            String clientMsg = scan.nextLine();
            dos.writeUTF(clientMsg);
            String serverMsg = dis.readUTF();
            System.out.println("Reply from server: " + serverMsg);
            if(clientMsg.equalsIgnoreCase("bye")) {
                System.out.println("Server disconnected.");
                break;
            }
        }
        dos.close();
        dis.close();
        s.close();
        scan.close();
    }  

}