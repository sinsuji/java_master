package todo.p20231127;

import java.util.Scanner;

public class BoardApp {
	public static void main(String[] args) {
		Board[] boards = new Board[100];
		Scanner scn = new Scanner(System.in);
		boolean run = true;
				
		while(run){
			System.out.println("1.등록 2.목록 3.상세조회 4.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu){
			case 1 : 
				System.out.println("== 등록값 입력 ==");
				System.out.println("게시글번호 입력 >>");
				String no = scn.nextLine();
				System.out.println("제목 입력 >>");
				String title = scn.nextLine();
				System.out.println("작성자 입력 >>");
				String writer = scn.nextLine();
				System.out.println("내용 입력 >>");
				String text = scn.nextLine();
				System.out.println("작성일시 입력 >>");
				String date = scn.nextLine();
				break;
			case 2 :
				for(int i = 0; i < boards.length; i++) {
					if(boards[i] != null && boards[i].getBoNo().equals(no)) {
						boards[i].showInfo();
					} 
				}
				break;
			case 3 :
				for(int i = 0; i < boards.length; i++) {
					if(boards[i] != null) {
						boards[i].showAllInfo();
					}
				}
				break;
			case 4 :
				System.out.println("종료");
				run = false;
			} // end of switch
		} // end of while
		
		
	} // end of main
} // end of class
