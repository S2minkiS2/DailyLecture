package com.mystudy.io3_fileoutputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileOutputStream_Exam {

	public static void main(String[] args) {
		// fileOutputStream : byte 단위로 파일에 저장(출력, 쓰기)
		File file = new File("file/test_out_01.txt");
		
		//변수를 밖에 선언하는 이유는 finally절에서 사용하기 위해
		FileOutputStream fos = null;
		try {
			//1. 사용할 객체를 생성한다.
			fos = new FileOutputStream(file); //새로 내용 삭제 후 쓰기
			//fos = new FileOutputStream(file, true); //내용추가모드
			//항상 새로 작성
			
			//2. 객체를 사용해서 작업처리  
			fos.write('H');
			fos.write('E');
			fos.write('L');
			fos.write('L');
			fos.write('O');
			//String전달은 안되지만 char타입은 가능
			
			byte[] bytes = "Hello java!".getBytes();
			System.out.println("bytes : " + Arrays.toString(bytes));
			
			fos.write(bytes);
			fos.write('\n');
			
			//시작위치~사용할갯수
			fos.write(bytes, 0, bytes.length); //0번에서 데이터갯수만큼
			fos.write('\n');
		
			fos.write(bytes, 6, 4); //0번에서 데이터갯수만큼
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 사용객체 닫기(close)
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {}
			}
		}
		
		

	}

}