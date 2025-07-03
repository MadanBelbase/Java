// create a  tcp client server application in java  where client sends a string to server and server returns  whether the string is a palindrome or not

import java.net.*;
import java.io.*;
import java.util.Scanner;

class Pserver {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(4000);
        System.out.println("Server is running and waiting for client connection...");
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        System.out.println("Client connected: " + s.getInetAddress());
        String msg = dis.readUTF();
        System.out.println("Received from client: " + msg);
        String Check = isPalindrome(msg);
        dos.writeUTF(Check);
        dos.close();
        dis.close();
        s.close();
        ss.close();
    }
    public static String isPalindrome(String str) {
         String reverse = "";
         for(int i = str.length() - 1; i >= 0; i--) {
             reverse += str.charAt(i);
         }
         if(reverse.equalsIgnoreCase(str)) {
             return "The string is a palindrome.";
         } else {
             return "The string is not a palindrome.";
         }
    }
}