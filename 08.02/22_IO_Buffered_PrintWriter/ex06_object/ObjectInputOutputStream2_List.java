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

//		StudentVO[] stuArr = new StudentVO[4];
//		stuArr[0] = stu1;
//		stuArr[1] = stu2;
//		stuArr[2] = stu3;
//		stuArr[3] = stu4;
		
		ArrayList<StudentVO> stuList = new ArrayList<>();
		stuList.add(stu1);
		stuList.add(stu2);
		stuList.add(stu3);
		stuList.add(stu4);
		
		File file = new File("file/object_io_list.data");

		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));

//			oos.writeObject(stuList.get(0));
//			oos.writeObject(stuList.get(1));
//			oos.writeObject(stuList.get(2));
//			oos.writeObject(stuList.get(3));
			oos.writeObject(stuList);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			
			ArrayList arIn = (ArrayList) ois.readObject();
			
//			StudentVO inStu1 = (StudentVO) ois.readObject(); //ois에 있는 객체들이 Object 타입이므로 형변환을 해줘야 출력가능
//			StudentVO inStu2 = (StudentVO) ois.readObject();
//			StudentVO inStu3 = (StudentVO) ois.readObject();
//			StudentVO inStu4 = (StudentVO) ois.readObject();
			
			for (StudentVO student : stuList) {
				System.out.println(student.getName() +", " + student.getKor() +", " + student.getEng() +", " + student.getMath() 
								+ ", " + student.getTot() + ", " + student.getAvg());
			}
			
//			System.out.println(inStu2);
//			System.out.println(inStu3);
//			System.out.println(inStu4);

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
