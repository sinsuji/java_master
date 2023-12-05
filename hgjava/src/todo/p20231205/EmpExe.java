package todo.p20231205;

import java.util.ArrayList;
import java.util.List;

public class EmpExe {
	private List<Emp> emps = new ArrayList<>();
	
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
	
}
