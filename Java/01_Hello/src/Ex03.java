
public class Ex03 {

	public static void main(String[] args) {
		//십진수, 2진수, 8진수, 16진수
		int decimal = 10; // 우측의 값 10을 좌측에 저장 (치환)
		int binary = 0b1010;
//		ob, oB 접두어 사용 - 자바에서 2진수 값 표현하는 접두어
		int octal = 012; // 0 접두어 숫자 0 사용 (8진수)
		// 8진수 접두어 숫자 0 사용
		int hexaDecimal = 0xa; //0x, 0X 접두어 사용 (16진수)
		
		
		//                             10 11 12 13 14 15
		// 16진수 : 0 1 2 3 4 5 6 7 8 9 A  B  C  D  E  F 
		// ctrl shift x y 대소문자 변경
		
		System.out.println("decimal : " + decimal); 
		System.out.println("binary : "+ decimal); 
		System.out.println("octal : " + octal);
		System.out.println("hexaDecimal : " + hexaDecimal);
		System.out.println(Integer.toBinaryString(10));
		System.out.println(Integer.toHexString(10));
	}

}
