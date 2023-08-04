package com.mystudy.socket04_echowhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEchoWhile {

	public static void main(String[] args) {
		// 서버쪽 : 읽고, 쓰기
		// 클라이언트가 보내온 메시지를 1번 받고(읽기) - BufferedReader
		// 받은 메시지를 클라이언트에게 다시 보내기 - PrintWriter
		// BufferedReader <- InputStreamReader <- InputStream
		// PrintWriter <- OutputStream
		//------------------------------------------------------------

		System.out.println(">>> 서버 시작 ~~~");
		ServerSocket server = null;

		try {
			server = new ServerSocket(100);

			System.out.println("서버 IP:포트번호 - " + InetAddress.getLocalHost().getAddress() + ":"
													+ server.getLocalPort());
			System.out.println(">> 서버(ServerSocket) 대기중~~ ");

			Socket socket = server.accept();
			
			System.out.println(">> 클라이언트 접속됨 : " + socket);

			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
//			최종 객체만 사용할 것이라면, 하위 클래스 객체들을 변수에 대입할 필요는 없었다.
//			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
//			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			while (true) {
				String str = br.readLine();
				System.out.println("[서버가 받은 메시지] : " + str);
				if ("끝".equals(str)) {
					System.out.println("상대방이 접속을 종료하셨습니다.");
					break;
				}
				
				// 받은 메시지를 클라이언트에게 되돌려 보내기
				System.out.println("[서버] 받은메세지 클라에게 되돌려 보내기 성공");
				
				pw.println(str);
				pw.flush(); // 버퍼에 있는 데이터 강제로 출력
			}
			
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (server != null) {
					server.close();
					System.out.println("close> ServerSocket close 완료");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(">>> 서버종료");
	}

}
