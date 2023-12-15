package boong.pro;

import java.util.ArrayList;
import java.util.Scanner;

public class BoongApp {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		MemberDAO mdao = new MemberDAO();
		BoongDAO bdao = new BoongDAO();
		IngredientDAO idao = new IngredientDAO();
		
		while(run) {
			System.out.println("1.회원관리  2.붕어빵관리  3.재료관리  4.판매관리  5.재고관리  6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
				case 1 : /* 회원관리 */
					System.out.println("[회원관리 메뉴를 선택하세요]");
					System.out.println("1)회원등록 2)회원목록 3)정보수정 4)회원등급 5)회원삭제");
					menu = Integer.parseInt(scn.nextLine());
					switch(menu) {
						case 1:
							/* 회원등록 */
							System.out.println("[회원정보를 입력하세요]");
							System.out.println("아이디 >> ");
							String m_id = scn.nextLine();
							System.out.println("이름 >> ");
							String m_name = scn.nextLine();
							System.out.println("연락처 >> ");
							String m_phone = scn.nextLine();
							System.out.println("최애붕 >> ");
							String m_best = scn.nextLine();
							System.out.println("극혐붕 >> ");
							String m_worst = scn.nextLine();
							
							Member member = new Member(m_id, m_name, m_phone, m_best, m_worst);
							if (mdao.addMember(member)) {
								System.out.println("등록되었습니다");
							} else {
								System.out.println("등록 중 오류");
							}
						break;
						
						case 2:
							/* 회원목록 */
							ArrayList<Member> memAry = mdao.getMemberList();
							for (Member mlist : memAry) {
								if (mlist != null) {
									mlist.showInfo();
								}
							}
						break;
						
						case 3:
							/* 정보수정 */
						break;
						
						case 4:
							/* 회원등급 */
						break;
						
						case 5:
							/* 회원삭제 */
							System.out.println("[삭제할 회원아이디를 입력하세요]");
							m_id = scn.nextLine();
							if (mdao.removeMember(m_id)) {
								System.out.println("삭제 완료");
							} else {
								System.out.println("삭제 실패");
							}
						break;
					}
					break;
					
				case 2: /* 붕어빵관리 */
					System.out.println("붕어빵관리 메뉴를 선택하세요");
					System.out.println("1)붕어빵등록 2)상품목록 3)상품정보수정 4)상품삭제");
					menu = Integer.parseInt(scn.nextLine());
					switch(menu) {
						case 1: /* 붕어빵등록 */
							System.out.println("[붕어빵정보를 입력하세요]");
							System.out.println("상품코드 >> ");
							String b_code = scn.nextLine();
							System.out.println("상품명 >> ");
							String b_name = scn.nextLine();
							System.out.println("가격 >> ");
							int b_price = Integer.parseInt(scn.nextLine());
							
							Boong boong = new Boong(b_code, b_name, b_price);
							if (bdao.addBoong(boong)) {
								System.out.println("등록되었습니다");
							} else {
								System.out.println("등록 중 오류");
							}
						break;
						
						case 2: /* 상품목록 */
							ArrayList<Boong> boongAry = bdao.getBoongList();
							for (Boong blist : boongAry) {
								if (blist != null) {
									blist.showInfo();
								}
							}
							
						break;

						case 3: /* 상품정보수정 */
							System.out.println("[수정할 붕어빵의 정보를 입력하세요]");
							System.out.println("상품코드 >> ");
							b_code = scn.nextLine();
							System.out.println("가격 >> ");
							b_price = Integer.parseInt(scn.nextLine());
						break;
						
						case 4: /* 상품삭제 */
							System.out.println("[삭제할 상품코드를 입력하세요]");
							b_code = scn.nextLine();
							if (bdao.removeBoong(b_code)) {
								System.out.println("삭제 완료");
							} else {
								System.out.println("삭제 실패");
							}
						break;	
					}
					
				break;
				
				case 3: /* 재료관리 */
					System.out.println("재료관리 메뉴를 선택하세요");
					System.out.println("1)재료등록 2)재료구매 3)구매조회(상품별) 4)구매조회(날짜별)");
					menu = Integer.parseInt(scn.nextLine());
					switch(menu) {
						case 1: /* 재료등록 */
							System.out.println("[재료의 정보를 입력하세요]");
							System.out.println("상품코드 >> ");
							String i_code = scn.nextLine();
							System.out.println("재료명 >> ");
							String i_name = scn.nextLine();
							System.out.println("가격 >> ");
							int i_price = Integer.parseInt(scn.nextLine());
							
							Ingredient ingre = new Ingredient(i_code, i_name, i_price);
							if (idao.addIngre(ingre)) {
								System.out.println("등록되었습니다");
							} else {
								System.out.println("등록 중 오류");
							}
						break;
						
						case 2: /* 재료구매 */
							System.out.println("[구매할 재료의 정보를 입력하세요]");
							System.out.println("상품코드 >> ");
							i_code = scn.nextLine();
							System.out.println("수량 >> ");
							int i_num = Integer.parseInt(scn.nextLine());
							System.out.println("날짜 >> ");
							String i_date = scn.nextLine();
							
							Ingredient register = new Ingredient(i_code, i_num, i_date);
							if (idao.registerIngre(register)) {
								System.out.println("등록되었습니다");
							} else {
								System.out.println("등록 중 오류");
							}
						break;
							
						case 3: /* 구매조회(상품별) */
							ArrayList<Ingredient> ingreAry = idao.getIngreList();
							for (Ingredient ilist : ingreAry) {
								if (ilist != null) {
									ilist.showInfo();
								}
							}
						break;
						
						case 4: /* 구매조회(날짜별) */
							
						break;
					}
				break;
				
				case 4: /* 판매관리 */
					System.out.println("판매관리 메뉴를 선택하세요");
					System.out.println("1)판매등록 2)판매조회(상품별) 3)판매조회(날짜별)");
					menu = Integer.parseInt(scn.nextLine());
					switch(menu) {
						case 1: /* 판매등록 */
							System.out.println("[판매한 정보를 입력하세요]");
							System.out.println("상품코드 >> ");
							String p_code = scn.nextLine();
							System.out.println("수량 >> ");
							String p_num = scn.nextLine();
							System.out.println("회원 아이디 >> ");
							String m_id = scn.nextLine();						
						break;
						
						case 2: /* 판매조회(상품별) */
							
						break;
						
						case 3: /* 판매조회(날짜별) */
							
						break;
					}
				break;
				
				case 5: /* 재고관리 */
					System.out.println("재고관리 메뉴를 선택하세요");
					System.out.println("1)재료재고 2)붕어빵재고");
					menu = Integer.parseInt(scn.nextLine());
					switch(menu) {
						case 1: /* 재료재고 */
							
						break;
						
						case 2: /* 붕어빵재고 */
							
						break;
					}
				break;
				
				case 6: /* 종료 */
					System.out.println("[프로그램이 종료됩니다]");
					run = false;
			}
			
		} // end of while
	} // end of main
} // end of class
