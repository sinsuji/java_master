package todo.p20231205;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chap13.Member;

public class BookApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);		
		BookExe exe = new BookExe();
		boolean run = true;		
		int menu = 0;
		
		while(run) {
		System.out.println("1.등록 2.목록 3.수정 4.삭제 5.종료");
		menu = Integer.parseInt(scn.nextLine());
		
		switch(menu) {
			case 1 : // 입력
				System.out.println("도서코드입력 >> ");
				String code = scn.nextLine();
				System.out.println("도서명입력 >> ");
				String name = scn.nextLine();
				System.out.println("저자입력 >> ");
				String writer = scn.nextLine();
				System.out.println("출판사입력 >> ");
				String company = scn.nextLine();
				System.out.println("가격입력 >> ");
				int price = Integer.parseInt(scn.nextLine());
				
				Book book = new Book(code, name, writer, company, price);
				
				if(exe.addBook(book)) {
					System.out.println("저장되었습니다");
				}else {
					System.out.println("저장실패");
				}
				break;
			case 2 : // 조회
// 				교수님 방법
//				ArrayList<Book> bookInfo = exe.getBookList();
//				for(Book stdnt : bookInfo) {
//					if(stdnt != null) {
//						System.out.println(stdnt.showInfo());
//					}
//				}
				System.out.println("도서코드 도서명 저자 가격");
				boolean exist = false;
				for(Book bookInfo : exe.getBookList()) {
					if(bookInfo != null) {
						System.out.println(bookInfo.showInfo());
						exist = true;
					}
				}
				if(!exist) {
					System.out.println("존재하지 않는 정보입니다");
				}
				break;
			case 3 : // 수정
				System.out.println("수정할 도서코드입력 >> ");
				code = scn.nextLine();
				System.out.println("수정할 가격입력 >>");
				price = Integer.parseInt(scn.nextLine());
				if(exe.modifyBook(code, price)) {
					System.out.println("수정되었습니다");
				}else {
					System.out.println("수정실패");
				}
				break;
			case 4 : // 삭제
				System.out.println("삭제할 도서코드입력 >> ");
				code = scn.nextLine();
				if(exe.removeBook(code)) {
					System.out.println("삭제되었습니다");
				}else {
					System.out.println("삭제실패");
				}
				break;
			case 5 : // 종료
				System.out.println("종료");			
				run = false;
			}
		}
	} // end of main
} // end of class
