package com.mystudy.ex04_interface2;

class PhoneTest {

	public static void main(String[] args) {
		System.out.println("==== Phone ====");
		Phone ph1 = new Phone("010-273-6119");
		ph1.view();
		ph1.call();
		ph1.receiveCall();
		ph1.sendSMS();
		ph1.receiveSMS();
		
		System.out.println("getPhoneNo() : "+ph1.getPhoneNo());
		
		
		System.out.println("==== myPhone 2*impl====");
		Mp3PhoneImpl myPhone = new Mp3PhoneImpl("신기한타입", "010-9999-7777");
		myPhone.view();
		myPhone.call();
		myPhone.receiveCall();
		myPhone.sendSMS();
		myPhone.receiveSMS();
		myPhone.playMusic();
		
		System.out.println("==== Mp3Phone 1*ex 1*impl");
		Mp3Phone myPhone02 = new Mp3Phone("000-8888-3333");
		myPhone02.view();
		myPhone02.call();
		myPhone02.receiveCall();
		myPhone02.sendSMS();
		myPhone02.receiveSMS();
		myPhone02.playMusic();
		
	}

}
