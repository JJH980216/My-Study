package STUDY1;

import java.util.ArrayList;
import java.util.Scanner;

public class ChangeInformation  { 
	
	void change(ArrayList<User> a) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요:");
		String name = sc.next();
		for(int i=0;i<a.size();i++) 
		{
			User p = a.get(i);
			if(name.contentEquals(p.getUsername()))
			{
				 System.out.println("수정할 고객 정보를 입력하세요(이름/성별/휴대폰번호).");
				 String word = sc.next();
				 if (word.contentEquals("이름")) {
					System.out.println("수정할 이름을 입력하세요.");
					p.setUsername(sc.next());
					break;
				   }
				 else if(word.contentEquals("성별")) {
					System.out.println("수정할 성별을 입력하세요.");
					p.setUsergender(sc.next());
					break;
			       }
				 else if (word.contentEquals("휴대폰번호")) {
					System.out.println("수정할 휴대폰번호를 입력하세요.");
					p.setPhone_number(sc.nextInt());
					break;
				   }
				 else  System.out.println("단어를 잘못 입력하였습니다.");				
			}	
			else if(name.contentEquals(p.getUsername())==false&&i==a.size()-1)
				System.out.println("해당고객이 존재하지않습니다.");
			
		}
		
	}
}
