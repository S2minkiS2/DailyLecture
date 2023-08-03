package com.mystudy.ex06_object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectInputOutputStream_TWR {

	public static void main(String[] args) {
		// ObjectInputStream , ObjectOutputStream
		// Object 타입의 데이터를 사용해서 입출력(I/O)
		// ---------------------------------------
		// Object 타입의 데이터를 파일에 저장하고 읽어오기(StudentVO)
		
		// 파일에 저장할 데이터 준비
		System.out.println("----- 저장할 데이터 준비 -------");
		StudentVO stu1 = new StudentVO("신민기", 100, 90, 80);
		stu1.setPhoneNo("010-1111-2222");
		StudentVO stu2 = new StudentVO("김유신 지겨워", 94, 84, 74);
		stu2.setPhoneNo("010-3333-4444");
		
		System.out.println(stu1);
		System.out.println(stu2);
		System.out.println("==================================");
		
		File file = new File("file/object_io.data");
		
		
		// Java7부터 제공된 try~with~resource 구문으로 작성 = TWR
		// try (변수선언 및 생성구문) {} catch(){}
		// AutoCloseable 인터페이스 구현된 클래스만 사용가능, finally 구문 불필요.
		
		try (FileOutputStream fos = new FileOutputStream(file); 
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			
			
			System.out.println(">> 파일에 쓰기 - ObjectOutputStream 사용");
			// NotSerializableException : Seirializable 아니라서 예외, stu1이 implements Serializable 해야 실행 가능. 
			oos.writeObject(stu1); //StudentVO 데이터 하나 출력(쓰기)
			oos.writeObject(stu2);
			
			System.out.println(">> 파일에 쓰기 완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.println("================ 파일에서 읽어서 화면 출력 ==================");
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {
			
			System.out.println(">>> 파일로 부터 StudentVO 데이터 읽기");
			StudentVO stuIn1 = (StudentVO) ois.readObject();
			StudentVO stuIn2 = (StudentVO) ois.readObject();
			System.out.println(stuIn1);
			System.out.println(stuIn2);
			System.out.println("-------------------------------");
			System.out.println(stuIn1.getName() + ", " + stuIn1.getTot() + ", " + stuIn1.getAvg());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
