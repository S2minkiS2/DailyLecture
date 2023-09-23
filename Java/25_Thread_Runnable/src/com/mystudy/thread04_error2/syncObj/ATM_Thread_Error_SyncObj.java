package com.mystudy.thread04_error2.syncObj;

class Bank {
	int money = 0;
}

class ATM extends Thread {
	Bank bank;
	
	public ATM(Bank bank) {
		this.bank = bank;
	}
	//입금처리 
	// synchronized (사용객체) {} : 사용객체(인스턴스) 동기화 처리
	// 객체를 가져다가 synchronized처리해야..!
	synchronized void add(int money) {
		bank.money += money;
		System.out.println(Thread.currentThread() + " - " +
		"입금 : " + money + ", 잔액 : " + bank.money);
	}
	synchronized void out(int money) {
		bank.money -= money;
		System.out.println(Thread.currentThread() + " - " +
				"출금 : " + money + ", 잔액 : " + bank.money);
	}

	@Override
	public void run() {
		add(1000);
		bankSleep(1000);
		out(500);
		bankSleep(1000);
		out(300);
		bankSleep(1000);
		out(200);
		
	}
	void bankSleep (int millisecond) {
		try {
			Thread.currentThread().sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
public class ATM_Thread_Error_SyncObj {

	public static void main(String[] args) {
		System.out.println("=====main() 시작=====");
		Bank bank = new Bank();
		
		ATM atm1 = new ATM(bank);
		atm1.start();
		
		ATM atm2 = new ATM(bank);
		atm2.start();
		
		System.out.println("=====main() 끝=====");

	}
}
