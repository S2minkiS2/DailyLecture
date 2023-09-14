package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileinputStream_Ex1 {

	public static void main(String[] args) {
		System.out.println("======main() 시작=========");
		File file = new File("temp.txt");
		
		
		//파일을 못찾으면(파일이없으면) 발생하는 예외
		FileInputStream fis = null;
		//필드에 만들어지는 변수는 초기값으로 자동 셋팅이 되지만
		//로컬변수는 반드시 값이 저장된 후에 사용해야한다.
		try {
			//파일로부터 읽기 위한 작업 진행
			//1. 사용할 객체 생성
			fis = new FileInputStream(file);

			//2. 객체 사용 작업 처리
			int readValue = fis.read(); //1바이트 읽기
			System.out.println("read() int값 : " + readValue);
			System.out.println("char타입 read() : " + (char)readValue);
			
			System.out.println("--- 전체 데이터 읽어서 화면출력---");
			while (true) {
				// EOF (End Of File)를 만나면(더이상 읽을 것이 없으면) -1 리턴
				readValue = fis.read(); //1바이트 읽기
				if (readValue == -1) break; //파일의 끝(EOF)면 읽기 종료
				System.out.println("read() int값 : " + readValue);
				System.out.println("char타입 read() : " + (char)readValue);
			}
			
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("[예외발생] " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//3. 객체 사용 후 닫기 (close)		
			if(fis != null) { //fis가 null이 아니면 close해라
				try {
					fis.close();
				} catch (IOException e) { }
			}
			//선언이 안된 이유 : 중괄호 기준이므로 아래에선 선언이 안됨
			//따라서 try구문 밖에서 변수선언을 하기
			//핸들링 해줘야. IO exception 예외처리를 해야함
		}
		System.out.println("====끝===============");
			

	}

}
