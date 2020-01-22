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
		 System.out.print("������>>");
		 String outputMessage = sc.nextLine();
		 out.write(outputMessage + "\n");//Ű���忡�� ���� ���ڿ� ����
		 out.flush(); //out��Ʈ�����ۿ� ���� �ִ� ���ڿ� ����.
		   }
		 }
		 catch(IOException e){
			 e.printStackTrace();
		 }
	 }
}
