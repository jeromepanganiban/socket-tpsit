import java.net.*;
import java.io.*;

public class EchoClient
{
   public static void main (String[] args) throws Exception{ 
        EchoClient.send(args[0]);
   }
   static void send(String msg) throws Exception{     
       Socket s = new Socket("127.0.0.1", 8888);
       //il client è connesso e sono sicuro
       InputStream is = s.getInputStream(); //leggo dal client
       OutputStream os = s.getOutputStream(); //scrivo sul client
       //filtraggio
       BufferedReader in = new BufferedReader(new InputStreamReader(is));  //in
       PrintWriter out = new PrintWriter(os, true); //out
       out.println(msg);
       out.flush();
       String servermess = in.readLine();
       System.out.println(servermess);
       in.close();
       out.close();
       s.close();
   }
}
