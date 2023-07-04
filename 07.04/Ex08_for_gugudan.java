
public class Ex08_for_gugudan {

	public static void main(String[] args) {

		//구구단 2단 출력
		
		int dan = 2;
		System.out.println("---------" + dan + "단 출력-----------");
		for(int i = 2; i <= 9; i++) {
			System.out.println(dan + "*" + i + " = " + dan*i); // 숫자로 하지말고 변수처리 하자. 프로답게.
		}
		
		System.out.println("==============아래는 내가 만든 구구단============");
		
		int dan2 = 2;
		for(int a = 2; a <= 9; a++) {
			System.out.println("---------" + dan + "단을 출력합니다--------");
			for(int b = 1; b <= 9; b++) {
				System.out.println(dan + " * " + b + " = " + dan*b);
			}
			System.out.println();
			dan++;
		}
		
		System.out.println("******** 2~9단 출력 ********");
		int dan3;
		for(dan3 = 2; dan3 <= 9; dan3++) {
			System.out.println("---" + dan3 + "단 출력---");
			for(int gop = 1; gop <= 9; gop++) {
				System.out.println(dan3 + " * " + gop + " = " + (dan3 * gop));
			}
		}
	}
}
