package com.mystudy.set2_exam_vo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.mystudy.list5_list_vo.StudentVO;

public class StudentSetManagerMain {

	public static void main(String[] args) {
		/* (실습) Set 중 HashSet 또는 TreeSet 사용
		 사용클래스명 : StudentVO, StudentSetManagerMain - main() 메소드
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		   "홍길동", 100, 90, 81
		   "이순신", 95, 88, 92
		   "김유신", 90, 87, 77
		   ---------------------
		2. Set 타입의 변수(set)에 저장하고
		3. set에 있는 데이터를 사용해서 화면출력
		   성명   국어  영어  수학  총점  평균
		   ---------------------------------
		   홍길동  100  90  81   270  90.33
		   ...
		4. "김유신" 국어 점수를 95 점으로 수정
		5. 수정된 "김유신" 데이터만 출력 확인
		6. 전체 데이터 화면 출력
		======================================== */
		//1. StudentVO 클래스를 사용해서
		//   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81);
		StudentVO stu2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO stu3 = new StudentVO("김유신", 90, 87, 77);
		
		//2. Set 타입의 변수(set)에 저장하고
		Set<StudentVO> set = new HashSet<>();
		System.out.println("set : " + set);
		set.add(stu1); //set은 데이터 하나만 가져와서 볼 방법 없음
		set.add(stu2);
		set.add(stu3); //VO에서 toString 구현 안해두면 ??
		
//		3. set에 있는 데이터를 사용해서 화면출력
//		   성명   국어  영어  수학  총점  평균
//		   ---------------------------------
//		   홍길동  100  90  81   270  90.33
//		   ...
		
		for (StudentVO vo : set) {
			vo.computeTotAvg();
			System.out.println("vo : " + vo);
		} //순차적으로 vo에 데이터를 준다.
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------------------");
		//일반 for문을 사용할 수 없었음.. 
		//set은 데이터 하나만 콕 찝어 가져올 수 없다. 첫번째 개념의 데이터가 없다.
		//특정 데이터를  가져올 수 없기 때문에!
		for (StudentVO vo : set) {
			System.out.println(
			vo.getName() + "\t" + //vo에 있는 getName
			vo.getKor() + "\t" +
			vo.getEng() + "\t" +
			vo.getMath() + "\t" +
			vo.getTot() + "\t" +
			vo.getAvg() + "\t"
		);
		}
		
		Iterator<StudentVO> ite = set.iterator(); 
		//iterator타입의 객체를 사용. StudentVO타입이 담겨있다.
		
		//있냐? 있으면 갖다씀. while문
		while (ite.hasNext()) {
			 StudentVO vo = ite.next(); //Next()는 StudentVO타입(손대보기)
				System.out.println(
						vo.getName() + "\t" +
						vo.getKor() + "\t" +
						vo.getEng() + "\t" +
						vo.getMath() + "\t" +
						vo.getTot() + "\t" +
						vo.getAvg() + "\t" );
		}
		//있냐 물어보고 하나만 꺼내 써라.
		
		
//		System.out.println(stu1);
//		System.out.println(stu2);
//		System.out.println(stu3);
		
		
//		4. "김유신" 국어 점수를 95 점으로 수정
		
		String name = "김유신";
		int score = 95;
		for (StudentVO student : set) {
			if (name.equals(student.getName())) {
				student.setKor(score);
//				student.computeTotAvg();  //기능에서 구현함
				//항상 재계산처리가 돼야함. 그래서 VO에서 바꿔넣음!
			}
		}
		
//		5. 수정된 "김유신" 데이터만 출력 확인
		printData(stu3);    //오ㅐ 안나오지??
		//아래에 프린트데이터 메서드를 작성해줘야함
		
		
//		6. 전체 데이터 화면 출력
		
		System.out.println("=====김유신 수정 후=====");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------------------");
		for (StudentVO vo : set) {
			System.out.println(
			vo.getName() + "\t" +
			vo.getKor() + "\t" +
			vo.getEng() + "\t" +
			vo.getMath() + "\t" +
			vo.getTot() + "\t" +
			vo.getAvg() + "\t"
		);
		}
	
	}


	private static void printData(StudentVO vo) {
		// TODO Auto-generated method stub
		 System.out.println(vo.getName() + "\t" +
							vo.getKor() + "\t" +
							vo.getEng() + "\t" +
							vo.getMath() + "\t" +
							vo.getTot() + "\t" +
							vo.getAvg() + "\t" );
	}



}
