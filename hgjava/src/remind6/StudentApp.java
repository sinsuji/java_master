package remind6;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		boolean run = true;
		
		// Student[] students = new Student[100];
		
		Scanner scn = new Scanner(System.in);
		StudentExe exe = new StudentExe();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
				case 1 :
					System.out.println("학생번호입력 >>");
					String no = scn.nextLine();
					System.out.println("학생이름입력 >>");
					String name = scn.nextLine();
					System.out.println("영어점수입력 >>");
					int eng = Integer.parseInt(scn.nextLine());
					System.out.println("수학점수입력 >>");
					int mat = Integer.parseInt(scn.nextLine());
					
					Student std = new Student(no, name, eng, mat);
					// students 배열에 한건 저장
					if(exe.addStudent(std)) {
						System.out.println("저장되었습니다");
					}else {
						System.out.println("저장 중 오류");
					}
//					for(int i = 0; i < students.length; i++) {
//						if(students[i] == null) {
//							students[i] = std;
//							break;
//						}
//					}
//					System.out.println("저장되었습니다");
					break;
				case 2 : // 목록보기
					for(Student stdnt : exe.getStudentList()) {
						if(stdnt != null) {
							stdnt.showInfo();
						}
					} // Student[] 타입
//					for(int i = 0; i < students.length; i++) {
//						if(students[i] != null) {
//							students[i].showInfo();
//						}
//					}
					break;
				case 3 : // 단건조회
					System.out.println("조회할 학생번호 입력 >>");
					no = scn.nextLine();
					Student stnt = exe.getStudent(no);
					if(stnt != null) {
						stnt.showInfo();
					}else {
						System.out.println("존재하지 않는 정보");
					}
//					boolean exists = false;
//					
//					for(int i = 0; i < students.length; i++) {
//						if(students[i] != null && students[i].getStuNo().equals(no)) {
//							students[i].showInfo();
//							exists = true;
//						}
//					}
					// 찾는 번호 없음
//					if(!exists) {
//						System.out.println("조회할 번호가 없습니다");
//					}
					break;
				case 4 : // 수정 - 학생번호를 찾고, 영어점수 수학점수 변경
					System.out.println("수정할 학생번호 입력 >>");
					no = scn.nextLine();
					System.out.println("영어점수 입력 >>");
					eng = Integer.parseInt(scn.nextLine());
					System.out.println("수학점수 입력 >>");
					mat = Integer.parseInt(scn.nextLine());
					
					if(exe.modifyStudent(no, eng, mat)) {
						System.out.println("수정 완료");
					}else {
						System.out.println("수정 실패");
					}
					
//					exists = false;
//					for(int i = 0; i < students.length; i++) {
//						if(students[i] != null && students[i].getStuNo().equals(no)) {
//							System.out.println("영어점수 입력 >>");
//							students[i].setStuEng(Integer.parseInt(scn.nextLine()));
//							System.out.println("수학점수 입력 >>");
//							students[i].setStuMat(Integer.parseInt(scn.nextLine()));
//							exists = true;
//							break;
//						}
//					}
//					// 찾는 번호 없음
//					if(!exists) {
//						System.out.println("조회할 번호가 없습니다");
//					}
					break;
				case 5 : // 삭제
					System.out.println("삭제할 학생이름 입렵 >>");
					name = scn.nextLine();
					if(exe.removeStudent(name)) {
						System.out.println("삭제 완료");
					}else {
						System.out.println("삭제 실패");
					}
//					boolean exists = false;
//					for(int i = 0; i < students.length; i++) {
//						if(students[i] != null && students[i].getStuName().equals(name)) {
//							students[i] = null;
//							exists = true;
//						}
//					}
//					// 찾는 이름 없음
//					if(!exists) {
//						System.out.println("조회할 이름이 없습니다");
//					}
					break;
				case 6 :
					System.out.println("프로그램을 종료합니다");
					run = false;
					break;
			}
		} // end of while
		System.out.println("end of prog");
	
	} // end of main
} // end of class
