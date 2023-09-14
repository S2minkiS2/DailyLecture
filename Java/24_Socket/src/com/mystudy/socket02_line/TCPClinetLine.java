package com.mystudy.socket02_line;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClinetLine {

	public static void main(String[] args) throws UnknownHostException {
		// 1. 서버 접속 후 PrintWriter 사용 // byte계, 문자계 다 사용가능
		// 메세지 한 번 보내기
		// 2. OutputStream --->PrintWriter 를 new 해서 내보낸다.
		//--------------------------------------------
		System.out.println(">>>> 클라이언트 시작");
		Socket socket = null;
		
		System.out.println("현재 컴퓨터IP : " + InetAddress.getLocalHost());
		System.out.println(">>> 서버 접속 시도~");
		
		//소켓 객체 만들기
		try {
			//1. 소켓(Socket) 생성 : 접속할 IP주소, 포트(port) 정보로 서버 접속
			socket = new Socket(InetAddress.getLocalHost(), 10000);
			System.out.println(">>> 서버 접속 성공!!");
			
			//2. 소켓으로부터 입,출력 객체 생성 (가져오기, 참조)
			//- InputStream과 OutputStream
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			//출력 위한 객체
			PrintWriter pw = new PrintWriter(os); 
			//PrintWriter는 OutputStream과 Writer둘다 사용가능
			
			// 3. 전송(out)할 데이터가 있으면 쓰기(write)
			String msg = "안녕하세요. 소켓통신 공부중~";
			pw.print(msg);
			pw.print("잘 되고 있나요?");
			pw.println("ㅎㅎㅎㅎㅎㅎ!!!"); //줄바꿈문자 넣어줌. 여기까지 데이터 읽는다. readline이.
			
			pw.flush();//close해서 굳이 필요는 없긴한데~
			
			//4. 읽을 데이터가 있으면 읽기 //구현안함
			
			
			
//			pw.close(); //버퍼라서 close나 flush해줘야함
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) {
				socket.close(); //원래 서버는 닫는거 아냐
				System.out.println("close> Socket close 완료");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(">>>> 클라이언트 종료");
		}
		
		
	
	
	
	
	}

}
