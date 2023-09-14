
public class Ex01_if {
	
	public static void main(String[] args) {
		/* 제어문(컨트롤하는문장) - 분기문(비교문) : if문
		if () {
			실행할 문장들 (조건이 참일 때);
		}
		 */
		
		int num1 = 10;
		int num2 = 20;
		System.out.println("num1 < num2 : " + (num1 < num2)); 
		if (num1 < num2) {   //조건문은 소괄호 안에 작성
			System.out.println("num1이 num2보다 작다"); //만족할 때 실행
		}
		System.out.println(">> 비교작업 끝");
		System.out.println("-------------");
		
		boolean result = num1 < num2;
		if (result) {
			System.out.println("num1이 num2보다 작다");
		}
		System.out.println(">> 비교작업 끝2");
		System.out.println("-------==========------");
		
		// 점수 평가 결과 출력 : 수, 우, 미, 양, 가
		/*
		90~100 : 수
		80~89 : 우
		70~79 : 미 
		60~60 : 양
		0~59 : 가
		 */
		
		System.out.println("--- 성적처리 ---");
		String name = "홍길동"; 
		int jumsu = 120;
		String result2 = "평가안됨";
		
		System.out.println("이름 : " + name);
		System.out.println("점수 : " + jumsu);
		
		// 평가작업
		if (90 <= jumsu && jumsu <= 100) {
			//System.out.println(":: 평가결과 : 수");
			result2 = "수";
		}
					
		if (80 <= jumsu && jumsu <= 89) {
			//System.out.println(":: 평가결과 : 우");
			result2 = "우";
		} 
					
		if (70 <= jumsu && jumsu <= 79) {
			//System.out.println(":: 평가결과 : 미");
			result2 = "미";
		}		
		
		if (60 <= jumsu && jumsu <= 69) {
			//System.out.println(":: 평가결과 : 양");
			result2 = "양";
		}
		
		if (0 <= jumsu && jumsu <= 59) {
			//System.out.println(":: 평가결과 : 가");
			result2 = "가";
		}
		
		System.out.println("::평가결과 : " + result2);
		//자바에서는 변수 사용 범위가 중괄호 기준이다.
		//중괄호 밖에서 사용하고 싶다면 중괄호 밖에서 선언해라
		//중괄호 밖에서 선언 후 변수를 가져다 쓰면 됨
		//초기화 해야하는 이유 : if문 사용 시 값이 설정되지 않을 가능성있음
		//비교처리할 때 100퍼센트 값이 들어간다면 초기화하지 않아도 됨
		
		System.out.println(">> 성적처리 끝 ---------");
	}
}
	
