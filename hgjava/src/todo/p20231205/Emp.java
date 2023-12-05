package todo.p20231205;

import lombok.Data;

@Data
public class Emp {
	private String empNo;
	private String empName;
	private String empTel;
	private String empDate;
	private int empMoney;

	Emp(){
		
	}
	
	public Emp(String empNo, String empName, String empTel, String empDate, int empMoney) {
		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empDate = empDate;
		this.empMoney = empMoney;
	}
	
	String showInfo() {
		String result = empNo + " " + empName + " " + empTel + " " + empDate + " " + empMoney;
		return result;
	}
}
