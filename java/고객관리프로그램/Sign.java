package STUDY1;

import java.util.Scanner;

public class Sign {
	    static int key=0;
  	    User point =new User(key);
  	   
	    void signup() {
	    Scanner sc = new Scanner(System.in);
	    point.setPoint(0);
	    System.out.println("�ڵ�����ȣ�� �Է��ϼ��� : ");
	    point.setPhone_number(sc.nextInt());
	    System.out.println("�̸��� �Է��ϼ��� : ");
	    point.setUsername(sc.next());
	    System.out.println("������ �Է��ϼ��� ��/�� : ");
	    point.setUsergender(sc.next());
	    key++;
	    
	 }
}
