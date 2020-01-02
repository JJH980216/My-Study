package STUDY1;

import java.util.ArrayList;
import java.util.Scanner;

public class UserPrint {
	static int password = 12345;

	void print(ArrayList<User> a) {
		int ps = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("<관리자모드>");
		System.out.println("1.고객명단");
		System.out.println("2.비밀번호수정");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			System.out.print("비밀번호 : ");
			ps = sc.nextInt();
			if (password == ps) {
				if (a.size() != 0) {
					for (int i = 0; i < a.size(); i++) {
						User p = a.get(i);
						System.out.println("-------------------------");
						System.out.println("고객이름 :" + p.getUsername());
						System.out.println("고객성별 :" + p.getUsergender());
						System.out.println("고객 휴대전화번호:" + p.getPhone_number());
						System.out.println("고객ID :" + p.getId());
						System.out.println("고객포인트 :" + p.getPoint());
						System.out.println("-------------------------");
					}
				}
				else System.out.println("고객명단이 비어있습니다.");
			} else
				System.out.println("비밀번호가 잘못되었습니다.");
			break;

		case 2:
			System.out.println("비밀번호를 입력하세요: ");
			ps = sc.nextInt();
			if (password == ps) {
				System.out.print("변경할비밀번호 :");
				password = sc.nextInt();
			} else
				System.out.println("비밀번호가 잘못되었습니다.");
			break;
		default:
			System.out.println("번호를 잘못입력하였습니다.");
			break;
		}
	}
}
