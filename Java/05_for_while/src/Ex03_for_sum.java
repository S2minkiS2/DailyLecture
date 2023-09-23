
public class Ex03_for_sum {

	public static void main(String[] args) {
		// 문제 : 1~10 까지의 합계를 구하시고(for, 화면출력)
		// 1~10까지 합계 : 55
		// int sum = 1 + 2 +3 +4 +5 +6 +7 +8 +9 +10;
		// System.out.println("1~10까지의 합계 : " +sum);
		System.out.println("-----------------------");
		
		int sum = 0; //sum을 저장할 변수 공간(누적) 초기화해서 사용
		for(int i = 1; i<=10; i++) {
			sum+=i;	 // (sum + i = sum) 을 반복
		}		     //sum + 1 = sum; sum + 2 = sum.... i값 더해줌
		System.out.println("1~10 까지의 합계 : " + sum );
		//출력문은 반복되지 않게 for문에서 꺼내줌
		System.out.println("-----------------------");
		
		
		
		//(실습) 1~10까지의 숫자 중에 짝수를 찾아서 출력하시오.
		//		2 4 6 8 10
		for (int i = 2; i<=10; i++) {
			if (i%2==0) {
				System.out.println(i);
			}
		}
		System.out.println("-----------------------");
		
		//(실습) 1~10까지의 숫자 중에 홀수를 찾아서 출력 (1,3,5,7,9)
		for (int i = 1; i <=10; i++) {
			if (i%2!=0) {
				System.out.println(i);
			}
		}
		
		
	}

}
