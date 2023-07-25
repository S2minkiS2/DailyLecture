package com.mystudy.set2_exam_vo;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashSet;

public class StudentSetManagerMain {

	public static void main(String[] args) {

		StudentVO stu1 = new StudentVO(12, "라파엘", 90, 85, 70);
		StudentVO stu2 = new StudentVO(8, "가브리엘", 80, 75, 60);
		StudentVO stu3 = new StudentVO(25, "미카엘", 70, 95, 100);
		System.out.println(stu1); // toString메서드가 VO에 없으면 주소값을 반환.
		// --------------------------------------------------------------
		HashSet<StudentVO> set = new HashSet<>();
		set.add(stu1);
		set.add(stu2);
		set.add(stu3);

		System.out.println("학생번호\t성명\t영어\t컴퓨터\t음악\t총점\t평균");
		System.out.println("-----------------------------------------------");

		// set의 원본 자료형은 StudentVO, set의 자료들을 하나씩 StudentVO 자료형의 students에 대입해서 출력한다.
		// set은 데이터를 뽑아오지 못한다. 그래서 하나씩 가져오는 개선된 for문이나 Iterator를 써야한다.
		for (StudentVO students : set) {
			System.out.println(students.printData());
		}

		System.out.println();
		
		int searchNum = 25;
		String searchName = "미카엘";
		
		for (StudentVO students : set) {
			if (searchName.equals(students.getName()) && (students.getStudentNum() == searchNum)) {
				System.out.println(students.getName() + " 찾았다");
				students.setCom(100);
				students.computeTotAvg();
				System.out.println("점수 수정 후 : ");
				System.out.println(students.printData());
			}
		}

		Iterator<StudentVO> ite = set.iterator(); //StudentVO타입이 담기는 ite에 set을 iterator해서 넘겨준다.
		while (ite.hasNext()) {
			StudentVO stu = ite.next();
			System.out.println(stu); // println()이 toString()을 포함한다. 따라서 toString 출력 양식에 따라 결과가 달라진다?
			System.out.println("ite.hasNext() : " + ite.hasNext()); // boolean값 반환
		}

//		ArrayList<StudentVO> setArray = new ArrayList<StudentVO>(set); 
//		for (int i = 0; i < setArray.size(); i++) {
//			StudentVO vo = setArray.get(i);
//			vo.computeTotAvg();
//			System.out.println(vo.getStudentNum() + "\t"
//							+ vo.getName() + "\t"
//							+ vo.getEng() + "\t"
//							+ vo.getCom() + "\t"
//							+ vo.getMusic() + "\t"
//							+ vo.getTot() + "\t"
//							+ vo.getAvg());	
//		}
//		
//		System.out.println("--------------------- 미카엘 컴퓨터 점수 수정, 100점으로 --------------------");
//		int searchNum = 25;
//		String searchName = "미카엘";
//		for (int i = 0; i < setArray.size(); i++) {
//			StudentVO vo = setArray.get(i);
//			if (searchName.equals(vo.getName()) &&
//					searchNum == vo.getStudentNum()) {
//				System.out.println("com 수정 전 : " + vo);
//				vo.setCom(100);
//				vo.computeTotAvg(); //요소가 바뀌었으니 다시 계산
//				System.out.println("com 수정 후 : " + vo);
//				break;
//			} else {
//				System.out.println("학생번호 혹은 이름이 잘못 입력되었습니다."); //이걸 한번만 출력되게 하려면 어떻게 해야할까??
//			}
//		}
//		
//		System.out.println("-------------------------전체 출력------------------------------------");
//		for (StudentVO name : set) {
//			System.out.println(name);
//		}

	}

}
