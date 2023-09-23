
public class Ex02_if_else {

	public static void main(String[] args) {
		// if문 3종류
		// if (조건) {true 실행} 
		// if (조건) {true 실행} else {false 실행}
		// if (조건) {} else if () {} else if () {} .... else{}
		
		int num1 = 30;
		int num2 = 50;
		System.out.println("num1: " + num1 + ", num2: " + num2);
		
		
		//1. if (조건) {}
		if (num1 > num2) { // !!!!!!!!!!!!!!!!!!!!!!
			System.out.println("num1 > num2 : " + (num1 > num2));
			System.out.println("num1이 num2 보다 크다");
		} 		
		//중괄호로 묶어주면 true일 때 두개의 문장이 모두 실행된다.
		//중괄호로 묶지 않으면 true일 때 첫번째 문장 하나만 처리한다.
		
		if (num1 <= num2) {
			System.out.println("num1이 num2보다 작거나 같다");
		}
				
		System.out.println(">> if () 끝 ");
		System.out.println("====================");
		
		//2. if (조건 {} else {}
		if (num1 > num2) {
			System.out.println("num1이 num2 보다 크다");
		} else {
			System.out.println("num1이 num2보다 작거나 같다");
		}
		System.out.println(">> if ~ else 끝");
		System.out.println("====================");
		
		
		// 3. if (조건) {} else if () {} else if () {} .... else{}
		num1 = 50; 
		num2 = 50;
		System.out.println("num1: " + num1 + ", num2: " + num2);
		
		if (num1 > num2) {
			System.out.println("num1이 num2 보다 크다");
		} else if (num1 == num2) {
			System.out.println("num1은 num2와 같다");
		} else { //작은 경우
			System.out.println("num1이 num2 보다 작다");
		}
		
		System.out.println();
		System.out.println(">> if ~ else if ~ else 끝");
	
		
		// 점수 평가 결과 출력 : 수, 우, 미, 양, 가
		/*
		90~100 : 수
		80~89 : 우
		70~79 : 미 
		60~60 : 양
		0~59 : 가
		----------------------------------- */
//		if (조건) {} else if () {} else if () {} .... else{}
		
		//입력-----------------------------
		System.out.println("---- 성적처리 ----");
		String name = "홍길동"; 
		int jumsu = 790;
		String result2 = "점수없음";
		
		//처리-------------------------
		if (jumsu <0 || jumsu >100) {
			result2 = "잘못된 점수";
		}
		else if (jumsu >= 90) {
			result2 = "수"; 
		} else if (jumsu >=80) { //90보다 작은 값만 넘어오기 때문에 다른 조건은 필요없다.
			result2 = "우"; 
		} else if (jumsu >=70) {
			result2 = "미";
		} else if (jumsu >=60) {
			result2 = "양";
		} else {
			result2 = "가";
		} 
		
		//출력--------------------------
		System.out.println(name + "의 점수 : " + jumsu);
		System.out.println(name + "의 평가결과 : " + result2);
		System.out.println("---- 성적처리 끝----");
				
//		if (jumsu >= 90) {
//			result2 = "수";
//		} else if (jumsu >=80) {
//			result2 = "우";
//		} else if (jumsu >=70) {
//			result2 = "미";
//		} else if (jumsu >=60) {
//			result2 = "양";
//		} else {
//			result2 = "가";
//		}
//		System.out.println("평가결과 = " + result2);
		
		//============================
		/* if문 내에 중첩해서 if문 얼마든지 사용가능
		if (){
			if() {
				if () {
				} else {
				}
				}
				} else {
				if () {
				} else if () {
				} else if () {
				} else {
				}
			}
		 */
		
		
	}		
}
