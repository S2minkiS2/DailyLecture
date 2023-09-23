package com.mystudy.ex06_object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStream_Exam2_twr {

	public static void main(String[] args) {
		// ObjectInputStream, ObjectOutputStream
		// Object 타입의 데이터를 사용해서 입출력(I/O)
		//-------------------------
		// 어떤 데이터 타입이든 다 써줄 수 있다.
		// Object 타입의 데이터를 파일에 저장하고 읽어오기(StudentVO)
		
		// 파일에 저장할 데이터 준비
		System.out.println("--- 저장할 데이터 준비 -----");
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81);
		StudentVO stu2 = new StudentVO("김유신", 95, 85, 75);
		
		System.out.println("stu1 : " + stu1);
		System.out.println("stu2 : " + stu2);
		System.out.println("==================");
		
		File file = new File("file/object_io.data");
		
		
		//java7부터 제공관 try~with~resource 구문으로 작성
		// try (변수 선언 및 생성구문) {} catch(){}
		//선언문과 함께 초기화 구문까지 같이 작성해주면 된다.
		// AutoCloseable 인터페이스 구현된 클래스만 사용가능
		
		try (FileOutputStream fos = new FileOutputStream(file);
			 ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			//try~with~resource로 자동 closing 처리
			
			System.out.println(">>> 파일에 쓰기 - ObjectOutputStream 사용");
			// NotSerializableException : Seirializable 아님 예외
			oos.writeObject(stu1); // StudentVO 데이터 하나 출력(쓰기)
			oos.writeObject(stu2);
			
			System.out.println(">>> 파일에 쓰기 완료 ------");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("===== 파일에서 읽어서 화면 출력=====");
		
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {
			
			System.out.println(">> 파일로부터 StudentVO 데이터 읽기");
			StudentVO stuIn1 = (StudentVO) ois.readObject();
			StudentVO stuIn2 = (StudentVO) ois.readObject();

			System.out.println("stuIn1 : " + stuIn1);
			System.out.println("stuIn2 : " + stuIn2);
			System.out.println("----------");
			System.out.println(stuIn1.getName() + ", " + stuIn1.getTot() + ", " + stuIn1.getAvg());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) { //사용할 수 있는 VO가 없으면 안되니까. 그래야 형식에 맞는 객체를 읽어오지
			// 클래스 없을 때 대비하는 예외
			e.printStackTrace();
		}
		
		
	}

}



