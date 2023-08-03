package com.mystudy.socket03_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClientEcho {

	public static void main(String[] args) throws UnknownHostException {
		// 클라이언트 : 쓰기, 읽기
		// 서버접속 후 메시지를 1번 보내고 (PrintWriter)
		// 서버에서 보내온 메시지를 받기 (BufferedReader)
		// PrintWriter <- OutputStream
		// BufferedReader <- InputStreamReader <- InputStream
		//--------------------------------------------
		//(추가) 보내는 메시지를 Scanner를 사용, 화면에서 직접 입력하여 처리
		//-----------------------------------------------------
		
		System.out.println(">>> 클라이언트 시작");
		Socket socket = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("현재컴퓨터IP : " + InetAddress.getLocalHost());
		System.out.println(">>> 서버에 접속을 시도");
		
		try {
			// 보냄
			socket = new Socket("192.168.18.11", 100);
			System.out.println("서버에 접속하셨습니다.");
			
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while (true) {
				System.out.print("할말을 직접 입력하시오 : ");
				String scmsg = scan.nextLine();
				pw.println(scmsg);
				pw.flush();
				if ("끝".equals(scmsg)) break;

				// 받음
				String str = br.readLine();
				System.out.println("[클라이언트가 받은 메시지] : " + str);
				
			}
			
			pw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
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

	private static PrintWriter PrintWriter(OutputStream os) {
		// TODO Auto-generated method stub
		return null;
	}

	private static InputStreamReader InputStreamReader(InputStream is) {
		// TODO Auto-generated method stub
		return null;
	}

	private static BufferedReader BufferedReader(InputStreamReader isr) {
		// TODO Auto-generated method stub
		return null;
	}

}
