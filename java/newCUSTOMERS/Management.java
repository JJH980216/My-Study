package CUSTOMERS;

import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    int passward=1111;
    Scanner sc = new Scanner(System.in);
    void customermanagement(ArrayList<Customer> customerlist) {
    	System.out.println("   <관리자창>   ");
    	System.out.print("관리자비밀번호:");
    	if(passward==sc.nextInt()) {
    		System.out.println("   <고객명단리스트>   ");
    		for(int i=0;i<customerlist.size();i++) {
    			Customer point = customerlist.get(i);
    			System.out.println("--------------------");
    			System.out.println("고객이름:"+point.getUsername());
    			System.out.println("고객성별:"+point.getUsergender());
    			System.out.println("고객포인트:"+point.getUserpoint());
    			System.out.println("고객ID:"+point.getId());
    			System.out.println("고객비밀번호:"+point.getPassward());
    			System.out.println("--------------------");
    		}
    	}
    	else System.out.println("비밀번호가 잘못되었습니다.");
    }
    boolean check() {
    	System.out.print("관리자비밀번호:");
    	if(passward==sc.nextInt()) return true;
    	else return false;
    }
}
