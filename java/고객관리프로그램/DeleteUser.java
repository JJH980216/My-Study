package STUDY1;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteUser {

	void delete(ArrayList<User> a) {
		Scanner sc = new Scanner(System.in);
		if (a.size() != 0) {
			System.out.println("고객번호를 입력하세요.");
			int customerid = sc.nextInt();
			for (int i = 0; i < a.size(); i++) {
				User p = a.get(i);
				if (customerid == p.getId()) {
					a.remove(i);
					System.out.println("고객정보가 삭제되었습니다.");
					break;
				} else if (customerid != p.getId() && i == a.size() - 1)
					System.out.println("해당 고객번호가 존재하지 않습니다.");

			}
		}
		else System.out.println("고객명단이 비어있습니다.");
	}
}
