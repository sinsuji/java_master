package com.yedam.student.vo;

public class Student {
	private String stuNo;
	private String stuName;
	private int stuEng;
	private int stuMat;
	
	// 생성자 정의
	public Student(){
		
	}
	
	public Student(String stuNo, String stuName, int stuEng, int stuMat) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuEng = stuEng;
		this.stuMat = stuMat;
	}
	
	public void showInfo() {
		System.out.println("학생의 이름은 " + stuName + ", 영어점수는 " + stuEng + "점, 수학점수는 " + stuMat + "점 입니다");
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuEng() {
		return stuEng;
	}

	public void setStuEng(int stuEng) {
		this.stuEng = stuEng;
	}

	public int getStuMat() {
		return stuMat;
	}

	public void setStuMat(int stuMat) {
		this.stuMat = stuMat;
	}

	
	
	
}
