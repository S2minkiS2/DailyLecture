
public class Ex01_plusplus {

	public static void main(String[] args) {
		//증감연산자 : ++, --, 
		// 사용 형태 : ++변수명 , 변수명++, --변수명, 변수명--
		// ++ : 값을 1 증가시킨다.
		// -- : 값을 1 감소시킨다. 
		// ++num; => num = num + 1; 연산에 참가하기 전에 변수값+1
		// num++; => 변수 값이 연산에 참여되고 연산이 끝나고 나면 1 증가 처리된다.
		
		
		int num = 100;
		System.out.println("num : " + num);
		num = num + 1; // 우측의 연산결과값을 좌측에 치환한다.
		System.out.println("num = num + 1 : " + num );
		System.out.println("----------");
		
		//++, -- 연산자 단독사용시 항상 1 증가 또는 감소한다.
		num = 100;
		System.out.println("num : " + num);
		++num; // num = num + 1;
		System.out.println("++num : " + num);
		
		num = 100;
		System.out.println("num : " + num);
		num++; // num = num + 1;
		System.out.println("num++ : " + num);
		System.out.println("------------");
		
		System.out.println("============");
		
		
		//++, -- 연산자가 연산식에 사용되는 경우
		// ++변수명 : 변수 값이 1 증가된 상태에서 연산에 사용됨
		// 변수명 ++ : 변수값이 연산에 사용되고 그 후에 변수값이 1 증가됨
		
		int sum = 0;
		num = 100;
		System.out.println("num : " + num);
		sum = num++; //num의 값이 먼저 전달됨 //그 후에 1증가됨 
		//sum에 num을 대입 후에 1 증가 '='은 결과가 아닌 대입
		System.out.println("sum = num++ : " + sum); 
		//num의 값이 전달된 그대로인 100으로 출력
		System.out.println("num : " + num);
		System.out.println("============");
		
		num = 100;
		sum = num++ +5 ;  //식이 끝난 다음(빠져나간 후)에 1을 더한다는건가?
		//sum = num + 5;
		//num = num +1;
		System.out.println("sum = num++ + 5 : " + sum); 
		System.out.println("num : " + num);
		System.out.println("============");
		
		num = 100;
		System.out.println("num : " + num);
		sum = ++num + 5;		
		System.out.println("sum = ++num + 5 : " + sum); 
		System.out.println("num : " + num);
		System.out.println("============");
	}

}
