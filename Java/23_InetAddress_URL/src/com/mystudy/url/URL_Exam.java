package com.mystudy.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URL_Exam {

	public static void main(String[] args) throws MalformedURLException {
		// 프로토콜://호스트(서버):포트번호(생략됨)/경로(패스)?질의(query)
	  //   https://sports.news.naver.com/news?oid=076&aid=0004039737
		
		URL url = new URL("http", "mystudy.com", 8080, "/aaa/bbb/index.jsp?id=hong&password=1234#content");
		//http://mystudy.com:8080/aaa/bbb/index.jsp?id=hong&password=1234#content
		//이 서버에 가면 aaa라는 폴더 bbb라는 디렉토리 그 아래 파일이 있다.
		
		System.out.println("url : " + url);
		
		String protocol = url.getProtocol();
		String host = url.getHost();
		int port = url.getPort();
		int defaultPort = url.getDefaultPort();//기본포트
		String path = url.getPath(); //경로
		String query = url.getQuery(); //물음표 뒤 key equal value //할수도안할수도
		String ref = url.getRef(); //참조위치정보 //할수도안할수도
		
		System.out.println("프로토콜(protocol-약속 : " + protocol);
		//http . 
		System.out.println("호스트(host) : " + host);
		//mystudy.com 서버명
		System.out.println("포트번호(port) : " + port);
		System.out.println("기본포트(defaultPort) : " + defaultPort);
		System.out.println("경로-패스(path : " + path);
		System.out.println("쿼리-질문(query) : " + query);
		System.out.println("참조(reference) : " + ref);
		System.out.println("----------------");
		
		url = new URL("https://sports.news.naver.com/news?oid=076&aid=0004039737\r\n");
		System.out.println("url : " + url);
		
		 protocol = url.getProtocol();
		 host = url.getHost();
		 port = url.getPort();
		 defaultPort = url.getDefaultPort();//기본포트
		 path = url.getPath(); //경로
		 query = url.getQuery(); //물음표 뒤 key equal value //할수도안할수도
		 ref = url.getRef(); //참조위치정보 //할수도안할수도
		
		System.out.println("프로토콜(protocol-약속 : " + protocol);
		//http . 
		System.out.println("호스트(host) : " + host);
		//mystudy.com 서버명
		System.out.println("포트번호(port) : " + port);
		System.out.println("기본포트(defaultPort) : " + defaultPort);
		System.out.println("경로-패스(path : " + path);
		System.out.println("쿼리-질문(query) : " + query);
		System.out.println("참조(reference) : " + ref);
	
	}

}
