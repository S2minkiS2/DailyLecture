package com.mystudy.socket02_line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerLine {

	public static void main(String[] args) {
		// 서버쪽 : 클라이언트가 보내온 메세지를 1번 읽어서 화면에 출력
		// BufferedReader //readline()사용하면 한 줄 읽어서 쓸 수 있다. (1번읽기)
		// 최종 사용은 BufferedReader <-- inputStream //다이렉트 넣기 불가
		//왜냐 bufferedReader 바이트 계열을 바로 읽을 수 없어서
		//Bufferedreader <-- InputStreamReader <-- InputStream
		//buffer기능에서는 readLine()이 있고 라인단위 읽어줌
		//-----------------------------------------
		System.out.println(">> 서버 시작----------");
		//서버소켓을 저장할 변수
		ServerSocket server = null;
		//서버소켓 객체 생성
		try {
			//1. ServerSocket 객체생성 - 서비스할 포트번호(port) 지정
			server = new ServerSocket(10000);
			System.out.println(">> 서버(ServerSocket) 대기중~~");
			System.out.println("서버/IP : " + InetAddress.getLocalHost());
			
			//2. 서버소켓 대기중 접속한 Socket과 통신할 수 있는 Socket 객체 생성
			Socket socket = server.accept(); // 접속하면 받겠다~소켓객체
			System.out.println(">> 클라이언트 접속됨 : " + socket);
			
			//3. Socket으로부터 입력InputStream, 출력OutputStream 객체 생성 (저장된걸참조)
			OutputStream os = socket.getOutputStream(); //주세용
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is); //Reader계열로 바꿔줌
			BufferedReader br = new BufferedReader(isr); //그냥 is는 Reader계열이 아니라 못쓴다.
			
			//4. 받을 메세지가 있으면 읽기
			String msg = br.readLine();
			System.out.println("[서버-받은메세지]" + msg);
			
			//5. 보낼 메세지가 있으면 보내기
			//구현안함
					
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (server != null) server.close();
			 //서버 닫는 경우 거의 없지만 닫을 수도 있긴함
				System.out.println("close> ServerSocket close 완료");
			} catch (IOException e) {
				e.printStackTrace();
		}
		
		}
		System.out.println(">> 서버가 종료되었습니다.");
	}

}