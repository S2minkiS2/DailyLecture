package com.mystudy.list5_list_vo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentListManagerMain {

	public static void main(String[] args) {
		/* (실습) List를 사용한 성적 처리
		사용클래스명 : StudentVO, StudentListManager - main() 메소드
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
		System.out.println("------------문제1---------------");
		StudentVO one = new StudentVO("신민기", 100, 90, 81);
		StudentVO two = new StudentVO("미카엘", 95, 88, 92);
		StudentVO three = new StudentVO("가브리엘", 90, 87, 77);
		
		System.out.println("------------문제2---------------");
		//ArrayList<StudentVO> list = new ArrayList<>(); // ArrayList는 배열 형식의 List이다.
		List <StudentVO> list = new ArrayList<>();
		//LinkedList<StudentVO> list = new LinkedList<>();  // LinkedList가 중간부분 업데이트에있어 비교적 속도의 이점이 있다. 
		//List <StudentVO> list = new LinkedList<>(); // ArrayList와 LinkedList 모두 List 타입에 들어간다.
		System.out.println("list.size() : " + list.size());
		list.add(new StudentVO ("신민기", 100, 90, 81));
		list.add(new StudentVO ("미카엘", 95, 88, 92));
		list.add(new StudentVO ("가브리엘", 90, 87, 77));
//		list.add(one);
//		list.add(two);
//		list.add(three);
		System.out.println("대입 후 list.size() : " + list.size());
		
		System.out.println("------------문제3---------------");
//		one.computeTotAvg();
//		two.computeTotAvg();
//		three.computeTotAvg();
		for (StudentVO vo : list) { // 위의 메서드들을 한번에.
			vo.computeTotAvg();
		} 
		
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() + "\t"+ list.get(i).getKor() +"\t"+ list.get(i).getEng() 
								+"\t"+ list.get(i).getMath() +"\t"+ list.get(i).getTot() +"\t"+ list.get(i).getAvg());
		} //단점: 계속 하나하나 주고받는 방식은 비효율적이다. 데이터가 많아질 경우 속도 문제가 생길 수 있다.
		
		System.out.println("===== list.get()을 변수에 대입 후 출력 ======");
		for (int i = 0; i < list.size(); i++) {
			StudentVO vo = list.get(i); //list.get(i)를 여러번 쓸 것이기에, 정보를 한번에 다 가져다 놓고 쓰자. 속도&&효율
			System.out.println(vo.getName() + "\t"+ vo.getKor() +"\t"+ vo.getEng() 
								+"\t"+ vo.getMath() +"\t"+ vo.getTot() +"\t"+ vo.getAvg());
		}
		
		System.out.println("------------문제4---------------"); // 김유신 대신 가브리엘.
		System.out.println("가브리엘 Kor점수 수정 전 : " + three.getKor());
		
		//선생님 추천 방법
		String searchName = "가브리엘"; // 이렇게 변수를 할당하면 이름을 바꿔 수정할 때 편하다.
		for (StudentVO vo : list) {
			if (searchName.equals(vo.getName())) {
				vo.setKor(95);
				vo.computeTotAvg(); // 점수가 바뀌었으니 토탈평균도 다시 해줘야 업데이트 된다.
				break; // "가브리엘"이 딱 한명일 경우
			}
		}
		System.out.println("가브리엘 성적 : " + list.get(2));
		
		System.out.println("---------------위는 선생님 코드, 아래는 내 코드----------------------");
		//아래는 내가 한 방법
		for (int i =0; i < list.size(); i++) {
			if ("가브리엘".equals(list.get(i).getName())) { 
				list.get(i).setKor(95);
				list.get(i).computeTotAvg(); //점수가 바뀌었으므로 토탈평균 리 업데이트
				System.out.println("list.get(i).setKor(95) 실행 후 : " + list.get(i).getKor());
			}
		}
		
		
		System.out.println("가브리엘 Kor점수 수정 후 : " + three.getKor());
		System.out.println("가브리엘 성적 : " + list.get(2));
		
		System.out.println("------------문제5---------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("========================================================");
		// StudentVO equals() 구현 후 contains(), indexOf() 정상동작
		System.out.println("list.contains(one) : " + list.contains(one)); //같은 객체 있냐없냐
		System.out.println("list.contains(two) : " + list.contains(two)); //같은 객체 있냐없냐
		System.out.println("list.indexOf(two) : " + list.indexOf(two)); //저장된 위치 
//-----------------------------------------------------------------------------		
//		StudentVO one = new StudentVO("신민기", 100, 90, 81);
//		StudentVO two = new StudentVO("미카엘", 95, 88, 92);
//		StudentVO three = new StudentVO("가브리엘", 90, 87, 77);
//-----------------------------------------------------------------------------
//		list.add(new StudentVO ("신민기", 100, 90, 81));
//		list.add(new StudentVO ("미카엘", 95, 88, 92));
//		list.add(new StudentVO ("가브리엘", 90, 87, 77));
//		list.add(one);
//		list.add(two);
//		list.add(three);
// 첨에 만든 변수 one, tow, three가 가리키는 인스턴스의 주소와, new생성자로 add한 객체는 서로 다른 데이터이기에 (!= 주소값), contains에서 false가 나오는 것이다.
// 하지만 equals()를 
		System.out.println("---------------------------");
		StudentVO test = new StudentVO("가브리엘", 0, 0, 0); //"가브리엘이 3번째 데이터여서 equals()를 세번 실행" 찾았다 = true
		StudentVO test2 = new StudentVO("라파엘", 0, 0, 0); //"3번 했는데 못찾았다 = false"
		System.out.println("list.contains(test) : " + list.contains(test));
		System.out.println("list.indexOf(test) : " + list.indexOf(test));
		System.out.println("list.contains(test2) : " + list.contains(test2));
// equals()로 재정의를 해주면, name만 같아도 같은 객체로 분류할 수 있게된다. equals를 하지 않으면 모든 데이터가 같지 않을 경우 다른 객체라고 판단한다.
		
		
		System.out.println("===== 가브리엘 국어점수 88점으로 수정 ===== equals 보기");
		StudentVO kim = new StudentVO("가브리엘", 88, 0, 0);
		System.out.println(list.contains(kim)); // equals()가 없으면 완전 동일한 데이터가 아니기에 false가 나온다. 업데이트가 불가능해진다.
		System.out.println(list.indexOf(kim)); // equals()를 키면 위치를 찾아 업데이트가 가능해진다.
		
		int idx = list.indexOf(kim);
		list.get(idx); //얘가 가브리엘 데이터임
		StudentVO listKim = list.get(idx);
		System.out.println("리스트 원본 : " + listKim);
		listKim.setKor(kim.getKor());
		listKim.computeTotAvg();
		System.out.println("리스트 수정본 : " + listKim);

// equals()와 hashCode()를 쓰는 이유는 객체를 좀더 쉽게 찾고 데이터를 수정하기 위해서. 		
		
		
	}
	
}
