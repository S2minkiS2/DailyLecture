package com.mystudy.thread04_error2.copy;


class Bank {
	int money = 0;
}

class ATM_Error extends Thread { 
	//쓰레드로 상속확장이라 객체를 만들면 바로 쓰레드다.
	
	Bank bank;
	
	public ATM_Error(Bank bank) {
		this.bank = bank;
	}
	
	// 입금 후 계속 출금
	// 입금 처리
	synchronized void add(int money) {
		//Sync가 다른게 bank를 바꾸는건 막을 수 있지만
		//
		bank.money += money;
		System.out.println(Thread.currentThread() + " - "
				+ "입금 : " + money + ", 잔액" + bank.money);
					//작업스레드표시, 입금액은 얼마고 잔액은 얼마고
	}
	
	// 출금 처리
	synchronized void out(int money) {
		bank.money -= money;
		System.out.println(Thread.currentThread() + " - "
				+ "출금 : " + money + ", 잔액" + bank.money);
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
		Bank bank = new Bank();
		
		ATM_Error atm1 = new ATM_Error(bank);
		atm1.start();
		
		ATM_Error atm2 = new ATM_Error(bank);
		atm2.start();
		
//		Thread th1 = new Thread(bank);
//		Thread th2 = new Thread(bank);
//		
//		th1.start(); //쓰레드로 동작
//		th2.start();
		
		System.out.println("==== main() 끝 ====");
	}

}
