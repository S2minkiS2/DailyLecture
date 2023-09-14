
public class Ex10_while {

	public static void main(String[] args) {
		// 반복문 : while, do ~ while
		
		
		/* while 반복문 사용 형태
		
		반복인자의 선언 및 초기값 설정;
		while (실행조건식 - true/false) { 
			반복인자값 증감설정 (선택적)
			실행문(들);
			반복인자값 증감설정 (선택적)
		} 
		--------------------- */
		
		//1~10까지 화면출력
		
		for (int i = 1; i <=10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("---------------");
		
		// while문으로 작성
		
		int i = 1; 
		while (i <= 10) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println();
		System.out.println("---------------");
		
		
		i = 0;  //0부터 실행하면 11번 실행됨
		while (i<10) {
			i++;
			System.out.println(i + " ");
		}
		
		System.out.println();
		System.out.println("================");
//		for문에ㅓㄴ 브레이크와 컨틴뉸를 ㅗ모두 사용할 수 ㅇㅆ다.
//		증감식이 무조건 실행된다.
		System.out.println();
		//break : 현재 실행중인 반복문 종료하교 빠져나감
		// while 무한반복
		
		int num = 1;
		while (true) {
			System.out.println(num);
			if (num >= 10) break; // 반복중단
			num++;
		}
		
		System.out.println(" ---- while continue-----");
//		위치를 잘못 쓰면 무한루프에 돌 수 있다.
//	 	증감식 위치를 작성해서도 안된다.
		
		num = 0; 
		while (num <10 ) {
			num++;;
			if (num == 5) continue; //증감식이 continue문 이전에 위치
			System.out.println(num);
		}
			
			
		//for에에서는 그럴 일이 없지만 (어떻게 쓰든 무조건 증감식 만남)
// while문에선 continue문 이전에 만나야 반복처리되던게 중단될 수 있다.
		System.out.println(" ---- for continue-----");
		for (int m = 1; m <= 10; m++ ) {
			if (m % 2 == 0) continue;
			System.out.println(m);
		}
		
		System.out.println(" ---- do ~while -----");
		/* while 반복문 사용 형태
		
		반복인자의 선언 및 초기값 설정;
	 	do { 
			반복인자값 증감설정 (선택적);
			실행문(들);
			반복인자값 증감설정 (선택적);
		} while (실행조건식 - true/false)
		--------------------- */
		//1~10까지 출력
		num = 1; 
		do {
			System.out.println("do~while : " + num);
			num++; // 어떤 경우든 관계없이 무조건 한번은 실행.
		} while (num <= 10);

		System.out.println("================");
		System.out.println("====내부 반복문에서 break 처리시====");
		for (int out = 1; out <= 3; out++) {
			System.out.println(":: out: " + out);

			for (int in = 1; in <= 5; in++) {
				System.out.println("out: " + out + ", in: " + in);
				if (out == 2)
					break; // 내부 반복문만 종료
				// 현재 실행중인 반복문을 중단 후 빠져나간다
			}
			System.out.println("-------------");
		}
		System.out.println("===============");
		System.out.println("=======중첩 반복문 모두 중단하기=======");
		// 중첩 반복문을 모두 종료해야 하는 경우 (위치지정한 후 break문 사용)
		// 라벨지정
		outFor: for (int out = 1; out <= 3; out++) {
			System.out.println(":: out: " + out);

			for (int in = 1; in <= 5; in++) {
				System.out.println("out: " + out + ", in: " + in);
				if (out == 2)
					break outFor; // 외부 반복문 중단처리
				// 모두 중단 후 빠져나간다
			}
			System.out.println("----->>> 프로그램의 끝----"); 
	}

	}
}
