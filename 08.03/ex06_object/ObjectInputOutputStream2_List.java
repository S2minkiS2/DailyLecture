package com.mystudy.ex06_object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectInputOutputStream2_List {

	public static void main(String[] args) {
		// StudentVO 객체들을 ArrayList에 담아서 파일에 저장하고
		// 파일에서 읽어들인 ArrayList 객체에 담긴 VO 데이터를 화면출력
		// 사용할 파일명 : file/object_io_list.data
		//----------------------------------------------------
		// VO 데이터 생성 -> List에 저장 -> List를 파일에 출력
		// 파일에서 List 읽기 -> readObject() / List에 있는 VO 가져다 화면 출력

		StudentVO stu1 = new StudentVO("페페로니피자", 100, 100, 80);
		StudentVO stu2 = new StudentVO("포테이토피자", 90, 80, 70);
		StudentVO stu3 = new StudentVO("슈림프피자", 100, 50, 60);
		StudentVO stu4 = new StudentVO("바질폭탄피자", 40, 80, 100);

		ArrayList<StudentVO> list = new ArrayList<>(); //<StudentVO> 를 쓰지 않으면 Object 타입이 된다. 
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		
		
		//파일에 List 쓰고, 파일에서 List 읽어와서 담긴 데이터 화면 출력
		System.out.println("==== List 파일에 출력 (Output) ====");
		
		File file = new File("file/object_io_list.data");

		ObjectInputStream ois = null;
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) { //TWR
			
			// 파일에 List 쓰기
			oos.writeObject(list); // == 객체들이 담긴 박스를 한번에 옮기는 형식
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.println("==== 파일에서 List 읽기(Input) ====");
		
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			
			// 파일에서 읽기
			ArrayList<StudentVO> readList = (ArrayList<StudentVO>) ois.readObject(); // 가져온 데이터를 ArrayList readList에 담았따.
			
			// 방법 1 : 개선된 for문
			for (StudentVO vo : list) {
				System.out.println(vo.getName() +", " + vo.getTot() + ", " + vo.getAvg());
			}
			System.out.println();
			// 방법 2 : for 문
			for (int i = 0; i < readList.size(); i++) {
				StudentVO vo = readList.get(i);
				System.out.println(vo.getName() + " " + vo.getTot() + " " + vo.getAvg());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
