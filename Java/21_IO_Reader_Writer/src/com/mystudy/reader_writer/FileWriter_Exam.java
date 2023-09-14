package com.mystudy.reader_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_Exam {

	public static void main(String[] args) {
		System.out.println("-----main() 시작------");
		// FileWriter : 파일에 문자단위 출력(쓰기)
		File file = new File("file/test_char_out.txt");
		
		FileWriter fw = null;
		//Writer계열에는 내부적으로 Buffer가 있다
		//buffer는 채워지면 (1024byte) 출발한다.
		//그렇기 때문에 close 처리가 필수. 안하면 출발을 안함
		
		try {
			//1. 객체(인스턴스) 생성
			fw = new FileWriter(file);
			
			//2. 객체 사용 (파일에 문자단위 출력)
			fw.write('대');
			fw.write("한");
			fw.write("민국");
			
			fw.flush(); // 버퍼에 있는 데이터를 강제로 Output 처리
			//통로는 살아있는 상태로 보낼 수 있다!
			
			fw.write("Hello Java!!");	
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3.사용 객체 닫기
			try {
				if (fw != null) fw.close(); 
				// 버퍼에 있는 데이터를 (있으면) 출력하고 종료
				//close하게되면 buffer에 있는 데이터 내보내고 close
				//통로를 닫는다.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("-----main() 끝-----");

	}

}
