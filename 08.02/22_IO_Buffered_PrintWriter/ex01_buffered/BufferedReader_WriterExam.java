package com.mystudy.ex01_buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReader_WriterExam {

	public static void main(String[] args) {
		// 버퍼(buffer) 기능이 구현되어 있는 클래스
		// 버퍼 : 데이터를 저장하는 공간(메모리상에)
		// BufferedReader, BufferedWriter
		// File -> FileReader ->  BufferedReader(최종사용)    ->> 이걸 기억하세요.
		//--------------------------------------------------
		System.out.println("------------ 메인 시작 ---------------");
		
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		// 변수를 선언 해주고...
		
		try {
			
			// 파일로 부터 읽기 위한 객체(인스턴스) 생성
			File inFile = new File("file/test_buf_rw_in.txt"); 	// File 타입을 만들어서
			fr = new FileReader(inFile);						// File 객체를 FileReader 매개변수로 넣은 객체를 만들고,
			bufferedReader = new BufferedReader(fr); // 버퍼기능 + 파일 읽기 기능    // 그 객체를 Buffer의 매개변수로 넣어 객체를 만들어.
			
			// 파일에 쓰기 위한 객체(인스턴스) 생성
			File outFile = new File("file/test_buf_rw_out.txt");
			fw = new FileWriter(outFile);
			bufferedWriter = new BufferedWriter(fw); // 버퍼기능 + 파일 쓰기 기능
			
			// -------------------------------------------------------------최종사용은 BufferedReader 와 BufferedWriter... 
			// 파일에 먼저 쓰기 
			bufferedWriter.write("신민기입니다. 알리오올리오 파스타 좋아합니다. \n");
			bufferedWriter.write("전 삶은 고기도 좋아하고, 구운 고기도 좋아해요. 튀긴 건 조금만 먹어요.");
			bufferedWriter.newLine(); // 개행
			bufferedWriter.write("배고파요????");
			bufferedWriter.newLine();
			bufferedWriter.write("------------");
			bufferedWriter.newLine();
			
			bufferedWriter.flush();
			
			// 파일로 부터 읽고, 파일에 쓰기 (버퍼기능 사용)
			// 파일에서 읽기(한 번 읽기)
			String str = bufferedReader.readLine();
			System.out.println("readLine() 읽은 값 : " + str);
			
			// 파일에 쓰기 (한 번 쓰기)
			bufferedWriter.write(str); //다른 파일의 텍스트를 불러와 복사 붙여넣기.
			bufferedWriter.newLine(); //줄바꿈
			
			// 남은 데이터 모두 읽고 쓰기
			str = bufferedReader.readLine(); // readLine()는 더이상 데이터가 없을 때, -1이 아니라 null 값을 return한다.
			while (str != null) {
				bufferedWriter.write(str);
				str = bufferedReader.readLine(); // 얘 위치가 위면 실행 안됨
				if (str != null) {
					bufferedWriter.newLine(); // 줄바꿈, 더 없으면 줄바꿈 안함
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bufferedWriter != null)	bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("------------ 메인 끝 ---------------");
		
	}
}
