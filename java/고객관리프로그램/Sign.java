package STUDY1;

import java.util.Scanner;

public class Sign {
	    static int key=0;
  	    User point =new User(key);
  	   
	    void signup() {
	    Scanner sc = new Scanner(System.in);
	    point.setPoint(0);
	    System.out.println("핸드폰번호를 입력하세요 : ");
	    point.setPhone_number(sc.nextInt());
	    System.out.println("이름을 입력하세요 : ");
	    point.setUsername(sc.next());
	    System.out.println("성별을 입력하세요 남/여 : ");
	    point.setUsergender(sc.next());
	    key++;
	    
	 }
}
