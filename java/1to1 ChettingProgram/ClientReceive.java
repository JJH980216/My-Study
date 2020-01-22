import java.io.*;
import java.net.*;
import java.util.*;

public class ClientReceive extends Thread{
	  private Socket socket;
	  Scanner sc = new Scanner(System.in);
	  
	  public ClientReceive(Socket socket) {
	    	this.socket = socket;
	    }
	  
	  synchronized public void run() {
	    try {
		     while(true) {
		     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		     String inputMessage = in.readLine();
  	         System.out.println("¼­¹ö : " + inputMessage);
		     }
	    }catch(IOException e) {
		    e.printStackTrace();
	     }
	}		
}
