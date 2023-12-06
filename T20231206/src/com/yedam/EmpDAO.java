package com.yedam;

import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	List<Employee> emps;
	
	EmpDAO(){
		emps = new ArrayList<>();
		emps.add(new Employee("23-11", "홍길동", "943-1234", "2023-12-06", 200));
		emps.add(new Employee("23-12", "김길동", "943-1244", "2023-12-06", 250));
		emps.add(new Employee("23-13", "박길동", "943-1254", "2023-12-06", 300));
	}
	
	boolean addEmp(Employee emp) { // 등록
		return emps.add(emp);
	}
	
	List<Employee> getEmpList() {
		return emps;
	}
	
	boolean modifyEmp(String no, int money) { // 수정
		for(int i = 0; i < emps.size(); i++) {
			if(emps.get(i).getEmpNo().equals(no)) {
				emps.get(i).setEmpMoney(money);
				return true;
			}
		}
		return false;
	}
	
	boolean removeEmp(String no) { // 삭제
		for(int i = 0; i < emps.size(); i++) {
			if(emps.get(i).getEmpNo().equals(no)) {
				emps.remove(i);
				return true;
			}
		}
		return false;
	}
	
	List<Employee> getEmpInfo(String date) { // 조회
		List<Employee> list = new ArrayList<>();
		for(int i = 0; i < emps.size(); i++) {
			if(emps.get(i).getEmpDate().equals(date)) {
				list.add(emps.get(i));
			}
		}
		return list;
	}
}
