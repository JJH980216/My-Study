package STUDY1;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteUser {

	void delete(ArrayList<User> a) {
		Scanner sc = new Scanner(System.in);
		if (a.size() != 0) {
			System.out.println("������ȣ�� �Է��ϼ���.");
			int customerid = sc.nextInt();
			for (int i = 0; i < a.size(); i++) {
				User p = a.get(i);
				if (customerid == p.getId()) {
					a.remove(i);
					System.out.println("���������� �����Ǿ����ϴ�.");
					break;
				} else if (customerid != p.getId() && i == a.size() - 1)
					System.out.println("�ش� ������ȣ�� �������� �ʽ��ϴ�.");

			}
		}
		else System.out.println("���������� ����ֽ��ϴ�.");
	}
}