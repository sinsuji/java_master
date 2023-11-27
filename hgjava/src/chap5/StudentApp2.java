package chap5;

import java.util.Scanner;

public class StudentApp2 {
	static Scanner scn = new Scanner(System.in);
	static Student[] students = null;
	
	public static void addStudent() {
		System.out.println("�л����� �Է� >> ");
		for(int i = 0; i < students.length; i++) {
			Student student = new Student(); // int num = 60;
			System.out.print("�л� �̸� �Է� >>");
			student.name = scn.nextLine();
			System.out.print("�л� ���� �Է� >>");
			student.score = Integer.parseInt(scn.nextLine());
			System.out.print("��/�� >>");
			student.gender = scn.nextLine();
			
			students[i] = student;
		}
	} // end of addStudent()
	
	public static void searchStudent() {
		System.out.println("��ȸ�� �̸��Է� >> ");
		String name = scn.nextLine();
		boolean exists = false;
		
		// �л��̸� - ���� ���
		for(Student stdn : students) {
			if(name.equals(stdn.name)) {
				System.out.println("�̸��� " + stdn.name + ", ������ " + stdn.score);
				exists = true;
			}
		}
		// ã�� �̸��� ���翩�� : exists �� Ȯ��
		if(!exists) {
			System.out.println("ã�� �̸��� �����ϴ�");
		}
	} // end of searchStudent()

	public static void analysis() {
		int sumOfMen = 0, cntOfMen = 0;
		int sumOfWomen = 0, cntOfWomen = 0;
		for(Student stn : students) {
			if(stn.gender.equals("��")) {
				sumOfMen += stn.score;
				cntOfMen++;
			}else if(stn.gender.equals("��")){
				sumOfWomen += stn.score;
				cntOfWomen++;
			}
		}
		System.out.println("���л��� ��� : " + (sumOfMen * 1.0 / cntOfMen));
		System.out.println("���л��� ��� : " + (sumOfWomen * 1.0 / cntOfWomen));
	} // end of analysis()
	
	public static void modify() {
		//�̸��Է� -> ��������
		System.out.println("��ȸ�� �̸��Է� >> ");
		String name = scn.nextLine();
		boolean exists = false;
		
		for(int i = 0; i < students.length; i++) {
			// �����߰� => �������� �Է�
			if(name.equals(students[i].name)) {
				System.out.println("�������� �Է� >> ");
				students[i].score = Integer.parseInt(scn.nextLine());
				exists = true;
			}
		}
		// ã�� �̸� ����
		if(!exists) {
			System.out.println("��ȸ�� �̸��� �����ϴ�");
		}
		
	} // end of modify()
	
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		
		while(run) {
			System.out.println("1.�л��� 2.�����Է� 3.��ȸ 4.�м�(�ְ�����, ���) 5.���� 6.����");
			int menu = scn.nextInt(); // 3 Enter 
			scn.nextLine();
			
			switch(menu){
			case 1 : 
				System.out.println("�л��� �Է� >> ");
				studentNum = Integer.parseInt(scn.nextLine()); // "3" -> 3
				students = new Student[studentNum];
				break;
			case 2 : 
				addStudent();
				break;
			case 3 : 
				searchStudent();
				break;
			case 4 : // �м�
				analysis();
				break;
			case 5 : // ���� 
				modify();
				break;
			case 6 : 
				System.out.println("�����մϴ�");
				run = false;
			}
		} // end of while
	} // end of main()
} // end of class
