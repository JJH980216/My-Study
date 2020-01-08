package CUSTOMERS;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer_Management {
	int customerid = 0;
	Scanner sc = new Scanner(System.in);

	void ui() {
		System.out.println("    <UI>    ");
		System.out.println("0.�� ���");
		System.out.println("1.ȸ������");
		System.out.println("2.����������");
		System.out.println("3.������Ʈ��ȸ");
		System.out.println("4.������Ʈ����");
		System.out.println("5.�� ����");
		System.out.println("6.���α׷� ����");
	}

	// ��ã�� �Լ�
	Customer findcustomer(ArrayList<Customer> customerlist) {
		System.out.print("�� ID �� �Է��ϼ���:");
		int userid = sc.nextInt();
		for (int i = 0; i < customerlist.size(); i++) {
			if (userid == (customerlist.get(i)).getId())
				;
			return customerlist.get(i);
		}
		System.out.println("�ش���� ���������ʽ��ϴ�.");
		return null;
	}

	// �α����Լ�
	boolean login(ArrayList<Customer> customerlist) {
		System.out.println("   <�α��� â>   ");
		System.out.print("ID:");
		int id = sc.nextInt();
		System.out.print("passward:");
		int passward = sc.nextInt();
		if (customerlist.size() != 0) {
			for (int i = 0; i < customerlist.size(); i++) {
				if (id == (customerlist.get(i)).getId() && passward == (customerlist.get(i)).getPassward())
				return true;
			}
		}
		return false;
	}

	// ȸ�������Լ�
	void signup(ArrayList<Customer> customerlist) {
		Customer cm = new Customer();// ����ü����
		customerlist.add(cm);// Arraylist�� ����ü ���
		cm.setId(customerid);
		cm.setUserpoint(0);
		System.out.println("   <ȸ������>   ");
		System.out.print("�̸��� �Է��ϼ���:");
		cm.setUsername(sc.next());
		System.out.print("������ �Է��ϼ��� ��/�� :");
		cm.setUsergender(sc.next());
		System.out.print("passward�� �����ϼ���:");
		cm.setPassward(sc.nextInt());
		System.out.println("������ID��" + customerid + "�Դϴ�.");
		customerid++;
	}

	// �����������Լ�
	void changeinformation(ArrayList<Customer> customerlist) {
		boolean check = login(customerlist);
		String input = null;
		if (check == true) {
			System.out.println("   <����������>   ");
			Customer point = findcustomer(customerlist);
			System.out.println("������ ������ �Է��ϼ��� : �̸�/����/��й�ȣ");
			input = sc.next();
			if (input.equals("�̸�")) {
				System.out.print("������ �̸��� �Է��ϼ���:");
				point.setUsername(sc.next());
			} else if (input.equals("����")) {
				System.out.print("������ ������ �Է��ϼ���:");
				point.setUsergender(sc.next());
			} else if (input.equals("��й�ȣ")) {
				System.out.print("������ ��й�ȣ�� �Է��ϼ���:");
				point.setPassward(sc.nextInt());
			} else
				System.out.println("�ܾ �߸��Է��Ͽ����ϴ�.");
		} else
			System.out.println("ID��Passward�� �߸��Ǿ����ϴ�.");
	}

	// ������Ʈ����
	void changepoint(ArrayList<Customer> customerlist, Management mg) {
		boolean check = mg.check();
		if (check == true) {
			System.out.println("   <������Ʈ ����>   ");
			Customer point = findcustomer(customerlist);
			System.out.print("������ ����Ʈ�� �Է��ϼ���:");
			point.setUserpoint(sc.nextInt());
		} else
			System.out.println("������Passward�� �߸��Ǿ����ϴ�.");
	}

	// ������ƮȮ��
	void checkpoint(ArrayList<Customer> customerlist) {
		boolean check = login(customerlist);
		if (check == true) {
			System.out.println("   <������Ʈ ��ȸ>   ");
			Customer point = findcustomer(customerlist);
			System.out.println("������ ����Ʈ��" + point.getUserpoint() + "�Դϴ�.");
		} else
			System.out.println("ID��Passward�� �߸��Ǿ����ϴ�.");
	}
	// �������Լ�
	void removecustomer(ArrayList<Customer> customerlist) {
		boolean check = login(customerlist);
		if (check == true) {
			System.out.println("   <������>   ");
			customerlist.remove(findcustomer(customerlist).getId());
		} else
			System.out.println("ID��Passward�� �߸��Ǿ����ϴ�.");
	}
}
