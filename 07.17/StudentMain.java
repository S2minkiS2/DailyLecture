package com.mystudy.bean;

public class StudentMain {

	public static void main(String[] args) {
		Student stu = new Student(); // Student 클래스가 default 타입이어서
//		System.out.println(stu.name);
	
		stu.setName("신민기");
		String myname = stu.getName(); // return으로 받은 값, 이름을 가져와서 name 변수에 저장.
		System.out.println("name : " + myname);
		
		stu.setLookgood(false);
		boolean lookgd = stu.isLookgood();
		System.out.println(myname + "는 " + ((lookgd == true) ? "겁나게 잘생기셨어요." : "그래도 잘생기셨어요."));
		
		//다른 클래스에서 상세내역을 숨기고, 메서드만 제공 (캡슐화)
		System.out.println("=========================================================================");
		
		int tot = (stu.getEng() + stu.getKor() + stu.getMath());
		System.out.println(tot);
		
		stu.printData();
		
		System.out.println("==== 생성자 사용 데이터 입력 ====");
		
		Student raphael = new Student("raphael", 80, 90, 100);
		raphael.printData();
		
		
	}

}
