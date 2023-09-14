
public class EX05_for_exam {

	public static void main(String[] args) {
		// 문제 : 1~10까지의 숫자 중 짝수를 출력
		for (int i = 1; i <= 10; i++) {
			if (i%2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println("==================");
		
		//(실습) 1~10까지의 숫자 중 3의 배수인 숫자를 출력
		for (int i = 1; i <=10; i++) {
			if (i%3 == 0) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println();
		System.out.println("==================");
		
		//(실습) 900~1000까지의 숫자 중 17의 배수를 출력
		for(int i = 900; i <=1000; i++) {
			if (i%17 == 0) {
				System.out.print(i + " ");
			}
		}

		System.out.println();
		System.out.println("==================");
		
		//(실습) 2000~3000까지의 숫자 중 19의 배수를 출력
		for (int i = 2000; i <= 3000; i++) {
			if (i%19 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println("==================");
		
		//변수를 사용해서 일반화 하기 : 
		// 코드를 변경하지 않고 변수값만 설정해서 다양한 값을 산출 가능
		int startNum = 10000;
		int endNum = 20000;
		int divNum = 199;
		for (int i = startNum; i <= endNum; i++) {
			if (i%divNum == 0) {
				System.out.println(i + " ");
			}
		}
		
		
		
	}

}
