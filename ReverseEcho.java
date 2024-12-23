
import java.util.*;
import java.net.*;
import java.nio.Buffer;
import java.io.*;

public class ReverseEcho{
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(2000);
        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.flush();  // Ensures the message is sent immediately
        String msg;
        StringBuilder sb;
        do{
            msg = br.readLine();
            System.out.println("Client: " + msg);
            sb = new StringBuilder(msg);
            msg = sb.reverse().toString();
            ps.println(msg);
            ps.flush();

        }while(!msg.equals("dne"));
        s.close();
        ss.close();
    }
}

class ReverseEchoClient{
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 2000);
        BufferedReader keyb = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.flush();  // Ensures the message is sent immediately
        String msg;
        do{
            msg = keyb.readLine();
            ps.println(msg);
            msg = br.readLine();
            System.out.println("Server: " + msg);
        }while(!msg.equals("dne"));
        s.close();
    }
}