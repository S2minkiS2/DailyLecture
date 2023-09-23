
public class Ex04_short {
	public static void main(String[] args) {
		//정수형 short : 2byte (개수 : 65536개, 범위 -32768 ~ 32767)
	short short1 = 20000;
	short short2 = 30000;
	
	System.out.println("short1 : " + short1);
	System.out.println("short2 : " + short2);
	
	//표현 범위를 벗어나면 원치않는 결과값을 가짐
	short sum = (short)(short1 + short2); //강제 형변환 int => short 타입
	System.out.println("short sum : " + sum);
	
	int sumInt = short1 + short2;
	System.out.println("int sumInt : " + sumInt);
	//형변환을 강제로 하며 잘려나간 값이 int타입에 저장되면 손실없이 사용 가능
	//연산 도중 값 손실이 발생하는 것은 아니다.
	}
}
