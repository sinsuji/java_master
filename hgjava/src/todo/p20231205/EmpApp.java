package todo.p20231205;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		EmpExe exe = new EmpExe();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회 6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
				case 1: // 등록
					System.out.println("등록할 정보를 입력하세요");
					System.out.println("사번 >> ");
					String no = scn.nextLine();
					System.out.println("이름 >> ");
					String name = scn.nextLine();
					System.out.println("전화번호 >> ");
					String tel = scn.nextLine();
					System.out.println("입사일자 >> ");
					String date = scn.nextLine();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					System.out.println("급여 >> ");
					int money = Integer.parseInt(scn.nextLine());
					
					Emp emp = new Emp(no, name, tel, date, money);
										
					if(exe.addEmp(emp)) {
						System.out.println("등록이 완료되었습니다");
					}else {
						System.out.println("등록 실패");
					}
					break;
				case 2: // 목록
					System.out.println("사번 이름 전화번호 입사일자 급여");
					for(Emp exeList : exe.getEmpList()) {
						if(exeList != null) {
							System.out.println(exeList.showInfo());
						}
					}
					break;
				case 3: // 수정
					System.out.println("사번입력 >> ");
					no = scn.nextLine();
					System.out.println("수정할 급여입력 >> ");
					money = Integer.parseInt(scn.nextLine());
					if(exe.modifyEmp(no, money)) {
						System.out.println("수정되었습니다.");
					}else {
						System.out.println("수정실패");
					}
					break;
				case 4: // 삭제
					System.out.println("사번입력 >> ");
					no = scn.nextLine();
					if(exe.removeEmp(no)) {
						System.out.println("삭제되었습니다.");
					}else {
						System.out.println("삭제실패");
					}
					break;
				case 5: // 단건조회
					System.out.println("입사일자입력 >> ");
					date = scn.nextLine();
					Emp empInfo = exe.getEmp(date);
					if(empInfo != null) {
						System.out.println(empInfo.showInfo());
					}else {
						System.out.println("존재하지 않는 정보");
					}
					break;
				case 6: // 종료
					run = false;
					System.out.println("종료");
					
			}
		} // end of while
	} // end of main
} // end of class
