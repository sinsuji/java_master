package chap5;

import java.util.Scanner;

public class WhileExe1 {

	public static void main(String[] args) {
		// for : �ݺ�ȸ���� �������ִ� ���
		
		// while : ������ �����ϴ� ���� �ݺ�
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.print("���ڰ��� �Է� >>> ");
			
			String txt = scn.nextLine();
			if(txt.equals("quit")) {
				System.out.println("�����մϴ�");
				break;
			}
			System.out.println("�Է°��� " + txt + " �Դϴ�");
		}
		System.out.println("end of program");
	
	} // end main

} // end class