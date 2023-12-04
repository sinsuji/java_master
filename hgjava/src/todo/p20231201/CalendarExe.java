package todo.p20231201;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		
		int year = 2023;
		int month = 12;
		
		Calendar today = Calendar.getInstance();
		
		
		// 10월 달력 작성
		// today.set(Calendar.YEAR, year);
		today.set(Calendar.MONTH, 11);
		today.set(Calendar.DATE, 1);
		
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		
		// 빈공백 생성 // 요일 계산
		for(int i = 0; i < today.get(Calendar.DAY_OF_WEEK) - 1; i++) {
			System.out.printf("%4s", "");
		}
		
		// 마지막 날짜 계산
		for (int i = 1; i <= today.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%4d", i);
			if ((i + today.get(Calendar.DAY_OF_WEEK) - 1) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n== the end ==");
	}
}
