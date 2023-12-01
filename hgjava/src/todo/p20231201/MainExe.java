package todo.p20231201;

public class MainExe {
	public static void main(String[] args) {
		// 배열 안에 들어있는 값이 또 배열
		int[][] numAry = // {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
						{
							{1, 2, 3, 4},
							{5, 6, 7, 8},
							{9, 10, 11, 12},
							{13, 14, 15, 16}
						};
		// System.out.println(numAry[0].length);
//		for(int i = 0; i < 4; i++) {
//			for(int j = 0; j < 4; j++) {
//				System.out.printf("%3d", numAry[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("======= end =======");
		
		for(int i = 3; i >= 0; i--) {
			for(int j = 0; j < 4; j++) {
				System.out.printf("%3d", numAry[i][j]);
			}
			System.out.println();
		}
		System.out.println("======= end =======");
	}
}
