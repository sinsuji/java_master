package todo.p20231127;

import java.util.Scanner;

public class FriendApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Friend[] friendList = null;
		int friendNum = 0;
		
		// 1.친구수 2.입력 3.목록 4.수정 5.종료
		boolean run = true;
		while(run) {
			System.out.println("1.친구수 2.입력 3.목록 4.수정 5.종료");
			int menu = scn.nextInt();
			scn.nextLine();
			
			switch(menu) {
				case 1 :
					System.out.println("친구수 입력 >>");
					friendNum = scn.nextInt();
					friendList = new Friend[friendNum];
					break;
				case 2 :
					System.out.println("친구정보 입력 >>");
					for(int i = 0; i < friendList.length; i++) {
						Friend friend = new Friend();
						System.out.print("친구이름 입력 >> ");
						friend.name = scn.nextLine();
						System.out.print("연락처 입력 >> ");
						friend.tel = scn.nextLine();
						System.out.print("혈액형 입력 >> ");
						friend.bloodType = scn.nextLine();
						
						friendList[i] = friend;
					}
					break;
				case 3 :
					System.out.println("목록출력 >>");
					for(int i = 0; i < friendList.length; i++){
						System.out.println("이름은 " + friendList[i].name + ", 연락처는 " + friendList[i].tel + ", 혈액형은 " + friendList[i].bloodType);
					}
					break;
				case 4 :
					System.out.println("조회할 이름입력 >> ");
					String name = scn.nextLine();
					boolean exists = false;
					
					for(int i = 0; i < friendList.length; i++) {
						// 조건추가 => 변경점수 입력
						if(name.equals(friendList[i].name)) {
							System.out.println("변경연락처 입력 >> ");
							friendList[i].tel = scn.nextLine();
							exists = true;
						}
					}
					// 찾는 이름 없음
					if(!exists) {
						System.out.println("조회할 이름이 없습니다");
					}
					break;
				case 5 :
					System.out.println("종료 >>");
					run = false;	
			}
		}
	} // end main
} // end class
