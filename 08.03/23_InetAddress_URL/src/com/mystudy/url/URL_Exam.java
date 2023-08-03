package com.mystudy.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URL_Exam {

	public static void main(String[] args) throws MalformedURLException {
		// 프로토콜: //호스트(서버):포트번호/경로(path)          ?질의(query)
		// https: //blog.naver.com   /elarpi/223159230577?&isInf=true
		
		URL url = new URL("http", "mystudy.com", 8080, 
				"/aaa/bbb/index.jsp?id=shin&password=1234#content");
		//http://mystudy.com:8080/aaa/bbb/index.jsp?id=shin&password=1234#content
		System.out.println("url : "+ url);
		
		String protocol = url.getProtocol();
		String host = url.getHost();
		int port = url.getPort();
		int defaultPort = url.getDefaultPort();
		String path = url.getPath();
		String query = url.getQuery();
		String ref = url.getRef();
		
		
		System.out.println("프로토콜(protocol) : " + protocol);
		System.out.println("호스트(host) : " + host);
		System.out.println("포트(port) : " + port);
		System.out.println("기본 포트(defaultPort) : " + defaultPort);
		System.out.println("패스(path) : " + path);
		System.out.println("쿼리(query) : " + query);
		System.out.println("참조(ref) : " + ref);
		
		System.out.println("--------------------------------------------------------------------");
		url = new URL("https://blog.naver.com/baby0817/223155860598?&isInf=true");
		System.out.println("URL : " + url);
		
		protocol = url.getProtocol();
		host = url.getHost();
		port = url.getPort();
		defaultPort = url.getDefaultPort();
		path = url.getPath();
		query = url.getQuery();
		ref = url.getRef();
		
		System.out.println("프로토콜(protocol) : " + protocol);
		System.out.println("호스트(host) : " + host);
		System.out.println("포트(port) : " + port);
		System.out.println("기본 포트(defaultPort) : " + defaultPort);
		System.out.println("패스(path) : " + path);
		System.out.println("쿼리(query) : " + query);
		System.out.println("참조(ref) : " + ref);
		
	}

}
