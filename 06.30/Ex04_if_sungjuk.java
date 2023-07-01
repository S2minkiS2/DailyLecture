
public class Ex04_if_sungjuk {

	public static void main(String[] args) {
		//국어 kor, 영어 eng, 수학 math -> 총점 tot = 국어+영어+수학 , 그리고 평균 avg도 구하기
		//평균점수 구간에 따라 평가: 90~100: A, 80~: B, 70~: C, 60~: D, 60미만: F 재수강하세요 메세지 출력 
		/*
		 * <처리결과>
		 * 국어 : 100
		 * 영어 : 90
		 * 수학 : 80
		 * -------------
		 * 총점 : 270
		 * 평균 : 90 
		 * 평가결과 : A
		 * -------------*/
		//성적 입력
		//성적 처리
		//처리 결과 출력
		
		ExamRecord raphael = new ExamRecord();
		raphael.record(80,20,40);
				
	}

}

class ExamRecord {
	static int examNum = 3;
	int kor;
	int eng;
	int math;
	int total;
	double avg;
	char grade;
	
	public void record(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		this.total = kor + eng + math;
		this.avg = Math.round(total * 100 / (double)examNum) / 100.0; //어떻게 소수점 둘째짜리 까지만. 존나 어렵다.
		
		
		
		if(!(avg>=0 || avg<=100)) {
			System.out.println("입력이 잘못 되었습니다.");
		} else if (avg>=90) {
			grade = 'A';
		} else if (avg>=80) {
			grade = 'B';
		} else if (avg>=70) {
			grade = 'C';
		} else if (avg>=60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		
		System.out.println("<처리결과>");
		System.out.println("국어: " + this.kor);
		System.out.println("영어: " + this.eng);
		System.out.println("수학: " + this.math);
		System.out.println("---------------------");
		System.out.println("총점: " + this.total);
		System.out.println("평균: " + this.avg);
		if(grade != 'F') {
			System.out.println("성적결과: " + grade);
		} else {
			System.out.println("성적결과: " + grade + "재수강하세요.");
		}

	}
	
}
	
