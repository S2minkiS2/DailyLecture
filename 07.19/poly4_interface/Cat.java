package com.mystudy.poly4_interface;

class Cat extends AbstractAnimal {
	
	public Cat() {
		super("나비야");
	}
	
	@Override
	public void sound() {
		System.out.println(super.getName()  +">> 야양오옹야옹야옹");
	}
	
	public void run() {
		System.out.println(">> 고양이 달려요");
	}

}
