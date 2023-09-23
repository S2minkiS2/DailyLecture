
public class Ex01_boolean {

	public static void main(String[] args) {
		//boolean : true, false 값을 가진다. (논리형)
		//타입 변수명; //변수 선언만 하는 경우
		//타입 변수명 = 값; // 변수선언 + 초기값 결정 
		boolean bool1 = true; // 문자열 "true"가 아니다
		boolean bool2 = false; // 
		
		System.out.println("bool1 : " + bool1);
		System.out.println("bool2 : " + bool2);
		
		bool1 = true;
		
		if (bool1) { //bool1의 값이 true이면 실행
			System.out.println("if문 bool1이 참(true)이면 실행");
		} else {
			System.out.println("if문 bool2이 거짓(false)이면 실행");
		}
		
		
			System.out.println("------main 메소드 끝------");
	}
}
