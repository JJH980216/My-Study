package STUDY1;

import java.util.ArrayList;
import java.util.Scanner;

public class ChangeInformation  { 
	
	void change(ArrayList<User> a) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���:");
		String name = sc.next();
		for(int i=0;i<a.size();i++) 
		{
			User p = a.get(i);
			if(name.contentEquals(p.getUsername()))
			{
				 System.out.println("������ �� ������ �Է��ϼ���(�̸�/����/�޴�����ȣ).");
				 String word = sc.next();
				 if (word.contentEquals("�̸�")) {
					System.out.println("������ �̸��� �Է��ϼ���.");
					p.setUsername(sc.next());
					break;
				   }
				 else if(word.contentEquals("����")) {
					System.out.println("������ ������ �Է��ϼ���.");
					p.setUsergender(sc.next());
					break;
			       }
				 else if (word.contentEquals("�޴�����ȣ")) {
					System.out.println("������ �޴�����ȣ�� �Է��ϼ���.");
					p.setPhone_number(sc.nextInt());
					break;
				   }
				 else  System.out.println("�ܾ �߸� �Է��Ͽ����ϴ�.");				
			}	
			else if(name.contentEquals(p.getUsername())==false&&i==a.size()-1)
				System.out.println("�ش���� ���������ʽ��ϴ�.");
			
		}
		
	}
}
