import java.io.*;
import java.net.*;


public class MutlithreadedReverseEchoServer extends Thread {

    Socket si;

    public MutlithreadedReverseEchoServer(Socket s){
        this.si = s;
    }
    public void run(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(si.getInputStream()));
            PrintStream ps = new PrintStream(si.getOutputStream());
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
            si.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(2000);
        Socket stk;
        int count = 1;
        do{
            stk = ss.accept();
            System.out.println("Client " + count++ + " connected");
            MutlithreadedReverseEchoServer mres = new MutlithreadedReverseEchoServer(stk);
            mres.start();
        }while(true);

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
