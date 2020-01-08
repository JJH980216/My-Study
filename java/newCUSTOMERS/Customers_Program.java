package CUSTOMERS;
import java.util.Scanner;
import java.util.ArrayList;

public class Customers_Program {
	public static void main(String[] args) {
    int mode=1;
    Scanner sc= new Scanner(System.in);
	ArrayList<Customer> customerlist= new ArrayList<Customer>(); 
	Customer_Management cm= new Customer_Management();
	Management mg = new Management();
	while (true) {
	  do {
		   cm.ui();//UI출력
		   System.out.print("번호를 입력하세요:");
		   mode = sc.nextInt();
	    }while (mode<0||mode>6);
	 if(mode==0) mg.customermanagement(customerlist);
	 else if(mode==1) cm.signup(customerlist);
	 else if (mode==2) cm.changeinformation(customerlist);
	 else if (mode==3) cm.checkpoint(customerlist);
	 else if (mode==4) cm.changepoint(customerlist,mg);
	 else if (mode==5) cm.removecustomer(customerlist);
	 else break;	
	}
	
	System.out.println("프로그램을 종료합니다.");
	}
}
