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
		InOutDAO pdao = new InOutDAO();

		while (run) {
			System.out.println("                 (º)))< BOONG SYSTEM");
			System.out.println("=====================================================");
			System.out.println("1.회원관리  2.붕어빵관리  3.재료관리  4.판매관리  5.재고관리  6.종료");
			System.out.println("=====================================================");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: /* 회원관리 */
				System.out.println("[회원관리 메뉴를 선택하세요]");
				boolean run1 = true;
				while(run1) {
					System.out.println("1)회원등록 2)회원목록 3)정보수정 4)회원삭제 5)나가기");
					menu = Integer.parseInt(scn.nextLine());
					switch (menu) {
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
						System.out.println("================================");
						System.out.println("아이디  이름  연락처       최애붕  극혐붕");
						System.out.println("================================");
						for (Member mlist : memAry) {
							if (mlist != null) {
								mlist.showInfo();
							}
						}
						break;
	
					case 3:
						/* 정보수정 */
						System.out.println("[수정할 회원의 정보를 입력하세요]");
						System.out.println("아이디 >> ");
						m_id = scn.nextLine();
						System.out.println("최애붕 >> ");
						m_best = scn.nextLine();
						System.out.println("극혐붕 >> ");
						m_worst = scn.nextLine();
						
						if (mdao.modifyMember(m_id, m_best, m_worst)) {
							System.out.println("수정 완료");
						} else {
							System.out.println("수정 실패");
						}
						break;
	
	
					case 4:
						/* 회원삭제 */
						System.out.println("[삭제할 회원아이디를 입력하세요]");
						m_id = scn.nextLine();
						if (mdao.removeMember(m_id)) {
							System.out.println("삭제 완료");
						} else {
							System.out.println("삭제 실패");
						}
						break;
						
					case 5:
						run1 = false;
						break;
					}
				}
				break;

			case 2: /* 붕어빵관리 */
				System.out.println("[붕어빵관리 메뉴를 선택하세요]");
				run1 = true;
				while(run1) {
					System.out.println("1)붕어빵등록 2)상품목록 3)상품정보수정 4)상품삭제 5)나가기");
					menu = Integer.parseInt(scn.nextLine());
					switch (menu) {
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
						System.out.println("===================");
						System.out.println("상품코드  제품명  가격");
						System.out.println("===================");
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
	
						if (bdao.modifyBoong(b_code, b_price)) {
							System.out.println("수정 완료");
						} else {
							System.out.println("수정 실패");
						}
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
						
					case 5:
						run1 = false;
						break;	
					}
				}

				break;

			case 3: /* 재료관리 */
				System.out.println("[재료관리 메뉴를 선택하세요]");
				run1 = true;
				while(run1) {
					System.out.println("1)재료등록 2)재료구매 3)재료조회 4)사용조회 5)구매삭제 6)나가기");
					menu = Integer.parseInt(scn.nextLine());
					switch (menu) {
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
						String p_code = scn.nextLine();
						System.out.println("수량 >> ");
						int p_num = Integer.parseInt(scn.nextLine());
						System.out.println("날짜 >> ");
						String p_date = scn.nextLine();
						if (p_date.equals("")) {
							p_date = null;
						}
	
						InOut register = new InOut(p_code, p_num, p_date);
						if (pdao.addIn(register)) {
							System.out.println("등록되었습니다");
						} else {
							System.out.println("등록 중 오류");
						}
						break;
	
					case 3: /* 구매조회 */
						ArrayList<InOut> ingreAry = pdao.getRegisterList();
						System.out.println("===========================");
						System.out.println("No  상품코드  재료명  수량  날짜");
						System.out.println("===========================");
						for (InOut ilist : ingreAry) {
							if (ilist != null) {
								ilist.showInfo();
							}
						}
						break;
	
					case 4: /* 사용조회 */
						ArrayList<InOut> ingreDateAry = pdao.getIngreDateList();
						System.out.println("===========================");
						System.out.println("No  상품코드  재료명  수량  날짜");
						System.out.println("===========================");
						for (InOut ilist : ingreDateAry) {
							if (ilist != null) {
								ilist.showDateInfo();
							}
						}
						break;
	
					case 5: /* 삭제 */
						System.out.println("[삭제할 번호를 입력하세요]");
						i_code = scn.nextLine();
						if (pdao.removeIngre(i_code)) {
							System.out.println("삭제 완료");
						} else {
							System.out.println("삭제 실패");
						}
						break;
					
					case 6:
						run1 = false;
						break;	
					}
				}
				break;

			case 4: /* 판매관리 */
				System.out.println("[판매관리 메뉴를 선택하세요]");
				run1 = true;
				while(run1) {
					System.out.println("1)판매등록 2)판매조회(상품별) 3)판매조회(날짜별) 4)나가기");
					menu = Integer.parseInt(scn.nextLine());
					switch (menu) {
					case 1: /* 판매등록 */
						System.out.println("[판매한 정보를 입력하세요]");
						System.out.println("상품코드 >> ");
						String p_code = scn.nextLine();
						System.out.println("수량 >> ");
						int p_num = Integer.parseInt(scn.nextLine());
						System.out.println("회원 아이디 >> ");
						String p_id = scn.nextLine();
	
						InOut sale = new InOut(p_code, p_num, p_id);
						if (pdao.addSale(sale)) {
							sale.show();
							System.out.println("등록되었습니다");
							// 해당상품의 소요량 계산.
							RequiredAmount ra = idao.calRequiredAmount(p_code);
						
							// 첫번째 상품-수량. 두번째상품-수량
							String fCode = ra.getIngredient();
							int fqty = ra.getIQty();
							idao.outQty(fCode, fqty);
	
							String sCode = ra.getIngredient2();
							int sqty = ra.getBQty();
							System.out.println(ra);
							idao.outQty(sCode, sqty);
	
						} else {
							System.out.println("등록 중 오류");
						}
						break;
	
					case 2: /* 판매조회(상품별) */
						ArrayList<InOut> saleAry = pdao.getSaleList();
						System.out.println("==========================");
						System.out.println("No  상품코드  제품명  수량  날짜");
						System.out.println("==========================");
						for (InOut ilist : saleAry) {
							if (ilist != null) {
								ilist.showInfo();
							}
						}
						break;
	
					case 3: /* 판매조회(날짜별) */
						ArrayList<InOut> saleDateAry = pdao.getSaleDateList();
						System.out.println("===========================");
						System.out.println("No  상품코드  제품명  수량  날짜");
						System.out.println("===========================");
						for (InOut ilist : saleDateAry) {
							if (ilist != null) {
								ilist.showDateInfo();
							}
						}
						break;
						
					case 4:
						run1 = false;
						break;	
					}
				}
				break;

			case 5: /* 재고관리 */
				System.out.println("[재고관리 메뉴를 선택하세요]");
				run1 = true;
				while(run1) {
					System.out.println("1)재료재고 2)나가기");
					menu = Integer.parseInt(scn.nextLine());
					switch (menu) {
					case 1: /* 재료재고 */
						// ArrayList<Ingredient> inventoryAry = null;
						ArrayList<InOut> inventoryAry = pdao.getInventoryList();
						System.out.println("===================");
						System.out.println("상품코드  재료명  수량");
						System.out.println("===================");
						for (InOut ilist : inventoryAry) {
							if (ilist != null) {
								ilist.showInventoryInfo();
							}
						}
					break;
					case 2:
						run1 = false;
						break;
//					case 2: /* 붕어빵재고 */
//						// ArrayList<Ingredient> inventoryAry = null;
//						ArrayList<InOut> breadAry = pdao.getBreadList();
//						System.out.println("===================");
//						System.out.println("상품코드  제품명  수량");
//						System.out.println("===================");
//						for (InOut ilist : breadAry) {
//							if (ilist != null) {
//								ilist.showInventoryInfo();
//							}
//						}
					}
				}
				break;

			case 6: /* 종료 */
				System.out.println("[프로그램이 종료됩니다]");
				run = false;
			}

		} // end of while
	} // end of main
} // end of class
