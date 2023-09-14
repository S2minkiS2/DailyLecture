package com.mystudy.ex05_data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStream_Exam {

	public static void main(String[] args) {
		// DataInputStream, DataOutputStream
		// 기본 데이터 타입 데이터 읽고, 쓰기
		//----------------------
		//파일에 기본데이터 타입 데이터를 쓰고, 읽기
		//쓰여진 순서와 타입을 맞춰야한다.
		// 파일에 기본데이터 타입 값을 파일에 쓰고, 읽어서 화면 출력
		
		//바이트단위 인풋 아웃풋스트림 이요용해서 기본데이터타입을 출력 입력 해보도록 합시다~~~
		
		File file = new File("file/data_io_stream.txt");
		
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			//파일에 쓰고, 저장된 데이터 읽어서 화면 출력!!
			FileOutputStream fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos); //쓰기위한객체
			
			//기본 데이터 타입 값을 파일에 쓰기(출력)
			dos.writeBoolean(true);
			dos.writeByte(127);
			dos.writeInt(12000);
			dos.writeDouble(Math.PI);
			dos.writeUTF("대한민국~~");
			dos.writeUTF("Hello Java~~");
			
			System.out.println(">>> 파일에 출력완료");
			
			//파일에 저장된 데이터를 읽어서 화면 출력
			dis = new DataInputStream(new FileInputStream(file));
			System.out.println(dis.readBoolean());
			System.out.println(dis.readByte());
			System.out.println(dis.readInt());
			//int로 읽어야 처음 저장한 그 값을 읽을 수 있다.
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF());
			System.out.println(dis.readUTF());
			//순서 맞춰서. 차례차례 1:1 출력
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
