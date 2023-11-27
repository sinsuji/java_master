package chap5;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int studentNum = 0;
		int[] scores = null;
		String[] names = null;
		
		// 1. �л��� 2. �����Է� 3. ������ 4. �м�(�ְ�����, ���) 5. ����
		boolean run = true;
		while(run) {
			System.out.println("1.�л��� 2.�����Է� 3.������ 4.�м�(�ְ�����, ���) 5.����");
			int menu = scn.nextInt(); // 3 Enter 
			scn.nextLine();
			
			switch(menu){
				case 1 :
					System.out.println("�л��� �Է� >>");
					studentNum = scn.nextInt();
					scores = new int[studentNum];
					names = new String[studentNum];
					break;
				case 2 :
					System.out.println("�����Է� >>");
					// for �ݺ�
					for(int i = 0; i < scores.length; i++){
						System.out.print("names[" + i + "]>> ");
						names[i] = scn.nextLine();
						System.out.print("scores[" + i + "]>> ");
						scores[i] = scn.nextInt();
						scn.nextLine();
					}
					break;
				case 3 :
					System.out.println("������ >>");
					for(int i = 0; i < scores.length; i++){
						System.out.print("�̸��� " + names[i] + ", ������ " + scores[i] + "\n");
					}
					break;
				case 4 :
					System.out.println("�м� >>");
					// �ְ����� ���
					int maxScore = 0;
					String maxName = "";
					double avg = 0;
					int sum = 0;
					
					for(int i = 0; i < scores.length; i++) { // for(int num : scores)
						sum += scores[i]; // sum += num
						if(maxScore < scores[i]) { // if(maxScore < num)
							maxScore = scores[i]; // maxScore = num
							maxName = names[i];
						}
					}
					avg = (double)sum / scores.length; // sum * 1.0 / scores.length;
					System.out.println(maxName + " ���� " + maxScore + ", ��� : " + avg);
					break;
				default :
					System.out.println("���� >>");
					run = false;
					break;
			} // end of switch
		} // end of while
		System.out.println("end of program");
		
		
	} // end main

} // end class
