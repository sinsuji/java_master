package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExe2 {
	public static void main(String[] args) {
		Map<Member, String> map;
		map = new HashMap<>();
		
		map.put(new Member("M001", "홍길동", 100), "경기도 100번지");
		map.put(new Member("M002", "김민수", 90), "서울시 200번지");
		map.put(new Member("M003", "박씨", 80), "대전시 300번지");
		map.put(new Member("M001", "홍길동", 100), "경기도 200번지");
		
		map.remove(new Member("M001", "홍길동", 100));
		
		// Set : 중복된 값은 담지 않음
		// 1) key를 set 저장
		Set<Member> set = map.keySet();
		for(Member member : set) {
			System.out.println("key : " + member + ", value : " + map.get(member));
		}
		
		// 2) key, value => set에 저장
		Set<Entry<Member, String>> entry = map.entrySet();
		for(Entry<Member, String> ent : entry) {
			System.out.println("Key : " + ent.getKey() + ", Val : " + ent.getValue());
		}
	}
}
