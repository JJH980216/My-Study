import java.util.Scanner;

public class Client_Management {
    Scanner sc = new Scanner(System.in);
    private int Customer_id = 0;
   
	void ui() {
		System.out.println("    <UI>    ");
		System.out.println("0.��������");
		System.out.println("1.ȸ������");
		System.out.println("2.������Ʈ��ȸ");
		System.out.println("3.������Ʈ����");
		System.out.println("4.�� ����");
		System.out.println("5.���α׷� ����");
	}
	Customer signup(int mode) {
		Customer cm = new Customer();
		cm.setMode(mode);
		cm.setUserpoint("0");
		cm.setLogin(false);
		System.out.println("   <ȸ������>   ");
		System.out.print("�̸��� �Է��ϼ���:");
		cm.setUsername(sc.next());
		System.out.print("������ �Է��ϼ��� ��/�� :");
		cm.setUsergender(sc.next());
		System.out.print("passward�� �����ϼ���:");
		cm.setPassward(sc.next());
	    cm.setID(Customer_id);
		System.out.println("������ID��" + Customer_id++ + "�Դϴ�.");
		return cm;
	}
}
