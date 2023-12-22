package com.yedam.student.serviceImpl;

import java.util.List;

import com.yedam.student.mapper.StudentDAO;
import com.yedam.student.service.StudentService;
import com.yedam.student.vo.Student;

// 기능구현
public class StudentServiceImpl implements StudentService {
	
	StudentDAO dao = new StudentDAO();
	
	@Override // 목록
	public List<Student> studentList() {
		return dao.getStudentList();
	}

	@Override // 추가
	public boolean addStudent(Student std) {
		return dao.addStudent(std);
	}

	@Override // 수정
	public boolean modStudent(String sno, int escore, int mscore) {
		return dao.modifyStudent(sno, escore, mscore);
	}

	@Override // 삭제
	public boolean remStudent(String sno) {
		return dao.removeStudent(sno);
	}

	@Override // 단건조회
	public Student getStudent(String sno) {
		return dao.getStudent(sno);
	}
	
	
}
