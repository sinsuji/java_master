package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TypingSpeedGame {
	public static void main(String[] args) {
		String word = "Everyone has the right to freedom of thought conscience and religion";
		String[] words = word.split(" ");
		List<String> list = new ArrayList<>();
		// list 목록에 데이터를 쌓아넣음
		for(String str : words) {
			list.add(str);
		}
		
		boolean run = true;
		
		
		// 목록출력
		Scanner scn = new Scanner(System.in);
		
		// 사용자 입력값과 컬렉션의 값과 비교해서 같은 단어가 있으면 삭제
		// 시작시점 ~ 종료시점 걸린시간을 초단위로 계산
		// 완료하는데 35초가 걸림
		
		long start = System.currentTimeMillis();
		while(run) {
			// 목록출력하고
//			for(String str : list) {
//				list.add(str);
//			}
			
			System.out.println(list);
			System.out.println(list.size());
			
			// 입력값과 목록값과 비교해서 있으면 제거
			System.out.print("단어 입력 >> ");
			String save = scn.nextLine();
			boolean exist = false;
			
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).equals(save)) {
					list.remove(i);
					exist = true;
				}
			}
			if(list.size() == 0){
				System.out.println("종료");
				// break;
				run = false;
			}
			if(!exist) {
				System.out.println("없는 단어");
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("완료시간 : " + (end - start)/1000 + "초");
		System.out.println("end of game");
		
		
		
		
	}
}
