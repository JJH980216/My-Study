package CUSTOMERS;

import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    int passward=1111;
    Scanner sc = new Scanner(System.in);
    void customermanagement(ArrayList<Customer> customerlist) {
    	System.out.println("   <������â>   ");
    	System.out.print("�����ں�й�ȣ:");
    	if(passward==sc.nextInt()) {
    		System.out.println("   <����ܸ���Ʈ>   ");
    		for(int i=0;i<customerlist.size();i++) {
    			Customer point = customerlist.get(i);
    			System.out.println("--------------------");
    			System.out.println("���̸�:"+point.getUsername());
    			System.out.println("������:"+point.getUsergender());
    			System.out.println("������Ʈ:"+point.getUserpoint());
    			System.out.println("��ID:"+point.getId());
    			System.out.println("����й�ȣ:"+point.getPassward());
    			System.out.println("--------------------");
    		}
    	}
    	else System.out.println("��й�ȣ�� �߸��Ǿ����ϴ�.");
    }
    boolean check() {
    	System.out.print("�����ں�й�ȣ:");
    	if(passward==sc.nextInt()) return true;
    	else return false;
    }
}
