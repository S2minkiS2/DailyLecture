package com.mystudy.socket03_echo_while;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientEcho {

	public static void main(String[] args) {
		// 클라이언트 : 쓰고, 읽기
		//서버 접속 후 메세지를 1번 보내고, -PrintWriter
		//서버에서 보내온 메시지를 받기 - BuffredReader - readline()
		// (출력) PrintWriter <-- OutputStream 
		// (입력) BufferedReader <-- InputStreamReader <-- InputStream
		//-------------------------
		//(추가) 보내는 메시지를 Scanner 사용, 화면에서 직접 입력 처리
		//------------------------------nextline()
		
		//1. 서버 접속하기 --> 소켓이 필요! 
		//소켓 객체부터 생성하자.
		// ->> 접속할 컴퓨터의 IP와 접근할 서비스의 port정보 입력.
		PrintWriter pw = null;
		Socket socket = null;
		BufferedReader br = null;
		
		try {
			socket = new Socket("localHost", 10000); //내컴퓨터, 포트번호:10000
			System.out.println("서버접속완료!"); //접속완!
			
		//2. 입출력 시작
			//PrintStream 사용해서 
			//printWriter를 쓰려면 상위메서드 먼저 넣어서 이어받아야함
			//소켓으로부터 입,출력 객체를 생성하라....? // 생성이 아니라 그 기능을 갖다 쓰는거다.
			//소켓이 쓰는 OutputStream을 써야하기 때문에. 
			// 그냥 새로 생성하는 OutputStream이 아니라 소켓끼리 통신할 수 있는 방법을 아는 메서드인거다!
			// 소켓에 저장된 걸 가져와서 써야 그 기능을 이용할 수 있다.
			
//			OutputStream os = socket.getOutputStream();
//			pw = new PrintWriter(os);
			//줄바꿈 문자 있는데까지 읽고 끝내므로 println을 사용
			pw = new PrintWriter(socket.getOutputStream());
//			pw.println("야~~~~호~~~~"); //쓰기
//			pw.flush(); //버퍼에 있는 데이터 강제 출력
//			System.out.println("보낸메시지> " + msg);
			
			//스캐너 이용해서 입력받기
//			Scanner scan = new Scanner(System.in);
//			String msg = scan.nextLine();
//			pw.println(msg); //쓰기
//			scan.nextLine();
//			
//			System.out.println(">>1. 첫번째 출력완료. 처음 보냈다!");
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
//
//			//이제부터 br 사용 가능!
//			msg = br.readLine();
//			//줄바꿈 문자 있는데까지 읽고 끝냄!
//			System.out.println("4. >받은메시지" + msg);
//			
			//쓰고읽기반복
			String readValue = "야호야호";
			//스캐너
			Scanner scan = new Scanner(System.in);
			while (true) {
				readValue = scan.nextLine();
				pw.println(readValue);
				pw.flush();
				readValue = br.readLine();
				System.out.println(readValue);
				if (readValue == "그만") {
					System.out.println("서버가 닫혔습니다.");
					break;
				}
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close(); //출력, 입력용 객체들을 닫고 소켓(맨마지막)도 닫는다.
			if (br != null)
				try {
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			try {
				if (socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(">>> 클라이언트 종료");
		
	}

}
