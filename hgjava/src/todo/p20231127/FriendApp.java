package todo.p20231127;

import java.util.Scanner;

public class FriendApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Friend[] friendList = null;
		int friendNum = 0;
		
		// 1.ģ���� 2.�Է� 3.��� 4.���� 5.����
		boolean run = true;
		while(run) {
			System.out.println("1.ģ���� 2.�Է� 3.��� 4.���� 5.����");
			int menu = scn.nextInt();
			scn.nextLine();
			
			switch(menu) {
				case 1 :
					System.out.println("ģ���� �Է� >>");
					friendNum = scn.nextInt();
					friendList = new Friend[friendNum];
					break;
				case 2 :
					System.out.println("ģ������ �Է� >>");
					for(int i = 0; i < friendList.length; i++) {
						Friend friend = new Friend();
						System.out.print("ģ���̸� �Է� >> ");
						friend.name = scn.nextLine();
						System.out.print("����ó �Է� >> ");
						friend.tel = scn.nextLine();
						System.out.print("������ �Է� >> ");
						friend.bloodType = scn.nextLine();
						
						friendList[i] = friend;
					}
					break;
				case 3 :
					System.out.println("������ >>");
					for(int i = 0; i < friendList.length; i++){
						System.out.println("�̸��� " + friendList[i].name + ", ����ó�� " + friendList[i].tel + ", �������� " + friendList[i].bloodType);
					}
					break;
				case 4 :
					System.out.println("��ȸ�� �̸��Է� >> ");
					String name = scn.nextLine();
					boolean exists = false;
					
					for(int i = 0; i < friendList.length; i++) {
						// �����߰� => �������� �Է�
						if(name.equals(friendList[i].name)) {
							System.out.println("���濬��ó �Է� >> ");
							friendList[i].tel = scn.nextLine();
							exists = true;
						}
					}
					// ã�� �̸� ����
					if(!exists) {
						System.out.println("��ȸ�� �̸��� �����ϴ�");
					}
					break;
				case 5 :
					System.out.println("���� >>");
					run = false;	
			}
		}
	} // end main
} // end class
