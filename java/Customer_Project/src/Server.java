import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.*;

public class Server {
	private final static int SERVER_PORT = 4000;

	public static void main(String args[]) {
		ServerSocket serverSocket; // Client의 접속을 기다리는 역활을 함
		Socket socket; // Client와 데이터 송수신 역활을 함
		ObjectInputStream objectInputStream; // Class의 객체를 읽어올때 사용
		PrintWriter printWriter; // 값을 전달할때 사용
		ArrayList<Customer> customerlist = new ArrayList<Customer>();
		int mode = 1;
		String managementid ="777";
		String managementpassward ="111";
		try {
			// 서버 소켓 생성
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("서버프로그램 시작");
			socket = serverSocket.accept();
			System.out.println("연결되었습니다.");
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			while (true) {

				Customer cm = (Customer) objectInputStream.readObject();
				// readObject는 object 객체로 불러오기 때문에 형변화해야 합니다.
				mode = cm.getMode();
				if (mode == 0) {
					printWriter.write(managementid + "\n");
					printWriter.flush();
					printWriter.write(managementpassward + "\n");
					printWriter.flush();
					Customer cmm = (Customer) objectInputStream.readObject();
					if (cmm.getLogin() == true) {
						for (int i = 0; i < customerlist.size(); i++) {
							printWriter.write(customerlist.get(i).getUsername() + "   ");
						}
						printWriter.write("\r\n");
						printWriter.flush();
						System.out.println("고객명단을 보냈습니다.");
					}
					else  {
						printWriter.write("아이디와비밀번호가 잘못되었습니다.\r\n");
						printWriter.flush();
						System.out.println("잘못된 경로로 관리자 접근이 발생하였습니다.");
					}
				} else if (mode == 1) {
					customerlist.add(cm);
					System.out.println("저장된객체: " + cm.getUsername());
					printWriter.write("서버에 고객정보를 저장하였습니다.\r\n");
					printWriter.flush();
				} else if (mode == 2) {
					for (int i = 0; i < customerlist.size(); i++) {
						if (cm.getID() == (customerlist.get(i)).getID()) {
							printWriter.write((customerlist.get(i)).getUserpoint() + "\r\n");
							printWriter.flush();
							System.out.println("회원님의 포인트정보를 전송하였습니다.");
						}
					}
				} else if (mode == 3) {
					for (int i = 0; i < customerlist.size(); i++) {
						if (cm.getID() == (customerlist.get(i)).getID()) {
							(customerlist.get(i)).setUserpoint(cm.getUserpoint());
							printWriter.write("포인트 변경을 완료하였습니다.\r\n");
							printWriter.flush();
							System.out.println("회원님의 포인트정보를 변경하였습니다.");
						}
					}
				} else if (mode == 4) {
					for (int i = 0; i < customerlist.size(); i++) {
						if (cm.getID() == (customerlist.get(i)).getID()) {
							customerlist.remove(i);
							printWriter.write("포인트 변경을 완료하였습니다.\r\n");
							printWriter.flush();
							System.out.println("회원님의 포인트정보를 변경하였습니다.");
						}
					}
				} else if (mode == 5) {
					printWriter.close();
					socket.close();
					System.out.println("클라이언트와의 연결이끊겼습니다.");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}