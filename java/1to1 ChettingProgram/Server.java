import java.io.*;
import java.net.*;
import java.util.*;


public class Server  {
	public static void main(String[] args) {
	     ServerSocket listener= null;
	     Socket socket = null;
	     Scanner sc = new Scanner(System.in);
	     try {
	    	 listener = new ServerSocket(9998); //서버소켓생성.
	    	 socket = listener.accept();
	    	 System.out.println("연결되었습니다.");
	    	 ServerSend sthread = new ServerSend(socket , listener);
	    	 ServerReceive rthread = new ServerReceive(socket , listener);
	    	 sthread.start();
	    	 rthread.start();
	    	 }
	     catch(IOException e) {
	    	 e.printStackTrace();
	     }
	}

}
