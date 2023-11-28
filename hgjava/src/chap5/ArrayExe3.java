package chap5;

public class ArrayExe3 {
	public static void main(String[] args) {
		String[] nameAry = {"홍길동", "김길동", "홍길동", "박길동", "홍길동", "황길동"};
		
		String search = "홍길동";
		int count = 0;
		// for반복문 활용
		for(String name : nameAry) { // for(int i = 0; i < nameAry.length; i++)
			if(name.equals(search)) { // nameAry[i].equals(search)
				count++;
			}
		}
		System.out.println(search + "은 총 " + count + "명 입니다");
		
		// 제일 큰수를 담으시오
		int[] scores = {88, 68, 72, 89, 92, 70};
		int maxScore = 0;
		for(int num : scores) { // for(int i = 0; i < scores.length; i++)
			if(maxScore < num) { // if(maxScore < scores[i])
				maxScore = num; // maxScore = scores[i];
			}
		}
		System.out.println("제일 큰 수는 " + maxScore + "입니다");
				
	} // end main
} // end class