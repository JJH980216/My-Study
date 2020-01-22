import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	public static void main(String[] args) {
	    try {
	    	Socket socket = new Socket("localhost",9998);
	        ClientSend sclient = new ClientSend(socket);
	        ClientReceive rclient = new ClientReceive(socket);	  
	        sclient.start();
	        rclient.start();
	    }catch(IOException e) {
	    	 e.printStackTrace();
	    }
	}

}
