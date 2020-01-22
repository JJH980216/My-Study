import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServerSend extends Thread {
     Scanner sc= new Scanner(System.in);
     Socket socket = null;
     ServerSocket listener= null;
     
     public ServerSend(Socket socket, ServerSocket listener) {
    	 this.socket = socket;
    	 this.listener = listener;
     }
     
	 synchronized public void run() {
		try {
		   BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
		   while(true) {
		    String inputMessage = in.readLine();
		    System.out.println("Ŭ���̾�Ʈ : " + inputMessage);
		       if(inputMessage.contentEquals("bye")) {
			    System.out.println("Ŭ���̾�Ʈ���� ������ �����մϴ�.");
			    break;//������ ����.
		       }
		   }
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}
	
	
}
