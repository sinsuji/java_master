package chap8;

// 추상클래스처럼 추상메소드만 정의할 수 있음
// Oracle : insert(), update() / MySQL : add(), modify()
// 
public interface DatabaseService {
	public static final String name = ""; // 상수만 사용가능
	// 입력, 수정, 삭제
	
	public abstract void add(); // abstract를 써도되고 안써도 됨
	public void modify();
	public void remove();
}
