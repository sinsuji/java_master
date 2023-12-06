package todo.p20231206;

import java.util.Scanner;

public class ProductApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		ProductExe exe = new ProductExe();
		InOutExe ioexe = new InOutExe();
		
		while(run) {
			System.out.println("1.상품관리 2.입출고관리 3.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
				case 1: // 상품관리
				System.out.println("1-1)등록 1-2)수정 1-3)목록");
				menu = Integer.parseInt(scn.nextLine());
				switch(menu) {
					case 1: // 등록
						System.out.println("등록정보를 입력하세요");
						System.out.println("상품코드 >> ");
						String code = scn.nextLine();
						System.out.println("상품명 >> ");
						String name = scn.nextLine();
						System.out.println("가격 >> ");
						int price = Integer.parseInt(scn.nextLine());
						
						Product product = new Product(code, name, price);
						if(exe.addPro(product)) {
							System.out.println("상품이 등록되었습니다");
						}else {
							System.out.println("등록실패");
						}
					break;
					case 2: // 수정 
						System.out.println("수정할 상품코드 입력 >> ");
						code = scn.nextLine();
						System.out.println("수정할 가격 입력 >> ");
						price = Integer.parseInt(scn.nextLine());						
						if(exe.modifyPro(code, price)) {
							System.out.println("수정되었습니다.");
						}else {
							System.out.println("수정실패");
						}
					break;
					case 3: // 목록
						System.out.println("상품코드/ 상품명/ 가격");
						for(Product prod : exe.getList()) {
							if(prod != null) {
								System.out.println(prod.showInfo());
							}else {
								System.out.println("없는 정보입니다");
							}
						}
					break;
				}
				break;
				
				case 2:
					System.out.println("2-1)판매 2-2)구매 2-3)재고");
					menu = Integer.parseInt(scn.nextLine());
					switch(menu) {
						case 1: // 판매
							System.out.println("판매정보를 입력하세요");
							System.out.println("상품코드 >> ");
							String code = scn.nextLine();
							System.out.println("처리날짜 >> ");
							String date = scn.nextLine();
							System.out.println("수량 >> ");
							int num = Integer.parseInt(scn.nextLine());
							String state = "판매";
							
							InOut inout = new InOut(code, date, num, state);
							
							if(ioexe.addOut(inout)) {
								System.out.println("판매되었습니다");
							}else {
								System.out.println("판매실패");
							}
						break;
						
						case 2: // 구매
							System.out.println("구매정보를 입력하세요");
							System.out.println("상품코드 >> ");
							code = scn.nextLine();
							System.out.println("처리날짜 >> ");
							date = scn.nextLine();
							System.out.println("수량 >> ");
							num = Integer.parseInt(scn.nextLine());
							System.out.println("판(구)매 >> ");
							state = scn.nextLine();
							
							InOut inout1 = new InOut(code, date, num, state);
							
							if(ioexe.addOut(inout1)) {
								System.out.println("구매되었습니다");
							}else {
								System.out.println("구매실패");
							}
						break;
						
						case 3: // 재고
							System.out.println("상품코드 재고수량");
//							for(InOut stock : ioexe.stockList()) {
//								if(stock != null) {
//									System.out.println("");
//								}else {
//									System.out.println("없는 정보입니다");
//								}
//							}						
							ioexe.stockList();
					}
				break;
				
				case 3:
					run = false;
					System.out.println("프로그램 종료");
			} // end of switch
		} // end of while
		
	} // end of main
} // end of class
