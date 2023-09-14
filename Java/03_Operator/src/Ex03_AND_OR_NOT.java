
public class Ex03_AND_OR_NOT {

	public static void main(String[] args) {
		// 논리연산자 : && (AND) 좌우가 트루/트루이면 true
//		|| (OR), 
//		 ! (NOT)
//		 논리연산자 (&&, ||, !) 의 좌,우에는 true, false값이 있어야함
		
		System.out.println("----&& (AND) ----");			  
		System.out.println("true && true : " + (true && true));
		System.out.println("true && false : " + (true && false));
		System.out.println("false && true : " + (false && true));
		System.out.println("false && false : " + (false && false));
		//첫번째 오는 값이 false 인 경우 뒷쪽은 연산처리하지 않는다.
		System.out.println("----------------");
	
							  
		boolean bool1 = true;
		boolean bool2 = false;
		System.out.println(bool1 + " && " + bool2 + " : " + (bool1 && bool2));
		// && : 둘 중 하나라도 false 면 false
		System.out.println("=================");
		
		int num1 = 10;
		int num2 = 20;
		// (num1 < num2) && bool1 : ??? //비교식과 논리식으로 다양한 식을 만들 수 있다.
		boolean result = (num1 < num2) && bool1;
		System.out.println(num1 + " < " + num2 + " && " + bool1 + " : " + result);
	
		System.out.println("=================");
//		====================================================
		
		System.out.println("----- || (OR) -------");
		//or 연산자는 앞쪽이 true 면 뒤의 연산자는 실행되지 않는다.
		System.out.println("false || true : " + (false || true));
		result = (num1 < num2)|| bool1;
		System.out.println(num1 + " < " + num2 + " || " + bool1 + " : " + result);
		
		System.out.println("=================");
//		====================================================
		System.out.println("----- ! (NOT) -------");
		System.out.println("!true : " + !true);
		result = !(num1 < num2 || bool1);
		
	}

}
