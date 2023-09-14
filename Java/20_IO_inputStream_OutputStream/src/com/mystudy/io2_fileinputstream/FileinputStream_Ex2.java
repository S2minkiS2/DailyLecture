package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileinputStream_Ex2 {

	public static void main(String[] args) {
		File file = new File("file/test01.txt");
		
		FileInputStream fis = null; //기본값주기
		
		try {
			// 1.사용할 객체 생성
//			fis = new FileInputStream(file);
			//생성자를 통해 File 객체 주입 (전달받아) 사용

			fis = new FileInputStream("file/test01.txt");
			//파일 관련 정보를 문자열로 갖고있다면 그걸 줘도 됨
			
			
			
			// 2. 객체 사용
//			int readValue = fis.read();
//			while(readValue != -1) { //-1이 아니면 출력해라
//				System.out.println("read() int값 : " + readValue);
//				//한번만 읽고 끝! =>내용 없으면 결과는 -1
//				System.out.println(">>char : " + (char)readValue);
//				readValue = fis.read();
//			}
			
			int readValue;
			while((readValue = fis.read()) != -1) {
				//소괄호. 이게 1이 아니면.
				//내가 읽은 값이 readValue에 저장,
				//반복문에 따라 -1이 아닐때 반복
				System.out.println("read() int값 : " + readValue);
				System.out.println(">>char : " + (char)readValue);
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 3. 객체 닫기
			//null 체크
			if (fis != null) { //fis가 null이 아니면 close하겠다
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		System.out.println("--- main의 끝 ---");
		//이 메세지가 출력되면 예외 발생했어도 잡아서 정상처리한것
		
		}
		
		

	}

}
