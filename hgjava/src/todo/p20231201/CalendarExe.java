package todo.p20231201;

public class CalendarExe {
	public static void main(String[] args) {
		// 12월 달력 작성
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		
		// 빈공백 생성
		for(int i = 0; i < 5; i++) {
			System.out.printf("%4s", "");
		}
		
		for (int i = 1; i <= 31; i++) {
			System.out.printf("%4d", i);
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n== the end ==");
	}
}
