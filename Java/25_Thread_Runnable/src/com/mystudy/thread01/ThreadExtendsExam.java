package com.mystudy.thread01;

	
//쓰레드로 동작하는 클래스 만들기
//Thread 클래스를 상속 확장(extends) 
	
class MyThread extends Thread { //java.lang에 있는 thread를 상속확장한다
	int count = 10;
	
	public MyThread() {}
	public MyThread(int count) {
		this.count = count;
	}
	
	
	
	@Override 
	public void run() {
		// Thread 클래스의 run() 메소드를 오버라이딩(overriding재정의)해서
		// 쓰레드로 하려는 작업을 작성한다.
		System.out.println(this.getId() + ":" 
		+ this.getName() + "- run() 시작~~");
		
		for (int i = 0; i < count; i++ ) {
			System.out.println(this.getName() + "> : " + i);
			try {
				Thread.sleep(500); //0.5초동안 멈추기
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
		System.out.println(this.getId() + ":" 
				+ this.getName() + "- run() 끝~~");
		//현재객체의 아이디와 쓰레드이름 가져온다.
	}
}

public class ThreadExtendsExam {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("---- main() 시작 ----");
		//현재 동작하고 있는 스레드 = 메인스레드
		Thread mainThread = Thread.currentThread();
		System.out.println("main 쓰레드 : " + mainThread);
		
		//스레드 객체 생성1
		MyThread th1 = new MyThread(15);
		th1.setName("MyThread-1");
		th1.setPriority(Thread.MIN_PRIORITY); //priority??
		//가중치를 높게 준다고 해서 항상 먼저 실행되진 않는다.
		System.out.println("th1 : " + th1);
		
		th1.start(); //쓰레드로 동작시키려면 start() 메소드 호출해서 실행
//		th1.run(); // 단순 메소드 호출 - 쓰레드로 동작하지 않음
		//------------------------------
		
		//스레드 객체 생성2 해서 쓰레드로 동작시키기
		MyThread th2 = new MyThread();
		th2.setName("MyThread-222");
		th2.setPriority(Thread.MAX_PRIORITY);
		System.out.println("th2 : " + th2);	
		th2.start();
		
//		th1.join(); //th1이 종료된 다음에 메인이 종료된다
		
		System.out.println("---- main() 끝 ----");

	}

}
