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
//public class student extends Object {

class Student { //extends Object 생략하면 컴파일러가 자동 삽입
	private String name;
	private boolean lookgood;// private으로 하여 직접접근을 막고, 메서드에 넣어서 입력 범위 등을 제어시키고 정상값을 유도한다.
	private int eng;
	private int math;
	private int kor;
	private int tot;
	private double avg;
	
	//=== 생성자 작성 ======================
	public Student() {
		// super : 부모클래스 객체(인스턴스)
		// super() : 부모클래스 객체(인스턴스)의 기본 생성자 호출;
		super(); // 생성자 호출, 컴파일러가 자동 생산했었음
	}
	
	public Student(String name, int kor, int eng, int math) {
		//현재 객체(인스턴스)의 생성자 호출
		this(name); //생성자의 재사용  //생성자 코드 중 맨 첫부분에 작성되어야 실행된다
//		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		computeTotAvg(); //private이라서 여기서 처리
		
	}
	
	public Student(String name) {
		super();
		this.name = name;
		
	}
	//=== 메소드 작성 영역 ======================
	// 외부에서 사용할 수 있도록 메소드를 제공(public)
	// 외부에서 데이터를 전달받아 필드(멤버 변수)에 데이터 저장하기 위한 set메서드
	// 명칭(호칭) : set메서드, setter, set property(속성값 설정-쓰기)
	void setName(String name) {
		this.name = name;
	}
	
	void setLookgood(boolean lookgood) {
		this.lookgood = lookgood;
	}
	
	public void setmath(int math) {
		if (0 <= math && math <= 100) {
			this.math = math;
		} else {
			System.out.println("입력이 잘못 되었습니다. 0부터 100 사이의 숫자를 입력하여 주세요.");
		}
	}
	
	public void seteng(int eng) {
		if (0 <= eng && eng <= 100) {
			this.eng = eng;
		} else {
			System.out.println("입력이 잘못 되었습니다. 0부터 100 사이의 숫자를 입력하여 주세요.");
		}
	}
	
	public void setKor(int kor) {
		if (0 <= kor && kor <= 100) {
			this.kor = kor;
		} else {
			System.out.println("입력이 잘못 되었습니다. 0부터 100 사이의 숫자를 입력하여 주세요.");
		}
	}
	public void setTot() {
		this.tot = kor+eng+math;
	}
	
	public void setAvg() {
		this.avg = tot/3.0;
	}
	
	// 외부에서 데이터를 읽어가기 위한 get메서드
	//명칭(호칭) : get메서드, getter, get property(속성값 읽기)
	String getName() {
		return name;
	}
	
	boolean isLookgood() {
		return lookgood;
	}
	
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	
	public int getTot() {
		return tot;
	}
	
	public double getAvg() {
		return avg;
	}
	
	// private 과 set, get 은 결국.. 이용자의 오류를 막고 코드를 쉽게 유지보수하고자 만든 조립형 명령체계
	
	
	public void printData() {
		System.out.println(name + "\t" + kor + "\t" + eng + "\t" + math );
	}
	
	
	private void computeTotAvg() {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.0;
		
	}
	
	
	
	
	
	
	
}
