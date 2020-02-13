import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.*;

public class Server {
	private final static int SERVER_PORT = 4000;

	public static void main(String args[]) {
		ServerSocket serverSocket; // Client�� ������ ��ٸ��� ��Ȱ�� ��
		Socket socket; // Client�� ������ �ۼ��� ��Ȱ�� ��
		ObjectInputStream objectInputStream; // Class�� ��ü�� �о�ö� ���
		PrintWriter printWriter; // ���� �����Ҷ� ���
		ArrayList<Customer> customerlist = new ArrayList<Customer>();
		int mode = 1;
		String managementid ="777";
		String managementpassward ="111";
		try {
			// ���� ���� ����
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("�������α׷� ����");
			socket = serverSocket.accept();
			System.out.println("����Ǿ����ϴ�.");
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			while (true) {

				Customer cm = (Customer) objectInputStream.readObject();
				// readObject�� object ��ü�� �ҷ����� ������ ����ȭ�ؾ� �մϴ�.
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
						System.out.println("������� ���½��ϴ�.");
					}
					else  {
						printWriter.write("���̵�ͺ�й�ȣ�� �߸��Ǿ����ϴ�.\r\n");
						printWriter.flush();
						System.out.println("�߸��� ��η� ������ ������ �߻��Ͽ����ϴ�.");
					}
				} else if (mode == 1) {
					customerlist.add(cm);
					System.out.println("����Ȱ�ü: " + cm.getUsername());
					printWriter.write("������ �������� �����Ͽ����ϴ�.\r\n");
					printWriter.flush();
				} else if (mode == 2) {
					for (int i = 0; i < customerlist.size(); i++) {
						if (cm.getID() == (customerlist.get(i)).getID()) {
							printWriter.write((customerlist.get(i)).getUserpoint() + "\r\n");
							printWriter.flush();
							System.out.println("ȸ������ ����Ʈ������ �����Ͽ����ϴ�.");
						}
					}
				} else if (mode == 3) {
					for (int i = 0; i < customerlist.size(); i++) {
						if (cm.getID() == (customerlist.get(i)).getID()) {
							(customerlist.get(i)).setUserpoint(cm.getUserpoint());
							printWriter.write("����Ʈ ������ �Ϸ��Ͽ����ϴ�.\r\n");
							printWriter.flush();
							System.out.println("ȸ������ ����Ʈ������ �����Ͽ����ϴ�.");
						}
					}
				} else if (mode == 4) {
					for (int i = 0; i < customerlist.size(); i++) {
						if (cm.getID() == (customerlist.get(i)).getID()) {
							customerlist.remove(i);
							printWriter.write("����Ʈ ������ �Ϸ��Ͽ����ϴ�.\r\n");
							printWriter.flush();
							System.out.println("ȸ������ ����Ʈ������ �����Ͽ����ϴ�.");
						}
					}
				} else if (mode == 5) {
					printWriter.close();
					socket.close();
					System.out.println("Ŭ���̾�Ʈ���� �����̲�����ϴ�.");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}