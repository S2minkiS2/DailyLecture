
public class Ex07_float {

	public static void main(String[] args) {
		// 실수형 float : 4 byte (1.4E-45 ~ 3.4028235E38)
		// 정확도보다는 범위
		// 지수, 숫자, 데이터 세개 파트로 저장관리됨
		// 소수점 이하 데이터 저장 가능
		// 표시 형식 : 숫자.숫자 + f 또는 F
		// 단, 소수점 이하 6자리까지만 정확도 보장됨
		
		float f1 = 3.4F;
		float f2 = 3.2f;
		System.out.println("float 3.4f : " + f1);		
		System.out.println("float 3.2f : " + f2);
		System.out.println("3.4f + 3.2f : "  + (3.4f + 3.2f));
				
		System.out.println("---- float 최소값/최대값 ----");
		System.out.println("float 최소값 : " + Float.MIN_VALUE);
		System.out.println("float 최대값 : " + Float.MAX_VALUE);
	}

}
