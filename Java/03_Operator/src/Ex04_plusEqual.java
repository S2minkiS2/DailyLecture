
public class Ex04_plusEqual {

	public static void main(String[] args) {
		// 대입연산자 : =, +=, -+, *=, /=, %=
		// 예) num+=2; --> num = num + 2;
		
		int result = 0; //처음 result값은 0 
		System.out.println("result : " + result);
		
		result += 15; //ㄱ result = result + 15;
		System.out.println("result + = 15 : " + result);
		//result 값을 읽어와서 15를 저장함.
		//기존 값은 사라지고 15가 된다.
		
		result += 15; // result = result + 15;
		System.out.println("result += 15 : " + result);
		
		System.out.println("------- -= 연산 --------");
		System.out.println("result : " + result);
		result -= 10; // result = result - 10;
		System.out.println("result -= 10 : " + result);
		System.out.println(); // 줄바꿈 
		
		System.out.println("------- *= 연산 --------");
		result *= 10; //result = result * 10 ; result값을 읽어온 후 10을 곱해 다시 저장		
		System.out.println("result *= 10 : " + result);
		System.out.println();
		
		System.out.println("------- /= 연산 --------");
		result /= 10; // result = result / 10; //몫만 취해서 데이터 저장
		System.out.println("result /= 10 : " + result);
		System.out.println();
		
		System.out.println("------- %= 연산 --------");
		result %= 3; //result = result % 3; //나머지 값 구하기
		System.out.println("result %= 3 : " + result);
		
		
	}

}
