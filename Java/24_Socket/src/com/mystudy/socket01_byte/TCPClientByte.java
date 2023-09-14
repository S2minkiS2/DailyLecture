package com.mystudy.socket01_byte;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientByte {

	public static void main(String[] args) {
		// 클라이언트 : Socket 이용해서 서버에 접속(서버IP주소-어떤컴퓨터, 포트번호-어떤서비스)
		Socket socket = null;
		try {
			System.out.println("==== 클라이언트 ====");
			//				 IP주소, 포트번호
//			socket = new Socket("127.0.0.1", 10000); //현재pc(LocalPC) 접속주소
			socket = new Socket("localHost", 10000); //현재pc(LocalPC) 접속주소
			System.out.println(">> 서버연결 성송 socket : " + socket);
		
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//공던지기! OutputStream 이용해서 서버쪽으로 쓰기(출력)
//			System.out.println(">> 서버쪽으로 문자'A' 보내기");
//			os.write('A');
			
			String msg = "안녕하세요~ 반갑습니다.";
			System.out.println("서버로 보낸 메시지 : " + msg);
			byte[] buf = msg.getBytes(); 
			//getBytes() : 바이트 배열로 만들어줌
			os.write(buf);
		
			os.close();
			is.close();
			
		} catch (UnknownHostException e) { //호스트명없음
			e.printStackTrace();
		} catch (IOException e) { // 읽고쓰다가 발생하는 예외
			e.printStackTrace();
		}
		System.out.println(">> 클라이언트 종료");
	}

}
