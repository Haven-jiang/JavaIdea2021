import com.sun.tools.javac.Main;

import java.io.*;
import java.net.Socket;
public class clientSocket{
    public void start(){
        try{
            Socket chatSocket = new Socket("120.26.87.64", 1456);

            InputStreamReader streamReader = new InputStreamReader(chatSocket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());

            String advice = reader.readLine();
            reader.close();

            System.out.println(advice);

            writer.println("message to send");
            writer.print("another message");
            chatSocket.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        new clientSocket().start();
    }
}
