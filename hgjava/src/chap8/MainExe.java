package chap8;

import java.util.Scanner;

public class MainExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		DatabaseService svc = new OracleService(); // new MySQLService();
		
		boolean run = true;
		while(run) {
			System.out.println("1.등록 2.수정 3.삭제 4.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1:
				svc.add(); break;
			case 2:
				svc.modify(); break;
			case 3:
				svc.remove(); break;
			}
		}
		System.out.println("end of prog");
	}
}
