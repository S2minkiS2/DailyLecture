package com.mystudy.poly4_interface;

public abstract class AbstractAnimal implements Animal {
	private String name = "동물"; //이름, 명칭
	private int legCnt; //다리갯수
	
	public AbstractAnimal() {}
	public AbstractAnimal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	@Override
	public void eat() {
		System.out.println(">> 먹는다");
		
	}

	@Override
	public void sleep() {
		System.out.println(">> 잠든다");
		
	}

	@Override
	public abstract void sound();

}
