package com.yedam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		EmpDAO exe = new EmpDAO();
		
		while(true) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회 6.종료");
			int menu;						
			try {
				menu = Integer.parseInt(scn.nextLine()); 
			} catch (NumberFormatException e) {
				System.out.println("정확한 메뉴를 선택하세요");
				continue;
			}
			switch(menu) {
				case 1: // 등록
					System.out.println("정보를 등록하세요");
					System.out.println("사번입력>> ");
					String no = scn.nextLine();
					System.out.println("이름입력>> ");
					String name = scn.nextLine();
					System.out.println("전화번호입력>> ");
					String tel = scn.nextLine();
					System.out.println("입사일입력>> ");					
					String date = scn.nextLine();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					if(date.equals("")) {
						Date empdate = new Date();
						date = sdf.format(empdate);
					}
					System.out.println("급여입력>> ");
					int money = Integer.parseInt(scn.nextLine());
					
					Employee emp = new Employee(no, name, tel, date, money);
					
					if(exe.addEmp(emp)) {
						System.out.println("등록되었습니다");
					}else {
						System.out.println("등록실패");
					}
				break;
				case 2: // 목록
					boolean exist = false;
					System.out.println("사번   이름   전화번호   급여");
					for(Employee empList : exe.getEmpList()) {
						if(empList != null) {
							System.out.println(empList.showInfo());
							exist = true;
						}
					}
					if(!exist) {
						System.out.println("정보가 없습니다");
					}
				break;
				case 3: // 수정
					System.out.println("수정할 정보를 등록하세요");
					System.out.println("사번입력>> ");
					no = scn.nextLine();
					System.out.println("급여입력>> ");
					money = Integer.parseInt(scn.nextLine());
					if(exe.modifyEmp(no, money)) {
						System.out.println("수정되었습니다");
					}else {
						System.out.println("수정실패");
					}
				break;
				case 4: // 삭제
					System.out.println("삭제할 정보를 등록하세요");
					System.out.println("사번입력>> ");
					no = scn.nextLine();
					if(exe.removeEmp(no)) {
						System.out.println("삭제되었습니다");
					}else {
						System.out.println("삭제실패");
					}
				break;
				case 5: // 조회
					System.out.println("조회할 정보를 입력하세요");
					System.out.println("입사일자>> ");
					date = scn.nextLine();
					List<Employee> empInfo = exe.getEmpInfo(date);
					for(Employee emp1 : empInfo) {
						if(empInfo.size() > 0) {
							System.out.println(emp1.showListInfo());
						}else {
							System.out.println("정보가 없습니다");
						}
					}
				break;
				case 6: // 종료 
					System.out.println("프로그램 종료");
					run = false;
			
			}
			
		} // end of while
		
	} // end of main
} // end of class
