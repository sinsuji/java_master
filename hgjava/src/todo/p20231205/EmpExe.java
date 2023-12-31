package todo.p20231205;

import java.util.ArrayList;
import java.util.List;

public class EmpExe {
	private List<Emp> emps;
	
	EmpExe(){
		emps = new ArrayList<>();
		emps.add(new Emp("01", "홍길동", "010-1111-1111", "2023-11-27", 1000));
	}
	
	// 등록
	boolean addEmp(Emp emp) {
		return emps.add(emp);
	}
	
	// 조회
	List<Emp> getEmpList() {
		return emps;
	}
	
	// 수정
	boolean modifyEmp(String no, int money) {
		for(int i = 0; i < emps.size(); i++) {
			if(emps.get(i).getEmpNo().equals(no)) {
				emps.get(i).setEmpMoney(money);
				return true;
			}
		}
		return false;
	}
	
	// 삭제 
	boolean removeEmp(String no) {
		for(int i = 0; i < emps.size(); i++) {
			if(emps.get(i).getEmpNo().equals(no)) {
				emps.remove(i);
				return true;
			}
		}
		return false;
	}
	// 조회
	List<Emp> getEmp(String date) {
		List<Emp> list = new ArrayList<>();
		for(int i = 0; i < emps.size(); i++) {
			if(emps.get(i).getEmpDate().equals(date)) {
				list.add(emps.get(i));
			}
		}
		return list;
	}
	
}
