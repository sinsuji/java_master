package chap3;

import java.util.*; // 자바 util에 있는 모든 것들

public class Exam128 {

	public static void main(String[] args) {
		// 문제4
		int penNum = 534;
		int stuNum = 30;
		
		// 학생 1명이 가지는 연필 개수
		int ppsNum = penNum / stuNum;
		// 남은 연필 개수
		int rempNum = penNum % stuNum;

		System.out.printf("학생당 연필 수 : %d, 남은 연필 개수 : %d \n", ppsNum, rempNum);
		
		// 문제5 => 강제 타입변환
		
		// 문제6
		int value = 365;
		System.out.println(value/100*100);
		
		// 문제7 => 부동소수점 표현 방식 0.1은 0.1보다 큰값
		// 강제타입 변환 (float)0.1
		
		// 문제8
		// 사다리꼴의 너비 = (윗변 + 아랫변) * 높이 / 2
		
		int lenghtTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lenghtTop + lengthBottom) * height / 2.0;
		System.out.println(area);
		
		// 문제9
		// ctrl + space 자동입력
		// ctrl + alt + 방향키 = 복사
		// ctrl + d 한줄 지우기
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수 : ");
		double num1 = sc.nextDouble();
		
		System.out.print("두 번째 수 : ");
		double num2 = sc.nextDouble();
		System.out.println("---------------");
		
		if(num2 == 0.0) {
			System.out.println("결과 : 무한대");
		}else {
			System.out.println("결과 : " + (num1 / num2));
		}
		
		
		// 10번
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("원의 넓이:" + var4);
		
		// 11번
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String name = scanner.nextLine();
		
		System.out.print("패스워드 : ");
		String strPassword = scanner.nextLine();
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("java")) {
			if(password == 12345){
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패 : 패스워드가 틀림");
			}
		}else {
			System.out.println("로그인 실패 : 아이디 존재하지 않음");
		}
		
		
	} //end main

} // end class