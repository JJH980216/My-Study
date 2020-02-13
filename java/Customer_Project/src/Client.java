import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	private final static int SERVER_PORT = 4000;
	public static void main(String[] args) {
		int mode = 1;
		Scanner sc = new Scanner(System.in);
		PrintWriter printwriter;
		try {
			Socket socket = new Socket("localhost", SERVER_PORT);
			Client_Management menage = new Client_Management();
			// ObjectOutputStream()을 이용하여 직렬화를 합니다.
			// socket 통신을 하기 때문에 socket의 stream을 가져옵니다.
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			// Server로부터의 응답을 받기 위한 부분
			// socket 통신을 하기 때문에 socket의 stream을 가져옵니다.
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				do {
					menage.ui();
					System.out.print("번호를 입력하세요:");
					mode = sc.nextInt();
				} while (mode < 0 || mode > 6);
				if(mode==0) {
					Customer cm = new Customer();
				    cm.setMode(0);
				    objectOutputStream.writeObject(cm); // 데이터 직렬화
					objectOutputStream.flush();
				    String managementid = bufferReader.readLine();
				    String managementpassward = bufferReader.readLine();
				    System.out.print("관리자ID :");
				    String id=sc.next();
				    System.out.print("관리자 password :");
				    String passward = sc.next();
				    if(managementid.equals(id)&&managementpassward.contentEquals(passward)) {
				    	System.out.println("관리자 로그인 성공");
				    	cm.setLogin(true);
				    	objectOutputStream.reset();
				    	objectOutputStream.writeObject(cm); // 데이터 직렬화
						objectOutputStream.flush();
						String returnMessage = bufferReader.readLine();
						System.out.println("   <고객명단>   \n"+ returnMessage);
				    }
				    else {
				    	cm.setLogin(false);
				    	objectOutputStream.reset();
				    	objectOutputStream.writeObject(cm); // 데이터 직렬화
						objectOutputStream.flush();
						String returnMessage = bufferReader.readLine();
						System.out.println(returnMessage);
				    }
			
				    	
				}
				else if(mode==1) {
					Customer cmm= menage.signup(mode);
					objectOutputStream.writeObject(cmm); // 데이터 직렬화
					objectOutputStream.flush(); // 직렬화된 데이터 전달
                    System.out.println("회원정보를 전송하였습니다.");
                 // 서버로부터 메시지 받기 위한 부분
    				String returnMessage = bufferReader.readLine();
    				System.out.println(returnMessage);  				
				}
				else if(mode==2) {
					System.out.println("포인트를 조회할 고객번호를 입력하세요.");
			        int id =sc.nextInt();
			        Customer cm = new Customer();
			        cm.setMode(2);
			        cm.setID(id);		       
					objectOutputStream.writeObject(cm); // 데이터 직렬화
					objectOutputStream.flush(); // 직렬화된 데이터 전달
                    System.out.println("회원정보를 전송하였습니다.");
                    String returnMessage = bufferReader.readLine();
    				System.out.println("고객님의 포인트는 " + returnMessage+"입니다.");	
				}
				else if(mode==3) {
					System.out.println("포인트를 변경할 고객ID를 입력하세요.");
			        int id =sc.nextInt();
			        System.out.println("변경할 포인트를 입력하세요.");
			        String point = sc.next();
			        Customer cm = new Customer();
			        cm.setMode(3);
			        cm.setID(id);	
			        cm.setUserpoint(point);
			        objectOutputStream.writeObject(cm); // 데이터 직렬화
					objectOutputStream.flush(); // 직렬화된 데이터 전달
                    System.out.println("회원정보를 전송하였습니다.");
                    String returnMessage = bufferReader.readLine();
    				System.out.println( returnMessage);	
				}
				else if(mode==4) {
					System.out.println("삭제할 고객ID를 입력하세요.");
					int id =sc.nextInt();
			        System.out.println("변경할 포인트를 입력하세요.");
			        Customer cm = new Customer();
			        cm.setMode(4);
			        cm.setID(id);
			        objectOutputStream.writeObject(cm); // 데이터 직렬화
					objectOutputStream.flush(); // 직렬화된 데이터 전달
                    System.out.println("회원정보를 전송하였습니다.");
                    String returnMessage = bufferReader.readLine();
    				System.out.println( returnMessage);	
				}
				else if(mode==5) {
				Customer cm = new Customer();
			    cm.setMode(5);
			    objectOutputStream.writeObject(cm); // 데이터 직렬화
				objectOutputStream.flush(); // 직렬화된 데이터 전달
                System.out.println("서버와의 연결을 종료하겠습니다.");
				objectOutputStream.close();
				socket.close();	
				}
				
			}
		} catch (Exception e) {
			System.err.println("Usage: java Client <hostname> <port:4000>");
			e.printStackTrace();
		}
	}
}