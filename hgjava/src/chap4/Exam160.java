package chap4;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		// 문제2 : 3의 배수 합
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("3의 배수의 총합 :" + sum);
		
		// 문제3
		while(true) {
			int num1 = (int)(Math.random() * 6) + 1;
			int num2 = (int)(Math.random() * 6) + 1;		
			System.out.printf("(%d, %d)\n", num1, num2);
			
			if(num1 + num2 == 5){
				break;
			}
		}
		System.out.println("종료");
		
		// 문제4
		// x : 1 ~ 10까지 반복
		for(int x = 1; x <= 10; x++) {
			// y : 1 ~ 10까지 반복
			for(int y = 1; y <= 10; y++) {
				if(4*x + 5*y == 60) {					
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}
		
		// 문제5
		String star = "";
		for(int i = 1; i <= 4; i++) {
			star += "*";
			System.out.println(star);
		}
		
		// 문제6
		
		System.out.println("\n");
		String star1 = "";
		for(int i = 1; i <= 4; i++) {
			for(int b = 1; b <= 4 - i; b++) {
				star1 += " ";
			}
			for(int s = 1; s <= i; s++) {
				star1 += "*";
			}
			star1 +="\n";
		}
		System.out.println(star1);
		
		// 문제7
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		int money = 0;
		
		while(run) {
			System.out.println("---------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("---------------------------------");
			System.out.print("선택> ");
			int inputData = sc.nextInt();
			
			switch(inputData){
				case 1 : 
					System.out.print("예금액 > ");
					money = sc.nextInt();
					balance += money;
					break;
				case 2 :
					System.out.printf("출금액 > ");
					money = sc.nextInt();
					if(money > balance) {
						System.out.println("잔액부족");
					}else {
						balance -= money;
					}
					break;
				case 3 : 
					System.out.println("잔고 > " + balance); 
					break;
				default : 
					System.out.print("프로그램 종료");
					run = false;
			}
		}
		
	} // end main

} // end class