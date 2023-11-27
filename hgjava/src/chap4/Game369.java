package chap4;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		// 1 ~ 50 : 369����
		
		// 3, 6, 9 ���� üũ ����
		int cnt = 0;
		// ���� 1~50 �ݺ���
		for(int i = 1; i <= 50; i++) {
			cnt = 0; // ���� ���� ���� �ʱ�ȭ
			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) cnt++; // ���� �ڸ� 3, 6, 9 ���� üũ
			if(i / 10 == 3 || i / 10 == 6 || i / 10 == 9) cnt++; // ���� �ڸ� 3, 6, 9 ���� üũ 
			// ������ 0 -> ����, ������ 1 -> ��, ������ 2 -> ����
			switch(cnt) {
				case 0 : System.out.print(i + "\t"); break;
				case 1 : System.out.print("��\t"); break;
				case 2 : System.out.print("����\t");
			}
			if(i % 10 == 0) System.out.println(); // ���ٿ� 10���� ���
		}			
		
		// ���� ��ȯ
		Scanner scanner = new Scanner(System.in);
		int money = 0;
		int remoney = 0;
		
		System.out.print("��ȯ�� �ݾ� : ");
		money = scanner.nextInt();
		
		System.out.println("500�� ¥�� : " + (money / 500) + "��");
		remoney = money % 500; 
		
		System.out.println("100�� ¥�� : " + (remoney / 100) + "��");
		remoney %= 100; 
		
		System.out.println("50�� ¥�� : " + (remoney / 50) + "��");
		remoney %= 50; 
		
		System.out.println("10�� ¥�� : " + (remoney / 10) + "��");
		remoney %= 10; 
		
		System.out.println("��ȯ �ݾ� : " + (money - remoney) + "��");
		System.out.println("���� �ݾ� : " + remoney + "��");
		
		// ���� ���� ����
		int com = (int)(Math.random() * 100) + 1; 
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("���� �Է� : ");
			int mynum = sc.nextInt();
			
			if(mynum == com) {
				System.out.println("�����մϴ�");
				break;
			}else if(mynum > com){
				System.out.println("down�ϼ���!");
			}else {
				System.out.println("up�ϼ���!");
			}
		}
		
		// for �߰�
		for(int i = 0; i < 10; i++) {
			System.out.println("hhhhhhh");
		}
		

	} // end main

} // end class
