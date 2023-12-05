package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExe {
	public static void main(String[] args) {
		// 키 : 값  쌍으로 구성
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// 추가
		map.put("홍길동", 80);
		map.put("김길동", 85);
		map.put("장효은", 90);
		map.put("홍길동", 90);
		
		//
		Integer result = map.get("홍길동");
		
		// 전체목록
		Set<String> set = map.keySet(); // 키값만 가지고 있음
		for(String key : set) {
			System.out.println("key : " + key + ", value : " + map.get(key));
		}
		
	}
}
