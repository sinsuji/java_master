package remind6;
// 저장공간 : 배열
// 추가/수정/삭제/목록/단건조회

import java.util.ArrayList;
import java.util.List;

public class StudentExe {
	// 배열 : 
	// private Student[] students;
	
	List<Student> students = new ArrayList<>();
	
	// 생성자 : 클래스 이름이 메소드처럼 실행되게 함(메소드와 다르게 반환타입이 없음)
	StudentExe() {
		students.add(new Student("23-001", "홍길동", 77, 88));
		students.add(new Student("23-002", "김철수", 82, 85));
	}
	
	// 추가
	boolean addStudent(Student std) {
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i) == null) {
				students.add(std);
//				break;
				return true; // 메소드에서 return문은 메소드의 끝
			}
		}
		return false;
	}
	
	// 목록
	Student[] getStudentList() {
		return students.get(i);
	}
	
	// 단건조회
	Student getStudent(String no) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuNo().equals(no)) {
				return students[i];
			}
		}
		return null;
	}
	
	// 수정
	boolean modifyStudent(String no, int eng, int mat) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuNo().equals(no)) {
				students[i].setStuEng(eng);
				students[i].setStuMat(mat);
				return true;
			}
		}
		return false;
	}
	
	// 삭제
	boolean removeStudent(String name) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuName().equals(name)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}
}
