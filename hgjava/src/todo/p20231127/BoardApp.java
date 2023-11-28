package todo.p20231127;

import java.util.Scanner;

public class BoardApp {
	public static void main(String[] args) {
		Board[] boards = new Board[100];
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		// Board exe = new Board();
				
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
				
				Board bor = new Board(no, title, writer, text, date);
					
				for(int i = 0; i < boards.length; i++) {
					if(boards[i] == null) {
						boards[i] = bor;
						break;
					}
				}
				System.out.println("저장되었습니다");

				break;
			case 2 :
				System.out.println("--------------------------------");
				for(int i = 0; i < boards.length; i++) {
					if(boards[i] != null) {
						boards[i].showInfo();
					}
				}
				System.out.println("--------------------------------");
				break;
			case 3 :
				System.out.println("조회할 게시글번호 입력 >>");
				no = scn.nextLine();
				System.out.println("--------------------------------");
				for(int i = 0; i < boards.length; i++) {
					if(boards[i] != null && boards[i].getBoNo().equals(no)) {
						System.out.println(boards[i].showAllInfo());
					}
				}
				System.out.println("--------------------------------");
				break;
			case 4 :
				System.out.println("종료");
				run = false;
			} // end of switch
		} // end of while
		
		
	} // end of main
} // end of class
