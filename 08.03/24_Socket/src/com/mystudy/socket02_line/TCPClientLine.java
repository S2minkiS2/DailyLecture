package com.mystudy.socket02_line;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientLine {

	public static void main(String[] args) throws UnknownHostException {
		// 서버접속 후 printwriter 사용해서 메시지 1번 보내기
		// OutputStream --> PrintWriter 
		//--------------------------------------------------------------------------------------------
		System.out.println(">>> 클라이언트 시작");
		Socket socket = null;
		
		System.out.println("현재컴퓨터IP : " + InetAddress.getLocalHost());
		System.out.println(">>> 서버에 접속을 시도");
		
		
		try {
			// 1. 소켓생성 : 접속할 IP주소, 포트정보로 서버 접속
			socket = new Socket(InetAddress.getLocalHost(), 1000);
			System.out.println(">> 서버 접속 성공");
			
			// 2. 소켓으로 부터 입출력 객체 생성 - InputStream, OutputStream
			InputStream is = socket.getInputStream();
			
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
			// 3. 전송(out)할 데이터가 있으면 쓰기(writer)
			String msg = "자몽블랙티 더 마시고 싶다.";
			pw.print(msg);
			pw.print("잘 되고 있스므니까??");
//			pw.println("ㅎㅎㅎㅎㅎㅎ ㅋㅋㅋㅋㅎㅎㅎㅎㅋㅋㅋ");
			
			pw.flush();
			
			
			// 4. 읽을 데이터가 있으면 읽기
			// 구현 안할랭
			
			pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
				socket.close();
				System.out.println("close> Socket close 완료");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println(">>> 클라이언트 종료");
		
	}

}
