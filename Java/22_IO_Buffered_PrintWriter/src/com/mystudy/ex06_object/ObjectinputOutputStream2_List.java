package com.mystudy.ex06_object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectinputOutputStream2_List {

	public static void main(String[] args) {
		// (실습)StudentVO 객체들을 ArrayList에 담아서 파일에 저장하고
		// 파일에서 읽어들인 ArrayList 객체에 담긴 VO데이터를 화면 출력
		// 사용할 파일명 : file/object_io_list.data
		//--------------------------------------
		//VO 데이터 생성 --> list에 저장 --> List를 파일에 출력
		//파일에서 List 읽기  --> List에 있는 VO 데이터 가져다 화면 출력
		
		
		//StudentVO 객체들을 ArrayList에 담아서 파일에 저장
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81);
		stu1.setPhoneNo("010-1111-1111");
		StudentVO stu2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO stu3 = new StudentVO("김유신", 90, 87, 77);
		stu2.setPhoneNo("010-2222-2222");
		ArrayList<StudentVO> list = new ArrayList<StudentVO>();
		//ArrayList<타입> 변수명 = new ArrayList<타입>();
		
		list.add(stu1);
		list.add(stu2);
		list.add(stu3); //ArrayList타입 list에 정보를 저장해준다.
		
		//파일에 List 쓰고, 파일에서 List 읽어와서 담긴 데이터 출력

		//파일 객체 만들기
		File file = new File("file/object_io_list.data");
		// List를 출력해야하니 Object 사용, 
		// file에 출력해야하니 File~ 사용.
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try { // 정보를 저장한 list 객체를 파일에 입력한다. write
			fos = new FileOutputStream(file); //FileOutputStream에 file객체 주입
			oos = new ObjectOutputStream(fos); // ObjectOutputStream에 fos 주입
			oos.writeObject(list); // list 객체를 파일에 입력
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null)
				try {
					oos.close(); //buffer가 있으므로 닫아줘야 입력됨.
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
				
		//파일에 입력된 정보 읽어오기 (Input)
		try {
			fis = new FileInputStream(file); //파일을 읽어온다
			ois = new ObjectInputStream(fis); 
			//객체까지 읽을 수 있는 큰 걸로 읽어올 수 있게 확장 
			//ois로 list가 담긴 파일의 정보를 읽어올 수 있다.
			
			//list의 정보가 담겼으므로 타입을 ArrayList로 맞춰준다.
			//Object로 할 것 없이 리턴을 list 타입으로.
			//우측이 object, 좌측 lsit니까 우측을 ArrayList로 형변환.
			ArrayList<StudentVO> ol = (ArrayList<StudentVO>) ois.readObject();
			//배열 정보를 각각 얻어와 stu에 저장해준다.
			stu1 = (StudentVO) ol.get(0);
			stu2 = (StudentVO) ol.get(1);
			stu3 = (StudentVO) ol.get(2);
			
			System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
			for(StudentVO vo : list) { // for(타입 저장할변수명 : 배열-집합객체)
				System.out.println(vo.getName() + "\t" + vo.getKor()  + "\t" + 
						vo.getEng() + "\t" +  vo.getMath() 
						+ "\t" +  vo.getTot() + "\t" + vo.getAvg());
			}
			
			for (int i = 0; i < ol.size(); i++) {
				StudentVO vo = ol.get(i);
				System.out.println(vo.getName());
			} 
			
//			System.out.println(stu1.getName() + "\t" + stu1.getKor()  + "\t" + 
//					stu1.getEng() + "\t" +  stu1.getMath() 
//					+ "\t" +  stu1.getTot() + "\t" + stu1.getAvg());
//			System.out.println(stu2.getName() + "\t" + stu2.getKor()  + "\t" + 
//					stu2.getEng() + "\t" +  stu2.getMath() 
//					+ "\t" +  stu2.getTot() + "\t" + stu2.getAvg());
//			System.out.println(stu3.getName() + "\t" + stu3.getKor()  + "\t" + 
//					stu3.getEng() + "\t" +  stu3.getMath() 
//					+ "\t" +  stu3.getTot() + "\t" + stu3.getAvg());
			

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
			
			System.out.println("실행완료");
	

	}

}
