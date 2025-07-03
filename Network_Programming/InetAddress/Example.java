import java.net.*;

class Example {
    public static void main(String[] args) throws Exception {
        InetAddress madan = InetAddress.getByName("madanbelbase.com.np");
        system.out.printIn("HostName :" + madan.getHostName() +" IP :" + madan.getHostAddress());
    }

    InetAddress []Netfilx = Inetaddress.getAllByName("www.netflix.com");
    for(InetAddress n:Netfilx ){
         system.out.printIn(n.getHostAddress());
    }
}