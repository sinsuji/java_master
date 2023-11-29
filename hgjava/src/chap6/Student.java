package chap6;

public class Student {
	private String stuNo;
	private String stuName;
	private int stuEng;
	private int stuMat;
	
	Student(){
		
	}
	
	public Student(String stuNo, String stuName, int stuEng, int stuMat) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuEng = stuEng;
		this.stuMat = stuMat;
	}
	
	void showInfo() {
		System.out.println("학생의 이름은 " + stuName + ", 영어점수는 " + stuEng + "점, 수학점수는 " + stuMat + "점 입니다");
	}

	String getStuNo() {
		return stuNo;
	}

	String getStuName() {
		return stuName;
	}

	int getStuEng() {
		return stuEng;
	}

	int getStuMat() {
		return stuMat;
	}

	void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	void setStuName(String stuName) {
		this.stuName = stuName;
	}

	void setStuEng(int stuEng) {
		this.stuEng = stuEng;
	}

	void setStuMat(int stuMat) {
		this.stuMat = stuMat;
	}
	
	
}
