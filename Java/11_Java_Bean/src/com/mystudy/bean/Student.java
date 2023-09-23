package com.mystudy.bean;

/*
 ■ 자바빈(Java Bean)
  - 멤버변수(property)의 접근제어자는 private
  - 멤버변수(property) 마다 get/set 메소드 제공(선택적으로 get만 제공)
  - get/set 메소드는 public
  - get 메소드는 파라미터 없고, set 메소드는 하나 이상의 파라미터 존재
  - 멤버변수(property)가 boolean 타입이면 get 메소드 대신 is 메소드 사용가능
  - 외부에서 멤버변수(property) 접근시에는 get/set 메소드를 통해 접근
 */


	//extends Object 생략하면 컴파일러가 자동 삽입
//public class Student extends Object { 
	//public은 모든 곳에서 가져다 쓸 수 있다.
//class student {
	//default 현재 클래스에서만 사용하겠다
//	String name; 

	class Student extends Object { 
		private String name; 
		private int kor; // 다이렉트로 접근 불가
		private int eng;
		private int math;
		
		//=== 생성자 ==============	
		public Student() {
			// super : 부모클래스 객체(인스턴스)
			// super() : 부모클래스 객체 (인스턴스)의 기본생성자 호출;
			super(); //생략시 컴파일러가 자동 삽입해서 처리함
		}
		
		public Student(String name) {
			super(); //부모클래스의 기본생성자 호출 생략. 컴파일러가 자동삽입
			this.name = name;
		}
		
		public Student(String name, int kor, int eng, int math) {
			//현재객체(인스턴스)의 생성자 호출
			//생성자의 재사용
			this(name); //생성자 호출해서 사용 가능 (현재객체의 생성자 호출)
			//다른 생성자를 호출하는 코드는 생성자 코드 제일 처음에 작성, 실행해야함
//			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
//			computeTotAvg();
		}


		//=== 메소드 작성 영역 ==========
		// 외부에서 사용할 수 있도록 메소드 제공 (public)
		// 외부에서 데이터를 전달받아 필드 또는필드 (멤버변수)에 따라 
		// 데이터 저장하기 위한 set 메소드
		// 저장할 땐 set 메소드,
		// 명칭 setter, set property (속성값 설정 - 쓰기)
		
		void setName(String name) { //데이터 설정 set 키워드
			this.name = name;	 //
		}
			//외부에서 쓰기 위해 만드는 것.
			//외부의 데이터를, 값을 설정한다.
			//외부 기준 명명. 외부에서 사용할 때 제공하기 위함이니까.
		
		//외부에서 데이터를 읽어가기위한 get 메소드
		// 명칭 : get메소드, getter, get property(속성값 읽기)
		String getName() { //전달받을게 없고 달라고 요청만 함.
			return name;
		}
		
			//패키지 접근제한자, 
			
		// kor : setter, getter / set-데이터설정 get-데이터가져가기
		public void setKor(int kor) {
			//적절한 데이터 여부 확인
			if(kor >= 0 && kor <= 100) {
				this.kor = kor;				
			} else {
				System.out.println("[예외발생] 국어 0~100 값이 아님 - " + kor);
			}			
		}
		
		public int getKor() {
			return kor;
		}
		
		
		public void setEng (int eng) {
			if (eng >= 0 && eng <= 100) {
				this.eng = eng;			
			} else {
				System.out.println("[예외발생] 영어 0~100 값이 아님 - " + eng);
			}
		}
		
		public int getEng() {
			return eng;
		}

		public int getMath() {
			return math;
		}

		public void setMath(int math) {
			this.math = math;
		}
		
//		public void setMath (int math) {
//			if (math >= 0 && math <= 100) {
//				this.math = math;
//			} else {
//				System.out.println("[예외발생] 수학 0~100 값이 아님 - " + math);
//			}
//		}
//		
//		public int getMath() {
//			return math;
//		}
		
		// eng, math: setters, getters 작성
		//set은 데이터를 하나 받아야한다. 리턴 필요없으니 void
		//받은 값을 그대로 설정. this키워드 써서 필드에 저장.
		// get 메소드는 외부에 요청하는 것. 되돌려줄 값이 있어야함
		// getName() 필드의 값을 리턴해준다.
		
		
		
		//(실습 ) printData() 메소드 작성 : 저장된 데이터 화면 출력
		public void setTot(int tot) {
//			this.tot = tot;
		}
		
		public void setAvg(double avg) {
			// TODO Auto-generated method stub
			
		}
		public void printData() { //파라미터 없음
			System.out.println(name + "\t" + kor + "\t" + eng + "\t" + math + "\t");
			
		}
		
//		private void computeTotAvg() {
//			tot = kor + eng + math;
//			avg = tot * 100 / 3 / 100.0;
		

}
