
public class Ex04_if_jungjuk {

	public static void main(String[] args) {
		/* 성적처리
		 국어(kor), 영어(eng), 수학(math)
		 총점(tot) = 국어 + 영어 + 수학
		 평균(avg) = 총점 / 3 
		 --------------------------------
		 평균점수 구간에 따라 평가
		 90 ~ 100 : A
		 80 ~ 89 : B
		 70 ~ 79 : C
		 60 ~ 69 : D
		 69미만 0 ~ 59 : F 재수강하세요
		 ============================
		 <처리결과>
		 국어 : 100
		 영어 : 90
		 수학 : 80
		 ----------
		 총점 : 270
		 평균 : 90
		 평가결과 : A
		 --------------------------------*/
		
		//성적 입력----------------------
		int kor = 100;
		int eng = 95;
		int math = 80;
		
		//성적 처리 (총점, 평균, 평가)------
		int tot = (kor+eng+math);
		double avg = tot * 100 / 3 /100.0; //int값 나누기 double의 값은 double
		 // 100을 곱한 후 9033.xxxxxxxxxx 에서 9033만 필요하기 때문에 
		// 정수형으로 바꿈. 그 후에 다시 나눠서 실수형으로 바꿔준다.
		avg = Math.round(tot * 100 / 3.0) / 100.0; //소수점 이하 셋째자리 반올림
		
		//평균값에 대한 평가작업------------
		String result = "평가안됨";
		if (avg >= 90) {
			result = "A";
		} else if (avg >= 80) {
			result = "B";
		} else if (avg >= 70) {
			result = "C";
		} else if (avg >= 60) {
			result = "D";
		} else {
			result = "F 재수강하세요";
		}
		
		//처리 결과 출력	-----------------	
		System.out.println("<처리결과>");
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("----------");
		System.out.println("총점 : " + tot);
		System.out.printf("평균 : %3.1f%n",  avg);
		System.out.println("평가결과 : " + result);
		
		
		
	
//		// 성적 입력
//		int kor = 50;
//		int eng = 90;
//		int math = 80;
//		
//		// 성적 처리 (총점, 평균, 평가)
//		
//		int tot = (kor + eng + math);
//		float avg = tot/3.0f;
//		
//		char result = 'F';
//		if (avg >=90) {
//			result = 'A';
//		} else if (avg >= 80 ) {
//			result = 'B';
//		} else if (avg >= 70) {
//			result = 'C';
//		} else if (avg >= 60) {
//			result = 'D'; 
//		} else {
//			result = 'F';	
//		}
//		 
//		System.out.println("<처리결과>");
//		System.out.println("국어 : " + kor);
//		System.out.println("영어 : " + eng);
//		System.out.println("수학 : " + math);
//		System.out.println("----------");
//		System.out.println("총점 : " + tot);
//		System.out.printf("평균 : %3.1f%n",  avg);
//		System.out.println("평가결과 : " + result);
//		
		
		// 처리 결과 출력
		
		
		
		
		
		
	}

}
