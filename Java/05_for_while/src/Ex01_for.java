
public class Ex01_for {

	public static void main(String[] args) {
		// 제어문 - 반복문 (for, while, do ~ while) =>if문과 패턴이 같음
		// for (초기값 설정 ; 실행(종결) ; 변수값 증감설정) {} 
		// for(;;) {} // 무한반복 (조건없이실행)
		//------------------------------------
		
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("-----");
		//ㅋ똑같은 문장만 반복처ㅣㄹ 해술 우 싱ㅆ엄
		
		for (int i = 1; i <= 3; i++) { //초기값은 최초 1회만 실행된다.
			System.out.println("*");
		}
			
		System.out.println("----------------");

		// 별(*) 찍기를 10번 반복
		for (int i = 1; i <=10; i= i + 2) {
			System.out.println("*");
		}
		System.out.println("----------------");	
		
		//=========================================
	
		System.out.println("====== 1부터 5까지 출력 ======");
		//달라지는 부분은 변수처리한다.
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
			
		//하나 큰 수로 만들기 위해 변수 선언 후 1씩 증가처리한다.
//		int num = 1;
//		System.out.println(num); // 한 덩어리
//		num++;					 // 두개의 문장을 반복문 안에 넣어준다
//		System.out.println(num);
//		num++;
//		System.out.println(num); // 규칙성을 찾아 변수처리해 반복문에 넣는다. 
//		num++;
//		System.out.println(num);
//		num++;
//		System.out.println(num);
//		num++;
		
		System.out.println("----------------");	
		int num = 1;
		for (int i = 1; i <= 5; i++) {
			System.out.println(num);
			num++;
		}
		System.out.println("----------------");	
		 
		num = 1;
		for (int i = 1; i <= 5; i++) {
//			System.out.println(++num); //  : 1 증가한 후에 사용
			System.out.println(num++); //  : 사용 후 1 증가
			// num 출력 
			// num++
		}
		
		System.out.println("----------------");
		//반복인자 값을 사용해서 출력도 가능 => 우연히 같을 때라든지
		for (int i = 1; i <= 5; i++) {
			System.out.println (i);
				}
		 //같은 부분을 찾아내고 달라지는 부분에 대한 패턴을 찾아낸다면
		// 반복문 처리할 수 있다.
		
		
		}
		
	}



