package com.mystudy.scanner3_cafe;

import java.util.Scanner;

public class ScannerCafeTest {

	public static void main(String[] args) {
		
		System.out.println("===== main() 시작 ======");
		ScannerTestVO testOrder = new ScannerTestVO();
		testOrder.order();
		testOrder.inCome();
		System.out.println("===== main() 끝 ======");
		
	}

}
