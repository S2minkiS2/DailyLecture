
public class Ex03_switch_case {

	public static void main(String[] args) {
		//switch case, 동등 비교만 가능하다.
		char grade = 'C';
		
		switch (grade) {
		case 'A':
			System.out.println("성적이 높네요");
			break;
			
		case 'B':
			System.out.println("성적이 보통이네요");
			break;
			
		case 'C':
			System.out.println("성적이 나빠요");
			break;
			
		default:
			System.out.println("입력이 잘못 되었습니다.");
			break;
			
		} 
		
//		MonthResult montha = new MonthResult();
//		Montha.month01();
//		static 메서드는 객체생성 없이도 접근이 가능. 아래처럼... 하ㅏ 바보멍청이/
		
		MonthResult.month01();
		
		Gacha one = new Gacha();
		one.gacha01();
		
		
	}
}

class MonthResult{
	
	public static void month01() { //static 이기에 이 메서드는 객체생성없이 클래스명.메서드명 으로 바로 접근 가능
		int month = 2;
		
		switch(month) {
		case 1:
			System.out.println("31일까지 있습니다.");
			break; //break를 따라 switch문 종료. 없으면 break 만날때까지 주르륵 흘러내림
		case 2:
			System.out.println("28일 혹은 29일까지 있습니다");
			break;
		case 3:
			System.out.println("31일까지 있습니다");
			break;
		default : //케이스로 값을 정해준 이외의 값이 나올 경우
			System.out.println("일치하는 값이 없습니다");
			break;
		} 
		System.out.println("------------------------------------------");
	}
}

class Gacha{
	
	public void gacha01() {
		int num = 3;
		String result;
		String resultMsg;
		
		switch(num) {
		case 1:
			result = "1등";
			resultMsg = "냉장고";
			break;
		case 2:
			result = "2등";
			resultMsg = "컴퓨터";
			break;
		case 3:
			result = "3등";
			resultMsg = "청소기";
			break;
		default:
			result = "꽝";
			resultMsg = "휴지";
			break;
		}
		if(1 <= num && 3 >= num) {
		System.out.println("축하드립니다. " + result +"에 당첨되셨습니다.");
		System.out.println("상품은 "+ resultMsg + "입니다. 야호~");
		} else {
			System.out.println("아쉽네요. " + result +"에 당첨되셨습니다.");
			System.out.println("상품은 "+ resultMsg + "입니다. 다음엔 당첨되실 거에요.");
		}
	}
}
