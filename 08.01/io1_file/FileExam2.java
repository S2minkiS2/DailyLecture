package com.mystudy.io1_file;

import java.io.File;
import java.io.IOException;

public class FileExam2 {

	public static void main(String[] args) throws IOException { // == 파일을 객체로 만들어 수정하는 방법 등 
		// 파일명 : temp.txt - 파일명.확장자(명)
		File file1 = new File("temp.txt"); //==  ./temp.txt 
		// File 객체 생성은 파일의 존재여부와 관계없이 객체 생성이 가능하다.
		System.out.println("file1 : " + file1);
		
		// 상대경로 방식 (. : 현재위치, .. : 상위디렉토리(폴더))
		// 현재위치에 따라서 경로가 다르게 변함
		File file2 = new File("./file/temp.txt"); //현재위치의 file폴더 아래 temp.txt
		System.out.println("file2 : " + file2);
		
		// 절대주소 방식 : Root 디렉토리로 부터 전체 경로를 표시(위치 불변)
		File file3 = new File("c:\\temp\\abc\\temp.txt"); //역슬레시가 자바에서 제어문자 부호이기 때문에 2개를 써야한다.
		System.out.println("절대경로 file1 : " + file1.getAbsolutePath());
		System.out.println("절대경로 file2 : " + file2.getAbsolutePath());
		System.out.println("절대경로 file3 : " + file3.getAbsolutePath());
			
		System.out.println("---------- getAbsolutePath() : 절대경로명--------");
		System.out.println("file1.getAbsolutePath() : " 
							+ file1.getAbsolutePath());  
		System.out.println("file2.getAbsolutePath() : " 
							+ file2.getAbsolutePath());  
		//절대경로명은 내가 정의한 주소대로 전달받아 리턴된다.
		// 내 위치에 관계없이 경로표시가 일정하다
		
		System.out.println("---------- getCanonicalPath() : 정식경로명--------");
		System.out.println("file1.getCanonicalPath() : " 
							+ file1.getCanonicalPath()); // throws IOException
		System.out.println("file2.getCanonicalPath() : " 
							+ file2.getCanonicalPath()); // throws IOException
		//정식경로명은 ..을 빼고 컴퓨터 정식의 주소대로 리턴된다. 
		// == 상대주소 방식, 내 위치가 달라짐에 따라 표시가 달라진다
		
		System.out.println("--------- exists() 파일의 물리적 존재여부 확인 ---------");
		System.out.println("file1 있니? : " + file1.exists()); // file1 은 temp.txt로 만든 객체이다.
		System.out.println("file2 있니? : " + file2.exists());
		System.out.println("file3 있니? : " + file3.exists()); // 경로에 들어가면 temp.txt가 실제로 있다 == true
		
		System.out.println("--------- File 속성정보 ---------");
		System.out.println("file1.length() : " + file1.length()); // 파일 사이즈 
		System.out.println("file1.length() : " + file1.canRead()); // 읽을 수 있는 파일이니?
		System.out.println("file1.length() : " + file1.canWrite()); // 쓸 수 있는 파일이니?
		System.out.println("file1.length() : " + file1.canExecute()); // 실행할 수 있는 파일이니?
		
		System.out.println("-------------");
		System.out.println("file1.getName() : " + file1.getName());
		System.out.println("file2.getName() : " + file2.getName()); // 물리적으로 존재하지 않아도 이름 출력이 가능
		System.out.println("file3.getName() : " + file3.getName());
		
		System.out.println("------ isDirectory(), isFile() --------  ");
		System.out.println("file1.isDirectory() : "+ file1.isDirectory()); // 이게 디렉토리니?
		System.out.println("file1.isFile() : "+ file1.isFile()); // 이게 파일이니?
		
		System.out.println("====================================");
		File file4 = new File("File/temp4.txt");
		//System.out.println("file4.delete() : "+ file4.delete()); // 삭제? 물리적으로 없으므로 삭제 불가
		
		System.out.println("file4.createNewFile() : " + file4.createNewFile()); // 새로만들기, 경로까지 만들어주지 않는다. 
		
		System.out.println("====================================");
		File file5 = new File("temp1/temp2/temp3");
		
		System.out.println("file5.mkdirs() : "+ file5.mkdirs());
		
		
		
	}

}
