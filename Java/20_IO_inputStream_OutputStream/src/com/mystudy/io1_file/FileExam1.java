package com.mystudy.io1_file;

import java.io.File;

public class FileExam1 {

	public static void main(String[] args) {
		// File 클래스
	String seperator = File.separator; // 속성 이름
	//file의 경로구분자
	// C:\MyStudy\10_Java  //역슬래시
	System.out.println("File.seperator : " + seperator);
	
	char separatorChar = File.separatorChar;
	System.out.println("File.separatorChar : " + File.separatorChar);
	
	String pathSeparator = File.pathSeparator;
	System.out.println("File.pathSeparator : " + pathSeparator);
	System.out.println("-------------------");
	
	File[] listRoots = File.listRoots();
	for (File file : listRoots) {
		System.out.println(file);
	}
	
	
	
	}

}
