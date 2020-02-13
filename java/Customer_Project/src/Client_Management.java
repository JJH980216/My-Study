import java.util.Scanner;

public class Client_Management {
    Scanner sc = new Scanner(System.in);
    private int Customer_id = 0;
   
	void ui() {
		System.out.println("    <UI>    ");
		System.out.println("0.고객명단출력");
		System.out.println("1.회원가입");
		System.out.println("2.고객포인트조회");
		System.out.println("3.고객포인트변경");
		System.out.println("4.고객 삭제");
		System.out.println("5.프로그램 종료");
	}
	Customer signup(int mode) {
		Customer cm = new Customer();
		cm.setMode(mode);
		cm.setUserpoint("0");
		cm.setLogin(false);
		System.out.println("   <회원가입>   ");
		System.out.print("이름을 입력하세요:");
		cm.setUsername(sc.next());
		System.out.print("성별을 입력하세요 남/여 :");
		cm.setUsergender(sc.next());
		System.out.print("passward를 설정하세요:");
		cm.setPassward(sc.next());
	    cm.setID(Customer_id);
		System.out.println("고객님의ID는" + Customer_id++ + "입니다.");
		return cm;
	}
}
