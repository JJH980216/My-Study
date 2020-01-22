import java.io.*;
import java.net.*;
import java.util.*;

public class ClientSend extends Thread{
	    private Socket socket;
	    Scanner sc = new Scanner(System.in);
	    
	    public ClientSend(Socket socket) {
	    	this.socket = socket;
	    }
	    
	    synchronized public void run() {
	       try {
	    	   BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	    	   while(true) {
	    		   System.out.print("º¸³»±â>>");
		    	   String outputMessage = sc.nextLine();
		    	   if(outputMessage.contentEquals("bye")){
		    		    out.write(outputMessage + "\n");
		    		    out.flush();
		    		    break;
		    		}
		    	   out.write(outputMessage + "\n");
		    	   out.flush();
	     	  }
	      }catch(IOException e){
	    
	      }
	    }
}
