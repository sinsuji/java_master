package chap11.object;

public class MathExe {
	public static void main(String[] args) {
		long result = Math.round(-1.5);
		System.out.println("round : " + result);
	
		// 61 ~ 100점
		for(int i = 1; i <= 10; i++) {
			int r = 61 + (int)(Math.random() * 40); // 0 <= x < 40 // max : 39
			System.out.println(r);
		}
		
		// 1 ~ 6까지의 수
		int[] numbers = new int[5];
		// 중복되지 않은 값을 배열에 저장
		for(int i = 1; i < numbers.length; i++) {
			// 1. 1 ~ 6 숫자생성
			boolean exist = false;
			int num = 1 + (int)(Math.random() * 6);
			// 2. 생성된 값이 배열에 있는지 체크
			numbers[i] = num;
			for(int j = 0; j < i; j++) {
				if(numbers[j] == num) {
					exist = true;
				}if(exist) {
					i--;
					continue;
				}
				numbers[i] = num;
			}
			System.out.println(numbers[i]);
		}
	}
}
