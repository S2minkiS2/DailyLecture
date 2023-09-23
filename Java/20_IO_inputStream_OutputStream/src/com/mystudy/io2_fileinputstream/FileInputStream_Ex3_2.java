package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStream_Ex3_2 {

	public static void main(String[] args) {
		//(실습) Ex3_1 파일을 반복문으로 변경
		
		//0. 사용할 file객체 만들기
		//1. 파일을 읽어서 작업할 객체 생성fileInputStream
		//2. 객체 사용 파일데이터 읽어서 화면에 출력
		//byte[]사용, 반복문으로 반복처리
		//데이터 갯수가 적을 때면 하나하나 할 수 있지만 
		//갯수가 많으니 반복작업을 반복문으로 바꿔야할 것
		//3. 객체 닫기

		File file = new File("file/test01.txt");
		
		//Unhandled exception type FileNotFoundException이므로
		//try-catch문으로 예외처리 : 만약 file을 못찾았다면??? 예외!
		
		
		FileInputStream fis = null;
		try { 
			fis = new FileInputStream(file); 
			// FileInputStream 타입의 객체 fis
			//file객체를 작업할 객체에 주입받음
			//1. 파일을 읽어서 작업할 객체 생성 : fis
			
			//2. 객체 사용 파일데이터 읽어서 화면 출력
			byte[] bytes = new byte[10]; //배열 객체 생성
			System.out.println("bytes배열 : " + Arrays.toString(bytes));
			//bytes배열은 10개 값이 주어진 빈 객체(아직은)
			
			//input - 문자를 읽을 땐 read사용
			//FileInputStream타입의 객체 fis의 메서드 read() 사용
			// 읽은 결과를 byte배열에 넣어준다.
//			readCnt = fis.read(bytes);
//			System.out.println(readCnt + "개 읽었습니다.");
//			System.out.println("bytes배열 : " + Arrays.toString(bytes));
			//한번에 읽어서 처리할 수 있는 값의 max는 배열의 갯수
			// readCnt가 -1이면 읽을게없다는 뜻
		
			int readCnt; 
			while(true) {
				readCnt = fis.read(bytes);
				if (readCnt == -1) break;
				System.out.println(readCnt + "개 읽었습니다.");
				System.out.println("bytes배열 : " + Arrays.toString(bytes));
				for (int i = 0; i < readCnt; i++) {
					System.out.print(bytes[i] + " ");
				}
 			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 객체 닫기(close)
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
		
		
		