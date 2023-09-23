
public class EX02_for_exam {

	public static void main(String[] args) {
		//for (초기값 설정 ; 실행(종결) ; 변수값 증감설정) {} 
		
		//(실습) 1부터 5까지의 숫자 화면출력
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		System.out.println("-------------");
		
		//(실습) 11부터 15까지 화면 출력 
		for(int i = 11; i <=15; i++) {
			System.out.println(i);
		}
		System.out.println("-------------");
		
		//(실습) 1,3,5,7,9 화면출력
//		for(int i = 0; i<10; i++) {
//			System.out.println(i+=1);
//		}
		for(int i = 1; i<10; i+=2) {
			System.out.println(i);
		}
		System.out.println("-------------");
			
		//(실습) 2,4,6,8,10 화면출력
//		for(int i = 1; i<10; i++) {
//			System.out.println(i+=1);
//		}
//		System.out.println("-------------");
		for(int i = 2; i<=10; i+=2) {
			System.out.println(i);
		}
		System.out.println("-------------");
				
		//(실습) 5,4,3,2,1 화면 출력
		for(int i = 5; i>0; i--) {
			System.out.println(i);
		}
		System.out.println("-------------");
		
		
		

	}

}
