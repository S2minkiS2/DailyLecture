package com.mystudy.thread03_error;

class ATM_Error implements Runnable {//러너블 인터페이스 구현 why
	//쓰레드를 만들어 객체를 주입해줘야 쓰레드가 된다.
	
	int money;
	
	public ATM_Error() {}
	public ATM_Error(int money) {
		this.money = money;
	}
	// 입금 후 계속 출금
	
	// 입금 처리
	void add(int money) {
		this.money += money;
		System.out.println(Thread.currentThread() + " - "
				+ "입금 : " + money + ", 잔액" + this.money);
					//작업스레드표시, 입금액은 얼마고 잔액은 얼마고
	}
	
	// 출금 처리
	void out(int money) {
		this.money -= money;
		System.out.println(Thread.currentThread() + " - "
				+ "출금 : " + money + ", 잔액" + this.money);
					//작업스레드표시, 출금액은 얼마고 잔액은 얼마고
	}
	
	
	@Override //구현 안된 run
	public void run() {
		add(1000);
		bankSleep(1000);
		out(500);
		bankSleep(1000);
		out(300);
		bankSleep(1000);
		out(200);		
	} 
	
	void bankSleep(int millisecond) {
		try {
			Thread.currentThread().sleep(millisecond); 
			//현재 동작중인 currentThread를 1초동안 쉬게!
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}

public class ATM_Thread_Error {

	public static void main(String[] args) {
		System.out.println("==== main() 시작 ====");
		ATM_Error bank = new ATM_Error();
		System.out.println("은행잔고 : " + bank.money);
		
		Thread th1 = new Thread(bank);
		Thread th2 = new Thread(bank);
		
		th1.start(); //쓰레드로 동작
		th2.start();
		
		System.out.println("==== main() 끝 ====");
	}

}
