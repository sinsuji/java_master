package chap4;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		// 1 ~ 50 : 369게임
		
		// 3, 6, 9 갯수 체크 변수
		int cnt = 0;
		// 숫자 1~50 반복문
		for(int i = 1; i <= 50; i++) {
			cnt = 0; // 다음 수를 위한 초기화
			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) cnt++; // 일의 자리 3, 6, 9 갯수 체크
			if(i / 10 == 3 || i / 10 == 6 || i / 10 == 9) cnt++; // 십의 자리 3, 6, 9 갯수 체크 
			// 갯수가 0 -> 숫자, 갯수가 1 -> ♥, 갯수가 2 -> ♥♥
			switch(cnt) {
				case 0 : System.out.print(i + "\t"); break;
				case 1 : System.out.print("♥\t"); break;
				case 2 : System.out.print("♥♥\t");
			}
			if(i % 10 == 0) System.out.println(); // 한줄에 10개씩 출력
		}			
		
		// 동전 교환
		Scanner scanner = new Scanner(System.in);
		int money = 0;
		int remoney = 0;
		
		System.out.print("교환할 금액 : ");
		money = scanner.nextInt();
		
		System.out.println("500원 짜리 : " + (money / 500) + "개");
		remoney = money % 500; 
		
		System.out.println("100원 짜리 : " + (remoney / 100) + "개");
		remoney %= 100; 
		
		System.out.println("50원 짜리 : " + (remoney / 50) + "개");
		remoney %= 50; 
		
		System.out.println("10원 짜리 : " + (remoney / 10) + "개");
		remoney %= 10; 
		
		System.out.println("교환 금액 : " + (money - remoney) + "원");
		System.out.println("남은 금액 : " + remoney + "원");
		
		// 숫자 추측 게임
		int com = (int)(Math.random() * 100) + 1; 
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("숫자 입력 : ");
			int mynum = sc.nextInt();
			
			if(mynum == com) {
				System.out.println("축하합니다");
				break;
			}else if(mynum > com){
				System.out.println("down하세요!");
			}else {
				System.out.println("up하세요!");
			}
		}
		
		// for 추가
		for(int i = 0; i < 10; i++) {
			System.out.println("hhhhhhh");
		}
		

	} // end main

} // end class
