package com.mystudy.map2_ExamVO;

import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

public class StudentMapManagerMain {

	public static void main(String[] args) {
		StudentVO stu1 = new StudentVO("01", "신민기", 99, 99, 99); //학생번호를 int보다는 String 으로 "", 관리하기가 더욱 수월..
		StudentVO stu2 = new StudentVO("02", "오송민", 90, 60, 50);
		StudentVO stu3 = new StudentVO("03", "전의진", 80, 70, 50);
		StudentVO stu4 = new StudentVO("04", "최유정", 70, 80, 50);
		StudentVO stu5 = new StudentVO("05", "이주녕", 60, 90, 50);
		
		TreeMap<String, StudentVO> map = new TreeMap<>();
		map.put(stu1.getstudentID(), stu1);
		map.put(stu2.getstudentID(), stu2);
		map.put(stu3.getstudentID(), stu3);
		map.put(stu4.getstudentID(), stu4);
		map.put(stu5.getstudentID(), stu5);
		
		 
		System.out.println("학생번호\t성명\t영어\t컴퓨터\t음악\t총점\t평균");
		System.out.println("-----------------------------------------------------");
		
		Set<String> keySet = map.keySet();
		
		
		for (String key : keySet) {
			System.out.println(map.get(key).printData());
		}
		
		
//		map.replace("신민기", stu1.getMusic(), stu1.setMusic(80));

		for (String key : keySet) { // 향상된 for문이 중요하다.
			if ("신민기".equals(map.get(key).getName())){
				System.out.println("신민기 음악점수 수정 전 : "+ map.get(key).getMusic());
				map.get(key).setMusic(90);
				System.out.println("신민기 음악점수 수정 후 : "+ map.get(key).getMusic());
			}
		}
		
		
		for (String key : keySet) { 
				System.out.println(map.get(key));
			
		}
		
		Collection<StudentVO> values = map.values();
		for (StudentVO vo : values) {
			System.out.println(vo.getName() +"\t"+ vo.getEng() +"\t"+ vo.getCom() +"\t"+ vo.getMusic() +"\t"+ vo.getTot() +"\t"+ vo.getAvg());
		}
		
		

	}

}
