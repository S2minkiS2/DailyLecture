package com.mystudy.map2_exam_vo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.mystudy.list5_list_vo.StudentVO;

public class StudentMapManagerMain {

	public static void main(String[] args) {
		/*(실습) Map<K, V> 데이터 다루기
		 사용클래스명 : StudentVO, StudentMapManagerMain - main() 메소드
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		   "홍길동", 100, 90, 81
		   "이순신", 95, 88, 92
		   "김유신", 90, 87, 77
		   ---------------------
		2. Map<String, StudentVO> 타입의 변수(map)에 저장하고
		3. map에 있는 데이터를 사용해서 화면출력
		   성명    국어   영어  수학    총점     평균
		   --------------------------
		   홍길동   100  90  81  270  90.33
		   ...
		   -----------------------------
		4. 저장된 map에 있는 김유신 학생의 국어 점수를 95점으로 수정
		5-1. "김유신" 학생의 성적 화면 출력
		5-2. "김유신" 학생의 성명, 총점, 평균 화면 출력
		======================================= */
		//1. StudentVO 클래스를 사용해서
		//   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81);
		StudentVO stu2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO stu3 = new StudentVO("김유신", 90, 87, 77);
		
		//2. Map<String, StudentVO> 타입의 변수(map)에 저장하고
		Map<String, StudentVO> map = new HashMap<>();
		//객체 생성은 Class로만 가능하다.
		
		map.put(stu1.getName(), stu1); //이름 데이터를 key, 점수를 value
		map.put(stu2.getName(), stu2); // stu2에 있는 이름 getName으로 가져와!
		map.put(stu3.getName(), stu3);
		
//		System.out.println(map);
		
		System.out.println("=== 3. 전체 데이터 화면출력=========");
		//3. map에 있는 데이터를 사용해서 화면출력
//		   성명    국어   영어  수학    총점     평균
//		   --------------------------
		
//		   홍길동   100  90  81  270  90.33
//		   ...
//		   -----------------------------

		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");		
		System.out.println("---------------------------------------------");
		map.values();//value값 리턴
		Collection<StudentVO> values = map.values();
		for (StudentVO vo : values) // 가져다 사용할 집합 객체는 values다.
			System.out.println(	vo.getName() + "\t" + //vo에 있는 getName
					vo.getKor() + "\t" +
					vo.getEng() + "\t" +
					vo.getMath() + "\t" +
					vo.getTot() + "\t" +
					vo.getAvg() + "\t"
				);
		System.out.println("--------");
		
		//key를 전달 후 get 하면 value값만 가져다 쓸 수도 있다.
		Set<String> keys = map.keySet();
		System.out.println("keySet : " + keys);
		
		//keys에 저장된 것 하나하나 가져오기
		for(String key : keys) {
			StudentVO vo = map.get(key);
			printData(vo); //여러번 사용하기 때문에 메서드 생성해서 아래에!
		}
	
		System.out.println(map.keySet());
		
//		StudentVO vo 
//		for (int i = 0; i < 3; i++) {
//			System.out.println(
//			vo.getName() + "\t" + //vo에 있는 getName
//			vo.getKor() + "\t" +
//			vo.getEng() + "\t" +
//			vo.getMath() + "\t" +
//			vo.getTot() + "\t" +
//			vo.getAvg() + "\t"
//		);
//		}
		
//		String stu = map.keySet();
		//왜 String 타입이지? StudentVO는 어디가고?
//		Iterator<String, StudentVO> stu = map.keySet().iterator(); 
//		while (stu.hasNext()) {
//			StudentVO vo = stu.next(); //왜 String 타입???
//			System.out.println(stu.getName());
			
		
//		System.out.println(map.keySet());
//		System.out.println(map.values());		
//		Iterator<StudentVO> stu = map.iterator();
		
		
		
//	4. 저장된 map에 있는 김유신 학생의 국어 점수를 95점으로 수정
		String name = "김유신";
		int score = 95;
		StudentVO student = map.get(name); //studentVO타입 데이터로 줌. 왜??
		System.out.println("student : " + student);
		if (student == null) {
			System.out.println(">>> 데이터 없음");
		} else {
			student.setKor(score);
		}
		
		printData(student);
		
		System.out.println("--------------------");
		
		System.out.println("\n==== 5-1. 김유신 데이터 출력 ====");
//		5-1. "김유신" 학생의 성적 화면 출력
		
		
		
		
		
		
	
		System.out.println("\n==== 5-2. 김유신 이름, 총점, 평균 출력 ====");
//		5-2. "김유신" 학생의 성명, 총점, 평균 화면 출력
		//key값을 가지고 있으면 map에 요청만 하면 된다.
//		printData(map.get("김유신"));
		StudentVO kim = map.get("김유신");
		System.out.println(kim.getName() + ", " + kim.getTot() + ", " + kim.getAvg());
	}
		
	
	
	static void printData(StudentVO vo) {
		System.out.println(vo.getName() + "\t" + //vo에 있는 getName
				vo.getKor() + "\t" +
				vo.getEng() + "\t" +
				vo.getMath() + "\t" +
				vo.getTot() + "\t" +
				vo.getAvg() + "\t");
		
	}
		
}


	