package com.mystudy.io1_file;

import java.io.File;

public class FileExam1 {

	public static void main(String[] args) {
		// File 클래스
		String seperator = File.separator; // 파일경로 구분자
		System.out.println("seperator : " + seperator);
		
		char separatorChar = File.separatorChar;
		System.out.println("separatorChar : " + separatorChar);
		
		String pathSeparator = File.pathSeparator;
		System.out.println("pathSeparator : " + pathSeparator); // 경로와 경로를 구분자
		
		System.out.println("------------------------------------------------------");
		
		File[] listRoots = File.listRoots();
		for (File file : listRoots) {
			System.out.println(file);
		}
		
	}

}
