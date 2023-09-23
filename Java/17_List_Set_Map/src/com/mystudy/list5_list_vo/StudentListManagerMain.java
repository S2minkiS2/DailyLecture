package com.mystudy.list5_list_vo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentListManagerMain {

	public static void main(String[] args) {
		/* (실습) List를 사용한 성적 처리
		사용클래스명 : StudentVO, StudentListManagerMain - main() 메소드
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		   "홍길동", 100, 90, 81
		   "이순신", 95, 88, 92
		   "김유신", 90, 87, 77
		2. ArrayList 타입의 변수(list)에 저장하고
		3. list에 있는 전체 데이터 화면출력
		   성명   국어  영어  수학  총점  평균
		   ---------------------------------
		   홍길동  100  90  81   270  90.33
		   ...
		4. 김유신 국어 점수를 95 점으로 수정 후 김유신 데이터만 출력
		5. 전체 데이터 화면 출력
		========================================== */
		//1. StudentVO 클래스를 사용해서
		//   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81);
		System.out.println("stu1 : " + stu1);
		System.out.println("이름(성명) : " + stu1.getName());
		
		StudentVO stu2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO stu3 = new StudentVO("김유신", 90, 87, 77);
		System.out.println("stu3 : " + stu3);
		
		System.out.println("== 2. ArrayList 만들고 StudentVO 저장하기");
		//2. ArrayList 타입의 변수(list)에 저장하고
		//ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		//LinkedList<StudentVO> list = new LinkedList<StudentVO>();
		List<StudentVO> list = new ArrayList<StudentVO>();
		//List<StudentVO> list = new LinkedList<StudentVO>();
//		list.add(new StudentVO("홍길동", 100, 90, 81));
//		list.add(new StudentVO("이순신", 95, 88, 92));
//		list.add(new StudentVO("김유신", 90, 87, 77));
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		
		System.out.println("list : " + list);
		System.out.println("list.size() : " + list.size());
		
		System.out.println("== 3. list에 화면출력 =============");
		//3. list에 있는 전체 데이터 화면출력
		System.out.println("--- tot, avg 계산처리 ----");
		for (StudentVO vo : list) {
			vo.computeTotAvg();
		}
		System.out.println("stu3 : " + stu3);
		
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------");
		
		for (int i = 0; i < list.size(); i++) {
			StudentVO vo = list.get(i);
			//vo.setTot(vo.getKor() + vo.getEng() + vo.getMath());
			System.out.println(vo.getName() + "\t" + 
					vo.getKor() + "\t" + 
					vo.getEng() + "\t" +
					vo.getMath() + "\t" + 
					vo.getTot() + "\t" +
					vo.getAvg());
		}
		System.out.println("---------");
		for (StudentVO vo : list) {
			System.out.println(vo.getName() + "\t" + 
					vo.getKor() + "\t" + 
					vo.getEng() + "\t" +
					vo.getMath() + "\t" + 
					vo.getTot() + "\t" +
					vo.getAvg());
		}
		System.out.println("-----------");
		for (StudentVO student : list) {
			printData(student);
		}
		
		System.out.println("===4. 데이터 수정 처리 ==========");
		//4. 김유신 국어 점수를 95 점으로 수정 후 김유신 데이터만 출력
		//list.get(2).setKor(95); //(X)내가 데이터를 눈으로 확인해서 사용
		//System.out.println(list.get(2));
		
		String name = "김유신";
		int score = 95;
		for (StudentVO student : list) {
			if (name.equals(student.getName())) {
				student.setKor(score);
				student.computeTotAvg();
				break;
			}
		}
		System.out.println("------");
		printData(list, "김유신");
		printData(list, "이순신");
		
		//5. 전체 데이터 화면 출력
		System.out.println("===5. 전체 데이터 화면 출력 ==========");
		printData(list);
		
		System.out.println("=======================");
		//StudentVO equals() 구현 후 contains(), indexOf() 정상동작
		System.out.println("list.contains(stu1) : " + list.contains(stu1));
		System.out.println("list.contains(stu2) : " + list.contains(stu2));
		System.out.println("list.indexOf(stu1) : " + list.indexOf(stu1));
		System.out.println("----------");
		StudentVO test = new StudentVO("홍길동", 0, 0, 0);
		//StudentVO test = new StudentVO("을지문덕", 0, 0, 0);
		System.out.println("list.contains(test) : " + list.contains(test));
		System.out.println("list.indexOf(test) : " + list.indexOf(test));
		
		System.out.println("===== 김유신 국어점수 88점으로 수정 ===");
		StudentVO kim = new StudentVO("김유신", 88, 0, 0);
		System.out.println("list.contains(kim) : " + list.contains(kim));
		System.out.println("list.indexOf(kim) : " + list.indexOf(kim));
		System.out.println("----------");
		
		int idx = list.indexOf(kim);
		StudentVO listKim = list.get(idx);
		System.out.println("리스트 원본 : ");
		printData(listKim);
		
		System.out.println(">> 국어 점수 수정 처리~~~~");
		listKim.setKor(kim.getKor());
		listKim.computeTotAvg();
		
		System.out.println("리스트 수정본 : ");
		printData(listKim);
	}
	
	static void printData(StudentVO vo) {
		System.out.println(vo.getName() + "\t" + 
				vo.getKor() + "\t" + 
				vo.getEng() + "\t" +
				vo.getMath() + "\t" + 
				vo.getTot() + "\t" +
				vo.getAvg());
	}
	
	static void printData(List<StudentVO> list) {
		for (StudentVO student : list) {
			printData(student);
		}
	}
	
	static void printData(List<StudentVO> list, String name) {
		for (StudentVO student : list) {
			if (name.equals(student.getName())) {
				printData(student);
				//break;
			}
		}
	}
	
	static  StudentVO getData(List<StudentVO> list, String name) {
		for (StudentVO student : list) {
			if (name.equals(student.getName())) {
				return student;
			}
		}
		return null;
	}
}


