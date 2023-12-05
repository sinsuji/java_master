package chap13;

import lombok.Data;

@Data
public class Member {
	private String memberNo;
	private String memberName;
	private int point;
	
	public Member(String memberNo, String memberName, int point) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.point = point;
	}
	
	// hashCode, equals 정의하는 지에 따라서 동일객체
//	@Override
//	public int hashCode() {
//		return super.hashCode();
//	}
	
	
}
