package CUSTOMERS;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer_Management {
	int customerid = 0;
	Scanner sc = new Scanner(System.in);

	void ui() {
		System.out.println("    <UI>    ");
		System.out.println("0.고객 명단");
		System.out.println("1.회원가입");
		System.out.println("2.고객정보변경");
		System.out.println("3.고객포인트조회");
		System.out.println("4.고객포인트변경");
		System.out.println("5.고객 삭제");
		System.out.println("6.프로그램 종료");
	}

	// 고객찾기 함수
	Customer findcustomer(ArrayList<Customer> customerlist) {
		System.out.print("고객 ID 를 입력하세요:");
		int userid = sc.nextInt();
		for (int i = 0; i < customerlist.size(); i++) {
			if (userid == (customerlist.get(i)).getId())
				;
			return customerlist.get(i);
		}
		System.out.println("해당고객이 존재하지않습니다.");
		return null;
	}

	// 로그인함수
	boolean login(ArrayList<Customer> customerlist) {
		System.out.println("   <로그인 창>   ");
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

	// 회원가입함수
	void signup(ArrayList<Customer> customerlist) {
		Customer cm = new Customer();// 고객객체생성
		customerlist.add(cm);// Arraylist에 고객객체 담기
		cm.setId(customerid);
		cm.setUserpoint(0);
		System.out.println("   <회원가입>   ");
		System.out.print("이름을 입력하세요:");
		cm.setUsername(sc.next());
		System.out.print("성별을 입력하세요 남/여 :");
		cm.setUsergender(sc.next());
		System.out.print("passward를 설정하세요:");
		cm.setPassward(sc.nextInt());
		System.out.println("고객님의ID는" + customerid + "입니다.");
		customerid++;
	}

	// 고객정보변경함수
	void changeinformation(ArrayList<Customer> customerlist) {
		boolean check = login(customerlist);
		String input = null;
		if (check == true) {
			System.out.println("   <고객정보변경>   ");
			Customer point = findcustomer(customerlist);
			System.out.println("변경할 정보를 입력하세요 : 이름/성별/비밀번호");
			input = sc.next();
			if (input.equals("이름")) {
				System.out.print("변경할 이름을 입력하세요:");
				point.setUsername(sc.next());
			} else if (input.equals("성별")) {
				System.out.print("변경할 성별을 입력하세요:");
				point.setUsergender(sc.next());
			} else if (input.equals("비밀번호")) {
				System.out.print("변경할 비밀번호를 입력하세요:");
				point.setPassward(sc.nextInt());
			} else
				System.out.println("단어를 잘못입력하였습니다.");
		} else
			System.out.println("ID와Passward가 잘못되었습니다.");
	}

	// 고객포인트변경
	void changepoint(ArrayList<Customer> customerlist, Management mg) {
		boolean check = mg.check();
		if (check == true) {
			System.out.println("   <고객포인트 설정>   ");
			Customer point = findcustomer(customerlist);
			System.out.print("변경할 포인트를 입력하세요:");
			point.setUserpoint(sc.nextInt());
		} else
			System.out.println("관리자Passward가 잘못되었습니다.");
	}

	// 고객포인트확인
	void checkpoint(ArrayList<Customer> customerlist) {
		boolean check = login(customerlist);
		if (check == true) {
			System.out.println("   <고객포인트 조회>   ");
			Customer point = findcustomer(customerlist);
			System.out.println("고객님의 포인트는" + point.getUserpoint() + "입니다.");
		} else
			System.out.println("ID와Passward가 잘못되었습니다.");
	}
	// 고객삭제함수
	void removecustomer(ArrayList<Customer> customerlist) {
		boolean check = login(customerlist);
		if (check == true) {
			System.out.println("   <고객삭제>   ");
			customerlist.remove(findcustomer(customerlist).getId());
		} else
			System.out.println("ID와Passward가 잘못되었습니다.");
	}
}
