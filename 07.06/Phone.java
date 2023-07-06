package com.mystudy.phone;

public class Phone {

	public static void main(String[] args) {

		System.out.println("===== phone 01의 상태정보=====");
		PhoneMain ph01 = new PhoneMain();
		ph01.view();
		System.out.println("===== phone 02의 상태정보=====");
		PhoneMain ph02 = new PhoneMain("2000 삼성폰", "벽돌 디자인");
		ph02.view();
		System.out.println("===== phone 03의 상태정보=====");
		PhoneMain ph03 = new PhoneMain("1990 중국폰", "저렴한 디자인", false, "010-2736-6119");
		// 폰번호를 int 타입의 01027366119로 하면, 번호의 앞숫자 0이 8진수를 뜻하기에, 숫자9 때문에 오류가 발생.
		// 그리고 핸드폰 번호는 - 도 들어가므로, String 타입이 옳다.
		ph03.view();

		System.out.println("-------------------------------------------");
		System.out.println("call 메서드 실행------------");
		ph03.call();

		System.out.println("receiveCall 메서드 실행-----");
		ph03.receiveCall();

		System.out.println("sendSms 메서드 실행---------");
		String reMs = ph03.sendSms("야, 올때 메로나 사와"); // return 값을 변수에 대입 후에 사용한다 
		System.out.println("[메시지 전송]: " + reMs);

		System.out.println("receiveSms 메서드 실행------");
		String seMs = ph03.receiveSms("병원 예약 관련하여 연락드립니다."); // return 값을 변수에 대입
		System.out.println("[메시지 수신]: " + seMs);

		System.out.println("numSms 메서드 실행----------");
		String numMs = ph03.numCall("010-2736-6119");
		System.out.println("'" + numMs + "'" + "로 발신합니다.");

		System.out.println("spamSms 메서드 실행---------"); //이렇게 해야 함. 문자열은 void로 쓰는게 낫지, 변수에 넣고 출력은 유지보수 힘듬.
		ph03.spamSms("대출 받으세요.");
		

	}

}
