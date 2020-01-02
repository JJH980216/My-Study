package STUDY1;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		ArrayList<User> a = new ArrayList<User>();
		UI ui = new UI();
		ui.uiprint();
		num = sc.nextInt();
		while(num!=6) {
		switch(num) {
		case 1:
			Sign sign = new Sign();
			sign.signup();
			a.add(sign.point);
		    ui.uiprint();
		    num = sc.nextInt();
		    break;
		
		case 2: 
			ChangeInformation ch = new ChangeInformation();
			ch.change(a);
			ui.uiprint();
			num = sc.nextInt();
		    break;
		case 3:
			 GetPoint gp = new GetPoint();
			 gp.point(a);
			 ui.uiprint();
			 num = sc.nextInt();
			break;
		case 4:
			 SetPoint sp = new SetPoint();
			 sp.point(a);
			 ui.uiprint();
			 num = sc.nextInt();
			break;
		case 5:
		     DeleteUser du= new DeleteUser();
		     du.delete(a);
			 ui.uiprint();
			 num = sc.nextInt();
			break;	
		default : 
			 System.out.println("입력이 잘못되었습니다.");
			 ui.uiprint();
			 num = sc.nextInt();
			 break;
	     } 
		
	  }
		sc.close();
		System.out.println("프로그램이 종료되었습니다.");
	}
}
