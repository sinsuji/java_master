package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListExe3 {
	public static void main(String[] args) {
		
		// 회원등록(회원번호, 이름, 포인트)
		// 1.등록 2.이름조회 3.포인트변경(회원번호를 넣어서 포인트변경) 4.삭제 5.종료
		Scanner scn = new Scanner(System.in);
		List<Member> members = new ArrayList<>();
		
		
		boolean run = true;
		
		int menu = 0;
		
		while(run){
			System.out.println("1.등록 2.이름조회 3.포인트변경 4.삭제 5.종료");
			menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1:
//				System.out.println("회원정보를 등록하세요");
				System.out.println("회원번호 이름 포인트");
				
				
				String input = scn.nextLine();
				String[] inAry = input.split(" ");
				System.out.println(inAry[0]);
				System.out.println(inAry[1]);
				System.out.println(inAry[2]);
				
				members.add(new Member(inAry[0], inAry[1], Integer.parseInt(inAry[2])));
				
				System.out.println("end");
				
//				System.out.print("번호 입력 >> ");
				String no = scn.nextLine();
//				System.out.print("이름 입력 >> ");
				String name = scn.nextLine();
//				System.out.print("포인트 입력 >> ");
				int point = Integer.parseInt(scn.nextLine());
				members.add(new Member(no, name, point));
				break;
			case 2:
				System.out.println("조회할 이름 입력 >> ");
				name = scn.nextLine();
				int cnt = 0;
				boolean exist = false;
				for(int i = 0; i < members.size(); i++) {
					if(members.get(i).getMemberName().indexOf(name) != -1) {
						cnt++;
						System.out.println(members.get(i));
						exist = true;
					}
				}
				if(!exist) {
					System.out.println("조회할 정보가 없습니다");
				}
				break;
			case 3:
				System.out.println("포인트변경 번호입력 >> ");
				no = scn.nextLine();
				exist = false;
				for(int i = 0; i < members.size(); i++) {
					if(members.get(i).getMemberNo().indexOf(no) != -1) {
						System.out.println("포인트값 입력 >> ");
						point = Integer.parseInt(scn.nextLine());
						members.get(i).setPoint(point);
						exist = true;
					}
				}
				if(!exist) {
					System.out.println("조회할 정보가 없습니다");
				}
				break;
			case 4:
				System.out.println("삭제 번호입력 >> ");
				no = scn.nextLine();
				exist = false;
				for(int i = 0; i < members.size(); i++) {
					if(members.get(i).getMemberNo().indexOf(no) != -1) {
						members.remove(i);
						exist = true;
					}
				}
				if(!exist) {
					System.out.println("조회할 정보가 없습니다");
				}
				break;
			case 5:
				run = false;
			}
		}
			
		
		
	}
}
