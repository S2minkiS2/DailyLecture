package chap4_if_switch_for_while;
못 푼 문제
public class If_for_04 {

	public static void main(String[] args) {
		int sum = 0;
		int bucha = 1; //부호 체인지
		int num = 0; //i가 아니라 num을 더해서 sum을 구할 것임. 문제에서 몇?까지 더해야 하냐고 물었으므로. == '몇'
		
		for(int i = 1; true; i++, bucha = -bucha) {
			num = i * bucha; // i와 부호(bucha)를 곱해서 더할 값을 구함.
			sum += num;
			
			if(sum >= 100)
				break;
		}
		
		System.out.println(num);
		System.out.println(sum);
		
		If_for_04_2 ac = new If_for_04_2();
		ac.abc();
	}

}

class If_for_04_2{
		public static void abc(){
			int sum2 = 0;
			int bucha2 = 1;
			int num2 = 0;
	
			for(int j = 1; sum2 < 100; j++, bucha2 = -bucha2) {
				num2 = j * bucha2;
				sum2 += num2;
			}
			System.out.println(num2);
			System.out.println(sum2);
	}	
}

