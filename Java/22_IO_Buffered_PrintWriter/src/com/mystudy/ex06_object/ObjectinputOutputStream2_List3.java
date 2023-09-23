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

public class ObjectinputOutputStream2_List3 {

	public static void main(String[] args) {
		// (실습)StudentVO 객체들을 ArrayList에 담아서 파일에 저장하고
		// 파일에서 읽어들인 ArrayList 객체에 담긴 VO데이터를 화면 출력
		// 사용할 파일명 : file/object_io_list.data
		//--------------------------------------
		//VO 데이터 생성 --> list에 저장 --> List를 파일에 출력
		//파일에서 List 읽기  --> List에 있는 VO 데이터 가져다 화면 출력
		
		//StudentVO에 값을 주기
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81);
		StudentVO stu2 = new StudentVO("이순신", 95, 88, 92);
		StudentVO stu3 = new StudentVO("김유신", 90, 87, 77);
		
		//StudentVO를 담은 배열리스트(ArrayList)
		ArrayList<StudentVO> list = new ArrayList<>();
		//StudentVO 타입의 ArrayList 객체 list 생성
		
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		
		
		//파일에 List 쓰고, 파일에서 List 읽어와서 담긴 데이터 출력
		//파일에 저장--------------------------
		
		//finally에서의 사용 위해 변수 빼주기
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		//파일 객체 생성
		File file = new File("file/object_io_list.data");
		try {//생성한 파일을 fos에 주입
			fos = new FileOutputStream(file);
			 //생성한 fos를 oos에 주입
			oos = new ObjectOutputStream(fos);
			// oos사용해서 file에 list를 저장! 완료!
			oos.writeObject(list);
			// 파일에서 읽어들인 ArrayList 객체에 담긴 VO데이터를 화면 출력
			System.out.println(list);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//파일에서 List 읽기
		//변수 뺴기
		FileInputStream fis = null; 
		ObjectInputStream ois = null;
		
		//읽어들이기
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
		// 파일에서 읽어들인 ArrayList 객체에 담긴 VO데이터를 화면 출력
		//ois 사용해서 읽어들이기
			ArrayList al = (ArrayList)ois.readObject();
			
			//반복문 사용해서 값 출력
			System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
			for (StudentVO vo : list) {
				System.out.println(vo.getName() + "\t" + vo.getKor()  + "\t" + 
						vo.getEng() + "\t" +  vo.getMath() 
						+ "\t" +  vo.getTot() + "\t" + vo.getAvg());
			}
			
			
			
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}