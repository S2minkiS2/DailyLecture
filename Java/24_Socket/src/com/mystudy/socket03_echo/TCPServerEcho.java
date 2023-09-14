package com.mystudy.socket03_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEcho {

	public static void main(String[] args) {
		// 서버 : 읽고, 쓰기
		// 클라이언트가 보내온 메시지를 1번 받고(읽기) - BufferedReader -readLine()쓸수있음
		// 받은 메시지를 클라이언트에게 다시 보내기 - PrintWriter 
		// (입력) BufferedReader <-- InputStreamReader <-- InputStream
		// (출력) PrintWriter <-- OutputStream 

		//1. 소켓이 있어야해! 소켓 객체부터 생성하자.
		// 둘을 연결할 때 서버소켓이 진짜 서비스하는 부분이므로 서버에 생성.
		// 서버 쪽 소켓 객체는 서비스할 포트번호를 꼭 넣어줌. 어디에 접속하느냐.
		
		ServerSocket server = null;
		PrintWriter pw = null;
		BufferedReader br = null;

		
		try {
			server = new ServerSocket(10000);
			
			// 2.클라이언트와 통신할 수 있는 소켓 (Server객체) 만들기.
			// 접속을 기다렸다가 접속하면 객체가 생성되도록 만들자!
			Socket socket = server.accept();
			System.out.println(">> 클라이언트 접속!" + socket);
			
			//3. 입출력 시작
			//클라이언트가 먼저 출력했으니 서버는 입력부터 받자!
			
			//소켓인풋을 할줄아는 놈으로다가 데려옴
//			InputStream is = socket.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is);
//			BufferedReader br = new BufferedReader(isr);
			//bufferedReader 쓰는 이유 : readLine 쓰려고.
			//------------------------->>>>>>
			br = new BufferedReader
					(new InputStreamReader(socket.getInputStream()));
			//이제부터 br 사용 가능!
			String msg = br.readLine();
			//보낼 때도 써야하니까 변수에 저장해준다.
			//줄바꿈 문자 있는데까지 읽고 끝냄!
			System.out.println("2. 받은메시지> " + msg);

			//받은 메시지 클라이언트에게 보내기
//			OutputStream os = socket.getOutputStream();
//			PrintWriter pw = new PrintWriter(os);
			//------------------------->>>>>>
			pw = new PrintWriter(socket.getOutputStream());
			
			pw.println(msg); //받은걸 되돌려보내자~
			//줄바꿈 문자 있는데까지 읽고 끝내므로 println을 사용
			System.out.println(">>3. 보낸메시지! " + msg);
			pw.flush(); //퉤! 버퍼에 있는 데이터 출력!
			
			//읽고쓰기반복
			while (true) {
				msg = br.readLine();
				System.out.println(msg);
				pw.println(msg);
				pw.flush();
				if (msg == "그만") {
					System.out.println("서버가 닫혔습니다.");
					break;
				}
			} 
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				server.close();
				System.out.println("close> server");
			} catch (IOException e) {
				e.printStackTrace();
			}			
			if (pw != null) pw.close(); //출력, 입력용 객체들을 닫고 소켓(맨마지막)도 닫는다.
			if (br != null)
				try {
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			try {
				if (server != null) server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

}

