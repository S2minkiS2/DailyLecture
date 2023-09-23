
public class Ex03_switch_case {

	public static void main(String[] args) {
		// switch case문 : 동등비교구문
		/*
		switch (조건 값 (비교기준값)) {
		case (비교값1 (비교대상값)) : 
			실행할 문장(들); (<=조건값과 비교값이 같으면 실행 => 동등 비교만 함)
			break;
		case 비교값2 :
			실행할 문장(들); 
			break;
			...
		default :
			실행할 문장(들);
			break;
		}
		-------------- */
		int month = 1;
		switch (month) {
		case 1 : 
			System.out.println("31일까지 있습니다");
			break;
		case 2 :
			System.out.println("28일 또는 29일까지 있습니다.");
			break;
		case 3 : System.out.println( "31일까지 있습니다");	
			break;
		case 4 : System.out.println( "30일까지 있습니다");	
			break; 
		default : System.out.println("일치하는 값이 없습니다.");
		}//break가 없으면 아래 명령문을 다 지나서 흘러내린다.
		
		switch (month) {
		case 1 : 
		case 3 :
		case 5 : case 7: case 10: case 12: 
			//같은 처리하는 케이스의 경우엔 한꺼번에 처리할 수 있게 
			//이어서 작성해주면 좋다.
			System.out.println("31일까지 있습니다");
			break;
		case 2: 
			System.out.println("28일 또는 29일까지 있습니다");
			break;
		case 4 : 
		case 6 : case 9 : case 11:
			System.out.println("30일까지 있습니다");
			break;
		}
		System.out.println("===============");
		
		/*(실습) 추첨 결과에 따라서 상품 지급
		1등 : 냉장고, 2등 : 김치냉장고, 3등세탁기, 4등 : 청소기
		등수 안에 없으면 (꽝인경우) : 휴지 
		추첨 결과 당첨상품 출력하시오
		출력예시) 당첨상품 : 냉장고
		--------------------------*/
		
		String result = "꽝"; //추첨결과
		String resultMsg = "상품없음";
		//당첨여부 확인
		
		switch(result) {
		case "1등" : 
			resultMsg = "냉장고";
			break; //1등 상품만 줘야하기 때문에 break
		case "2등" :
			resultMsg = "김치냉장고";
			break;
		case "3등" :
			resultMsg = "세탁기";
			break;
		case "4등" :
			resultMsg = "청소기";
			break;
		default :
			resultMsg = "휴지";
			break;
		}
		System.out.println(result + "입니다.");
		System.out.println("당첨 상품은 " + resultMsg +"입니다.");
		
//		switch (result) {
//		case "1등" : 
//			resultMsg = "냉장고";
//			break;
//		case "2등" :
//			resultMsg = "김치냉장고";
//			break;
//		case "3등" :
//			resultMsg = "세탁기";
//			break;
//		case "4등" :
//			resultMsg = "청소기";
//			break;
//		case "꽝" : 
//			resultMsg = "휴지";
//			break;
//		default : 
//		}		
//		System.out.println("추첨 결과는 " + result + "입니다.");
//		System.out.println("당첨 상품은 " + resultMsg + "입니다.");
	}
} // default 뒤에 중괄호 밖에 println을 넣어야 언제든 실행됨

//		switch (result) {
//		case "1등" : 
//			System.out.println("냉장고");
//			break;
//		case "2등" :
//			System.out.println("김치냉장고");
//			break;
//		case "3등" :
//			System.out.println("세탁기");
//			break;
//		case "4등" :
//			System.out.println("청소기");
//			break;
//		case "꽝" :
//			System.out.println("휴지");
//			break;
//		default :
//			System.out.println(resultMsg);
//		}


