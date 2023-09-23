package com.mystudy.bean;

public class StudentMain {

	public static void main(String[] args) {
		Student stu = new Student();
		System.out.println("stu : " + stu.toString());
		//toString은 오브젝트 클래스의 메소드다.
		// 만든 적도 없지만 나의 부모 Object클래스에 있는 메소드이기에 사용

//		System.out.println("stu.name : " + stu.name);
		 //이 기능을 통해서만 접근할 수 있다. //not visible
		
		stu.setName("홍길동");
		String name = stu.getName();
		System.out.println("name : " + name);
		
		System.out.println("입력 전 kor : " + stu.getKor());
		stu.setKor(999);
		System.out.println("입력 후 kor : " + stu.getKor());
		
		System.out.println("입력 전 eng : " + stu.getEng());
		stu.setEng(90);
		System.out.println("입력 후 eng : " + stu.getEng());
		
		System.out.println("입력 전 math : " + stu.getMath());
		stu.setMath(80);
		System.out.println("입력 후 math : " + stu.getMath());
		
		int tot = stu.getKor() + stu.getEng() + stu.getMath();
		System.out.println("tot : " + tot);
		stu.setTot(tot); //계산된 합계 데이터를 Student 타입의 객체 필드에 저장
		
		double avg = tot * 100/ 3/ 100.0;
		stu.setAvg(avg);
		
		stu.printData();  //객체에 있는 것을 출력,호출 rorcpstu에~
	
		System.out.println("==== 생성자 사용 데이터 입력 ====");
		Student stu2 = new Student("김유신", 100, 92, 80);
		stu2.printData();
	

}
}
