package com.mystudy.net_multi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


// 서버쪽으로 메시지 전송만!!! 
public class TCPClientMulti {

   public static void main(String[] args) {
      System.out.println(">> 클라이언트 시작 ~~~");
      Socket socket = null;
      
      PrintWriter pw = null;
      
      try {
         socket = new Socket("192.168.18.31", 10000);
         System.out.println(">> 서버 접속 완료");
      
         pw = new PrintWriter(socket.getOutputStream());
         Scanner scan = new Scanner(System.in);
         while(true) {
            System.out.print("메시지를 입력해주세요 : ");
            String msg = scan.nextLine();
            
            pw.println(msg);
            pw.flush(); 
            
            if ("exit".equals(msg)) {
               System.out.println("::메시지 전송을 중단합니다");
               break;
            }
         }
         
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         if (pw != null) pw.close();
         try {
            if (socket != null) socket.close();
         } catch (IOException e) {}
      }
      
      System.out.println(">> 클라이언트 종료");
   }

}