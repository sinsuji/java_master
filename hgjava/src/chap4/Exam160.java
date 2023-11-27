package chap4;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		// ����2 : 3�� ��� ��
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("3�� ����� ���� :" + sum);
		
		// ����3
		while(true) {
			int num1 = (int)(Math.random() * 6) + 1;
			int num2 = (int)(Math.random() * 6) + 1;		
			System.out.printf("(%d, %d)\n", num1, num2);
			
			if(num1 + num2 == 5){
				break;
			}
		}
		System.out.println("����");
		
		// ����4
		// x : 1 ~ 10���� �ݺ�
		for(int x = 1; x <= 10; x++) {
			// y : 1 ~ 10���� �ݺ�
			for(int y = 1; y <= 10; y++) {
				if(4*x + 5*y == 60) {					
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}
		
		// ����5
		String star = "";
		for(int i = 1; i <= 4; i++) {
			star += "*";
			System.out.println(star);
		}
		
		// ����6
		
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
		
		// ����7
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		int money = 0;
		
		while(run) {
			System.out.println("---------------------------------");
			System.out.println("1. ���� | 2. ��� | 3. �ܰ� | 4. ����");
			System.out.println("---------------------------------");
			System.out.print("����> ");
			int inputData = sc.nextInt();
			
			switch(inputData){
				case 1 : 
					System.out.print("���ݾ� > ");
					money = sc.nextInt();
					balance += money;
					break;
				case 2 :
					System.out.printf("��ݾ� > ");
					money = sc.nextInt();
					if(money > balance) {
						System.out.println("�ܾ׺���");
					}else {
						balance -= money;
					}
					break;
				case 3 : 
					System.out.println("�ܰ� > " + balance); 
					break;
				default : 
					System.out.print("���α׷� ����");
					run = false;
			}
		}
		
	} // end main

} // end class
