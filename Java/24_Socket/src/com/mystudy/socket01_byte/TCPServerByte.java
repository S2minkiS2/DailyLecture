package com.mystudy.socket01_byte;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TCPServerByte {

	public static void main(String[] args) {
		// 서버측 : ServerSocket 객체가 클라이언트 접속을 기다린다.
		ServerSocket server = null;
		
		//객체생성, 생성자에 포트번호 넣어줌
		try {
			//서버에서 10000번 포트를 열고 서비스를 한다
			server = new ServerSocket(10000);
			System.out.println("현재컴퓨터IP : " + InetAddress.getLocalHost());
			System.out.println("[서버] 시작 후 클라이언트의 접속 대기중~");
			
			//서버에서 해당 포트로 접속한 클라이언트와 통신할 수 있는 소켓 생성
			Socket socket = server.accept(); 
			//클라이언트의 접속 대기. 리턴해주는 것은 소켓 객체
			//클라이언트에서 접속해야 위 객체 생성 코드가 실행된다.
			System.out.println("[서버] 1개 클라이언트 접속 : " + socket);
			//local포트는 서버쪽에서 local로 접속할 때 필요한거 
			
			InputStream is = socket.getInputStream();
			//읽어들일 수 있는 inputStream 객체를 얻을 수 있다.
			OutputStream os = socket.getOutputStream();
			//OutputStream 타입으로 리턴
			//입력, 출력 객체 전부 가지고있다. 이걸 이용해서 서로 통신!
			//서로 교착상태가 되지 않게 약속을 해야한다.
			
			// InputStream사용해서 클라이언트에서 보낸 데이터를 읽고, 화면에 표시
//			int readValue = is.read();
//			System.out.println("[서버] 클라이언트로부터 받은 메세지 : " + (char)readValue);
			
			byte[] buf = new byte[100];
			is.read(buf);
			System.out.println("buf : " + Arrays.toString(buf));
			System.out.println("[서버] 받은메시지 : " + new String(buf));
			
			os.close();
			is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	System.out.println(">> 서버 종료");
	}
}
