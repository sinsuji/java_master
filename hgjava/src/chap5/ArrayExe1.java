package chap5;

public class ArrayExe1 {

	public static void main(String[] args) {
		int a = 10;
		int[] ary = {10, 20, 33, 25, 34};
		int sum = 0;
		// sum = ary[0] + ary[1] + ary[2];
		for(int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		System.out.println("합계는 " + sum + "입니다");
		
		int[] intAry = new int[5];
		System.out.println(intAry[0]);
		
		double[] height = new double[3];
		System.out.println(height[0]);
		
		String[] names = new String[10];
		names[0] = "홍길동";
		names[1] = "김길동";
		System.out.println(names[0]);
		System.out.println(names[2]);
	}

}