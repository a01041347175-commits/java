package com.office.ex;

import java.util.Scanner;

// 월급 지급 명령을 하달
public class PayController {

	public void execute() {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("Please enter the month: ");
			int thisMonth = scanner.nextInt();
			
			PayService payService = new PayService();
			payService.pay(thisMonth);
			
		}
		
		
		
		// scanner.close();
	}
	
}
