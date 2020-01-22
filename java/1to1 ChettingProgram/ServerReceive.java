import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServerReceive extends Thread {
     Scanner sc= new Scanner(System.in);
     Socket socket = null;
     ServerSocket listener= null;
     
     public ServerReceive(Socket socket, ServerSocket listener) {
    	 this.socket = socket;
    	 this.listener = listener;
     }
     
     synchronized public void run() {
		 try {
		 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		 while(true) {
		 System.out.print("보내기>>");
		 String outputMessage = sc.nextLine();
		 out.write(outputMessage + "\n");//키보드에서 읽은 문자열 전송
		 out.flush(); //out스트림버퍼에 남아 있는 문자열 전송.
		   }
		 }
		 catch(IOException e){
			 e.printStackTrace();
		 }
	 }
}
