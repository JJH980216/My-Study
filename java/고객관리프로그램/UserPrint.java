package STUDY1;

import java.util.ArrayList;
import java.util.Scanner;

public class UserPrint {
	static int password = 12345;

	void print(ArrayList<User> a) {
		int ps = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("<�����ڸ��>");
		System.out.println("1.�����");
		System.out.println("2.��й�ȣ����");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			System.out.print("��й�ȣ : ");
			ps = sc.nextInt();
			if (password == ps) {
				if (a.size() != 0) {
					for (int i = 0; i < a.size(); i++) {
						User p = a.get(i);
						System.out.println("-------------------------");
						System.out.println("���̸� :" + p.getUsername());
						System.out.println("������ :" + p.getUsergender());
						System.out.println("�� �޴���ȭ��ȣ:" + p.getPhone_number());
						System.out.println("��ID :" + p.getId());
						System.out.println("������Ʈ :" + p.getPoint());
						System.out.println("-------------------------");
					}
				}
				else System.out.println("������� ����ֽ��ϴ�.");
			} else
				System.out.println("��й�ȣ�� �߸��Ǿ����ϴ�.");
			break;

		case 2:
			System.out.println("��й�ȣ�� �Է��ϼ���: ");
			ps = sc.nextInt();
			if (password == ps) {
				System.out.print("�����Һ�й�ȣ :");
				password = sc.nextInt();
			} else
				System.out.println("��й�ȣ�� �߸��Ǿ����ϴ�.");
			break;
		default:
			System.out.println("��ȣ�� �߸��Է��Ͽ����ϴ�.");
			break;
		}
	}
}
