package com.mystudy.ex02_buffered_filecopy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_Exam {

	public static void main(String[] args) {
		//(실습) OutputStreamWriter 객체 생성해서 텍스트 출력(한글,영문) 해보기
		
		File file = new File ("file/test_osw.txt");
		
		FileOutputStream fos = null;
		
		BufferedWriter bw = null;
		
		OutputStreamWriter osw = null;
		
		try {
			fos = new FileOutputStream(file);
			fos.write('A'); // 정상출력
			fos.write('대'); // 한글 정상 출력
			fos.write('\n');
			
			osw = new OutputStreamWriter(fos);
			osw.write("여행가고 싶지? 쏘 데스");
			osw.flush();
			
			bw = new BufferedWriter(osw);
			bw.newLine();
			bw.write("이것은 BufferedWriter 를 사용한 문장");
			bw.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (osw != null) osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}

}
