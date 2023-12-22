package com.yedam.student.mapper;

import java.util.List;

import com.yedam.student.vo.Student;

// 기능정의 , 기능구현은 StudentMapper.xml에서 실행
public interface StudentMapper {
	// CRUD
	List<Student> studentList();
	int addStudent(Student std);
	int remStudent(String sno);
}
