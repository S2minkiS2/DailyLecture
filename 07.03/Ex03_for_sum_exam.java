
public class Ex03_for_sum_exam {

	public static void main(String[] args) {
		//문제: 1~10까지 짝수와 홀수 합계구하기
		int sum = 0;
		int sum2 = 0;
		
		for (int i = 0; i <= 10; i++) {
			if(i%2==0) {
				sum += i;
			}else {
				sum2 += i;
			}
		}
		System.out.println("1부터 10까지 짝수의 합계: " + sum);
		System.out.println("1부터 10까지 홀수의 합계: " + sum2);
		
		System.out.println("------------------------------");
		
		//(실습) 1부터 10까지 숫자중에 짝수를 찾아서 출력하시오.
		for (int i = 0; i <= 10; i++) {
			if (i%2 == 0 && i != 0) {
				System.out.println("짝수: " + i);
			} else if( i != 0){
				System.out.println("홀수: " + i);
			}
		}
		System.out.println("------------------------------");
		
		//(실습) 1부터 10까지 숫자중에 홀수를 찾아서 출력하시오.
		for (int i = 1; i <= 10; i++) {
			if (!(i%2 == 0)) {
				System.out.println(i);
			}
		}
		System.out.println("------------------------------");
		
		//(실습)
		
	}

}
