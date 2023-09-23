
public class Ex08_double {

	public static void main(String[] args) {
		//실수형 double : 8 byte
		//범위를 고려하지 않아도 될 정도로 큰 범위
		//표시형식 : 숫자.숫자  또는 숫자.숫자 + D/d (생략가능)
		//소수점 이하 약 15자까지는 정확도 유지 가능
		//float보다 double타입이 정확도가 넓고 범위도 넓다.
		
		double d1 = 1.1; 
		double d2 = 1.12345678901234567890d;
		System.out.println("double 1.1 : " +d1);
		System.out.println("double 1.12345678901234567890 : " +d2);
		
		double sum = d1 + d2;
		System.out.println("d1 + d2 : " + sum);
		
		System.out.println("3.4d + 3.2d : " + (3.4d + 3.2d)); //6.6
	
		System.out.println("double 최소값 : " + Double.MIN_VALUE);
		System.out.println("double 최대값 : " + Double.MAX_VALUE);
		
	
	}
}
