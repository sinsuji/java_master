package chap6;
// 회원관리 앱
// 회원번호, 회원이름, 연락처, 성별
// public <-> private
public class Member {
	// 속성(필드)
	private int memberNo; // 자바에서는 두단어 이상의 조합 : CamelCase
	private String memberName;
	private String phone; // 010-1234-5678
	private String gender; // Men or Women => M, W
	
	// 생성자 : 필드의 초기값을 지정
	// 기본생성자 컴파일러가 생성
	Member() {
		
	}
	Member(int memberNo, String memberName){
		this.memberNo = memberNo;
		this.memberName = memberName;
	}
	
	public Member(int memberNo, String memberName, String phone, String gender) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.phone = phone;
		this.gender = gender;
	}
	// 기능(메소드)
	void showInfo() { // void => 반환되는 값이 없음 - 콘솔만 출력하고 끝
		System.out.println("이름은 " + memberName + "이고 연락처는 " + phone + " 입니다");
	}
	
	String showAllInfo() { // 문자열을 반환하는 메소드
		String result = "이름은 " + memberName + "이고 번호는 " + memberNo + "이고 연락처는 " + phone + " 이고 성별은 " + gender + " 입니다";
		return result; // 문자열 값을 반환하겠음
	}
	
	// memberNo의 값을 지정하는 메소드
	void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	void setPhone(String phone) {
		this.phone = phone;
	}
	void setGender(String gender) {
		this.gender = gender;
	}
	
	// getter 값을 가져오기 위한 메소드
	int getMemberNo() {
		return memberNo;
	}
	String getMemberName() {
		return memberName;
	}
	String getPhone() {
		return phone;
	}
	String getGender() {
		return gender;
	}
	
}
