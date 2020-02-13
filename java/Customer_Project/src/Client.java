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
			// ObjectOutputStream()�� �̿��Ͽ� ����ȭ�� �մϴ�.
			// socket ����� �ϱ� ������ socket�� stream�� �����ɴϴ�.
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			// Server�κ����� ������ �ޱ� ���� �κ�
			// socket ����� �ϱ� ������ socket�� stream�� �����ɴϴ�.
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				do {
					menage.ui();
					System.out.print("��ȣ�� �Է��ϼ���:");
					mode = sc.nextInt();
				} while (mode < 0 || mode > 6);
				if(mode==0) {
					Customer cm = new Customer();
				    cm.setMode(0);
				    objectOutputStream.writeObject(cm); // ������ ����ȭ
					objectOutputStream.flush();
				    String managementid = bufferReader.readLine();
				    String managementpassward = bufferReader.readLine();
				    System.out.print("������ID :");
				    String id=sc.next();
				    System.out.print("������ password :");
				    String passward = sc.next();
				    if(managementid.equals(id)&&managementpassward.contentEquals(passward)) {
				    	System.out.println("������ �α��� ����");
				    	cm.setLogin(true);
				    	objectOutputStream.reset();
				    	objectOutputStream.writeObject(cm); // ������ ����ȭ
						objectOutputStream.flush();
						String returnMessage = bufferReader.readLine();
						System.out.println("   <�����>   \n"+ returnMessage);
				    }
				    else {
				    	cm.setLogin(false);
				    	objectOutputStream.reset();
				    	objectOutputStream.writeObject(cm); // ������ ����ȭ
						objectOutputStream.flush();
						String returnMessage = bufferReader.readLine();
						System.out.println(returnMessage);
				    }
			
				    	
				}
				else if(mode==1) {
					Customer cmm= menage.signup(mode);
					objectOutputStream.writeObject(cmm); // ������ ����ȭ
					objectOutputStream.flush(); // ����ȭ�� ������ ����
                    System.out.println("ȸ�������� �����Ͽ����ϴ�.");
                 // �����κ��� �޽��� �ޱ� ���� �κ�
    				String returnMessage = bufferReader.readLine();
    				System.out.println(returnMessage);  				
				}
				else if(mode==2) {
					System.out.println("����Ʈ�� ��ȸ�� ����ȣ�� �Է��ϼ���.");
			        int id =sc.nextInt();
			        Customer cm = new Customer();
			        cm.setMode(2);
			        cm.setID(id);		       
					objectOutputStream.writeObject(cm); // ������ ����ȭ
					objectOutputStream.flush(); // ����ȭ�� ������ ����
                    System.out.println("ȸ�������� �����Ͽ����ϴ�.");
                    String returnMessage = bufferReader.readLine();
    				System.out.println("������ ����Ʈ�� " + returnMessage+"�Դϴ�.");	
				}
				else if(mode==3) {
					System.out.println("����Ʈ�� ������ ��ID�� �Է��ϼ���.");
			        int id =sc.nextInt();
			        System.out.println("������ ����Ʈ�� �Է��ϼ���.");
			        String point = sc.next();
			        Customer cm = new Customer();
			        cm.setMode(3);
			        cm.setID(id);	
			        cm.setUserpoint(point);
			        objectOutputStream.writeObject(cm); // ������ ����ȭ
					objectOutputStream.flush(); // ����ȭ�� ������ ����
                    System.out.println("ȸ�������� �����Ͽ����ϴ�.");
                    String returnMessage = bufferReader.readLine();
    				System.out.println( returnMessage);	
				}
				else if(mode==4) {
					System.out.println("������ ��ID�� �Է��ϼ���.");
					int id =sc.nextInt();
			        System.out.println("������ ����Ʈ�� �Է��ϼ���.");
			        Customer cm = new Customer();
			        cm.setMode(4);
			        cm.setID(id);
			        objectOutputStream.writeObject(cm); // ������ ����ȭ
					objectOutputStream.flush(); // ����ȭ�� ������ ����
                    System.out.println("ȸ�������� �����Ͽ����ϴ�.");
                    String returnMessage = bufferReader.readLine();
    				System.out.println( returnMessage);	
				}
				else if(mode==5) {
				Customer cm = new Customer();
			    cm.setMode(5);
			    objectOutputStream.writeObject(cm); // ������ ����ȭ
				objectOutputStream.flush(); // ����ȭ�� ������ ����
                System.out.println("�������� ������ �����ϰڽ��ϴ�.");
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