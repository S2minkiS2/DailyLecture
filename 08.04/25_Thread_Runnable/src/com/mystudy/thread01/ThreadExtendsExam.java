package com.mystudy.thread01;

// 쓰레드로 동작하는 클래스 만들기
// Thread 클래스를 상속확장(extends)해서 만들기
class MyThread extends Thread {
	int count = 10;
	
	
	public MyThread() {}

	public MyThread(int count) {
		this.count = count;
	}
	
	@Override
	public void run() {
		//thread 크래스의 run() 메소드를 오버라이딩(oberriding)해서 
		//쓰레드로 하려는 작업을 작성한다
		System.out.println(this.getId() + ":" + this.getName() + " - run() 시작!");
		
		for (int i = 0; i < count; i++) {
			System.out.println(this.getName() + "> : " + i);
			try {
				Thread.sleep(500); // 0.5초 동안 멈추기
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
		System.out.println(this.getId() + ":" + this.getName() + " - run() 끝~~");
	}
}

public class ThreadExtendsExam {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("========= main() 시작 ===============");
		Thread mainThread = Thread.currentThread();
		System.out.println("main 쓰레드 : " + mainThread);
		
		MyThread th1 = new MyThread(15);
		th1.setName("고양이 보러 갈래?");
		th1.setPriority(Thread.MAX_PRIORITY);
		System.out.println("th1 : " + th1);
		
//		th1.run(); // 단순 메서드 호출 - 쓰레드로 동작하지 않음
		
		th1.start(); // run()이 아니라 start() 메서드로 써야 쓰레드로 동작한다. main이 끝나고도 출력된다?
		//---------------------
		
		//쓰레드 1개 더 만들어서 쓰레드로 동작 시키기
		MyThread th2 = new MyThread();
		th2.setName("강아지 보러 갈래?");
		th2.setPriority(Thread.MAX_PRIORITY);
		System.out.println("th2 : " + th2);
		
//		th2.run(); //위에서 th1부터 아래로 th2까지 순서대로 진행
		
		th2.start(); // th1.start()와 무작위로 번갈아가며 실행
		
		
//		th1.join(); //th1 종료 후 main 쓰레드 종료
		
		System.out.println("========= main() 끝 ===============");
		
		
	}

}
