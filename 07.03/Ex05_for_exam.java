
public class Ex05_for_exam {

	public static void main(String[] args) {
		// 문제 : 1~10까지의 숫자 중 짝수를 출력
		
		//(실습) 1~10까지의 숫자 중 3의 배수인 숫자를 출력
		
		//(실습) 900~1000까지의 숫자 중 17의 배수인 숫자를 출력
		
		//(실습) 2000~3000까지의 숫자 중 19의 배수인 숫자를 출력
		for (int i = 1; i <= 10; i++) {
			if (i%3 == 0) System.out.print(i + " ");
		}
		
		System.out.println("\n-------------------");
		
		for (int i = 17; i <= 100; i++) {
			if (i%17 == 0) System.out.print(i + " ");
		}
		
		System.out.println("\n-------------------");
		
		for (float i = 10000L; i <= 100000L; i++) { //데이터가 길다면 long + 키워드
			if (i%10000 == 0) System.out.print(i + " ");
		}
		
		System.out.println("\n-------------------");	
		
		int startNum = 10000;
		int endNum = 20000;
		int divNum = 199;
		int count = 0;
		
		for (int i = startNum; i <= endNum; i++) {
			if ( i % divNum == 0) {
				count++;
				System.out.println(divNum + "의 배수 : " + i + "_" + count + "번째 숫자");
			}
		}
	}

}
