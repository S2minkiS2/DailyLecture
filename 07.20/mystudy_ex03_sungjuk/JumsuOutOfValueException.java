package com.mystudy_ex03_sungjuk;

public class JumsuOutOfValueException extends SungjukProcessException { //업무에 맞게 내가 만든 예외클래스를 확장
	
	public JumsuOutOfValueException() {
		super("점수범위(0~100)를 벗어난 값입니다."); //SungjukProcessException 부모클래스의 생성자 호출
	}
	
	public JumsuOutOfValueException(String msg) {
		super(msg);
	}
}
