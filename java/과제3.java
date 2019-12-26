package 과제3;
import java.util.Scanner;//Scanner 객체를 만들기 위한 import문.

public class main {
	public static void main(String[] args) {
	System.out.println("두 정수와 연산자를 입력하세요");
	Scanner sc= new Scanner(System.in);//사용자로부터 값을 입력받기 위한 스캐너 객체 생성
	int n1 = sc.nextInt();// 정수 입력받은후 n1에 저장
	int n2 = sc.nextInt();// 정수 입력받은후 n2에 저장
    String oper = sc.next();// 연산자 입력받은후 oper에 저장
    sc.close(); // 스캐너객체 종료
    switch(oper) {
      case "+": Add ADD =new Add(); //연산자가 +인 경우 Add클래스 객체ADD생성.
                ADD.setValue(n1,n2);//ADD객체의 setValue함수에 n1,n2를 넘겨준다.
                System.out.println( ADD.calculate());//ADD객체의 calculate함수 실행후 결과 출력.
                break;// switch문 탈출
   
	  case "-": Sub sub =new Sub();//연산자가 -인 경우 Sub클래스 객체sub생성.
                sub.setValue(n1,n2);//sub객체의 setValue함수에 n1,n2를 넘겨준다.
                System.out.println( sub.calculate());//sub객체의 calculate함수 실행후 결과 출력.
                break;
              
	  case "*": Mul mul =new Mul();//연산자가 *인 경우 Mul클래스 객체mul생성.
                mul.setValue(n1,n2);//mul객체의 setValue함수에 n1,n2를 넘겨준다.
                System.out.println( mul.calculate());//mul객체의 calculate함수 실행후 결과 출력.
                break;
                
	  case "/": Div div =new Div();//연산자가 /인 경우 Div클래스 객체div생성.
                div.setValue(n1,n2);//div객체의 setValue함수에 n1,n2를 넘겨준다.
                System.out.println( div.calculate());//div객체의 calculate함수 실행후 결과 출력.
                break;
     
      default : System.out.println("값을 잘 못 입렸하셨습니다."); //위의 연산자들이 아닐 경우 사용자에게 알려준다.         

	}
	}
}
public class Add {
	int a,b=0;//main 클래스로 부터 값을 넘겨받아 저장할 변수선언. 
	void setValue(int n1, int n2) //main 함수로 부터 값을 넘겨 받아 필드에 저장하는 함수
	{
		 a= n1; 
		 b =n2;
	}
	int calculate()//넘겨받은 값들로 덧셈연산을 진행후 리턴하는 함수.
	{
	    return a+b;	
	}
}
public class Sub {

	int a,b=0;
	void setValue(int n1, int n2) {
		 a= n1;
		 b =n2;
	}
	int calculate()//넘겨받은 값들로 뺄셈연산을 진행후 리턴하는 함수.
	{
	    return a-b;	
	}
}
public class Mul {
	int a,b=0;
	void setValue(int n1, int n2) {
		 a= n1;
		 b =n2;
	}
	int calculate()//넘겨받은 값들로 곱셈연산을 진행후 리턴하는 함수.
	{
	    return a*b;	
	}
}
public class Div {
	int a,b=0;
	void setValue(int n1, int n2) {
		 a= n1;
		 b =n2;
	}
	double calculate()//넘겨받은 값들로 나눗셈연산을 진행후 리턴하는 함수.
	{
	    return (double)a/b;	
	}
}
