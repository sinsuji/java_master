package todo.p20231205;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Emp {
	private String empNo;
	private String empName;
	private String empTel;
	private String empDate;
//	private Date empDate;
	private int empMoney;

	Emp(){
		
	}
	
	public Emp(String empNo, String empName, String empTel, int empMoney, String empDate) {
		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empDate = empDate;
//		this.empDate = new Date();
		this.empMoney = empMoney;
	}
	
	public Emp(String empNo, String empName, String empTel, String empDate, int empMoney) {
		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empDate = empDate;
		this.empMoney = empMoney;
	}
	
	String showInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//sdf.format(empDate)
		String result = empNo + " " + empName + " " + empTel + " " + empDate + " " + empMoney;
		return result;
	}
}
