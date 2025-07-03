import java.net.*;
import java.io.*;

class Connection {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://madanbelbase.com.np");
        URLConnection cn = url.openConnection();
        InputStream in = cn.getInputStream();
        int data;
        while ((data = in.read()) != -1) {
            System.out.print((char) data);
        }
        in.close();
    }
}
