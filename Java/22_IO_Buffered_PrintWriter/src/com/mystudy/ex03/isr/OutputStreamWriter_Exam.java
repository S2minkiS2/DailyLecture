package com.mystudy.ex03.isr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_Exam {
	
	public static void main(String[] args) {
		File file = new File("file/test_osw.txt");
		FileOutputStream fos = null;
		// (실습)OutputStreamWriter 객체 생성해서 텍스트 출력
		// Hello Java~~ 안녕!!!
		OutputStreamWriter osw = null;
				
		
		try {
			// FileOutputStream 사용 문자 출력
			fos = new FileOutputStream (file);
			fos.write('A'); //아스키코드에 해당하는 문자는 정상출력
//			fos.write('안'); //결과가 이상하게 나온다. 한글은 3만번대
			
			osw	= new OutputStreamWriter(fos);
			osw.write("Hello Java~~ 안녕!!!");
			osw.flush();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		} try {
			if (fos != null) fos.close();
			if (osw != null) osw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
