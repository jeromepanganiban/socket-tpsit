import java.net.*;
import java.io.*;
 
public class EchoServer
{
   public static void main(String[] args) throws Exception{
       ServerSocket ss = new ServerSocket(8888);
       Socket s = ss.accept();
       //il client è connesso e sono sicuro
       InputStream is = s.getInputStream(); //leggo dal client
       OutputStream os = s.getOutputStream(); //scrivo sul client
       //filtraggio
       BufferedReader in = new BufferedReader(new InputStreamReader(is));  //in
       PrintWriter out = new PrintWriter(os, true); //out
       String msg = in.readLine();
       System.out.println(msg); //dal client
       out.println(msg);
       in.close();
       out.close();
       s.close();
       ss.close();
   }
}
