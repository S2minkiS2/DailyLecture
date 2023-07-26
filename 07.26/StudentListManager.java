package com.mystudy.list5_list_vo;

import java.util.ArrayList;
import java.util.List;

class StudentVO01 {
	private String name;
	private int age;
	private boolean merried;
	private String add;

	public StudentVO01(String name, int age, boolean merried, String add) {
		super();
		this.name = name;
		this.age = age;
		this.merried = merried;
		this.add = add;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMerried() {
		return merried;
	}

	public void setMerried(boolean merried) {
		this.merried = merried;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "StudentVO [name=" + name + ", age=" + age + ", merried=" + merried + ", add=" + add + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentVO01 other = (StudentVO01) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

/*
 * 성적처리를 위한 관리용 클래스를 생성 CRUD 기능을 구현하고 확인하시오 (학생 정보를 List에 저장하고 관리하되 이름은 중복되지
 * 않는다) 
 * ■ 클래스명 : StudentListManager 
 * ■ 속성(필드변수) : StudentVO 저장을 위한 List 
 * ■ 기능(메소드)
 * - select : StudentVO 타입 데이터를 전달받아 동일한 이름 데이터를 찾아서 리턴 
 * - select : 이름(String)을 전달받아 동일한 이름 데이터 찾아서 리턴
 * - insert : StudentVO 타입 데이터를 전달받아 List에 추가
 * - update : StudentVO 타입 데이터를 전달받아 List에서 동일데이터 찾아서 수정 
 * - updateKor : 이름(String)으로 찾아 국어점수를 수정 
 * - delete : StudentVO 타입 데이터를 전달받아 List에서 동일데이터 찾아서 삭제 
 * - delete : 이름(String)을 전달받아 동일한 이름 데이터 삭제
 */
public class StudentListManager {
	
	List<StudentVO01> list = new ArrayList<StudentVO01>();
	
	// select 메서드 - StudentVO01 데이터 타입 전달
	public StudentVO01 select(String searchName) {
		for (int i = 0; i < list.size(); i++) {
			if (searchName.equals(list.get(i).getName())) {
				return list.get(i);
			}
		}
		System.out.println(searchName + "라는 이름을 찾지 못하였습니다.");
		return null;
	}
	
	
	// select 메서드 - 이름 전달
	public StudentVO01 select(StudentVO01 stu) {
		for (int i = 0; i < list.size(); i++) {
			if (stu.equals(list.get(i).getName())) {
				return list.get(i);
			}
		}
		System.out.println(stu + "에 대한 정보를 찾지 못하였습니다.");
		return null;
	}

	// insert 메서드
	public static void addToList(List<StudentVO01> list, StudentVO01 stu) {
	    list.add(stu);
	}
	
	
	public static void main(String[] args) {
		
		List<StudentVO01> list = new ArrayList<StudentVO01>();
		
		StudentVO01 stu1 = new StudentVO01("라파엘", 30, false, "한국");
		StudentVO01 stu2 = new StudentVO01("미카엘", 25, false, "미국");
		StudentVO01 stu3 = new StudentVO01("가브리엘", 20, false, "일본");
		StudentVO01 stu4 = new StudentVO01("루시퍼", 15, false, "러시아");

		addToList(list, stu1);
		addToList(list, stu2);
		addToList(list, stu3);
		addToList(list, stu4);
		
		
		
		
	}

}
