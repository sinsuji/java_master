package com.yedam;

public class Employee {
	private String EmpNo;
	private String EmpName;
	private String EmpTel;
	private String EmpDate;
	private int EmpMoney;
	
	Employee(){}
	
	public Employee(String EmpNo, String EmpName, String EmpTel, String EmpDate, int EmpMoney) {
		this.EmpNo = EmpNo;
		this.EmpName = EmpName;
		this.EmpTel = EmpTel;
		this.EmpDate = EmpDate;
		this.EmpMoney = EmpMoney;
	}
	
	public Employee(String EmpNo, String EmpName, String EmpTel, int EmpMoney) {
		this.EmpNo = EmpNo;
		this.EmpName = EmpName;
		this.EmpTel = EmpTel;
		this.EmpMoney = EmpMoney;
	}
	
	String showInfo() {
		String result = EmpNo + " " + EmpName + " " + EmpTel + " " + EmpMoney;
		return result;
	}
	String showListInfo() {
		String result = EmpNo + " " + EmpName + " " + EmpDate;
		return result;
	}

	public String getEmpNo() {
		return EmpNo;
	}

	public void setEmpNo(String empNo) {
		EmpNo = empNo;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getEmpTel() {
		return EmpTel;
	}

	public void setEmpTel(String empTel) {
		EmpTel = empTel;
	}

	public String getEmpDate() {
		return EmpDate;
	}

	public void setEmpDate(String empDate) {
		EmpDate = empDate;
	}

	public int getEmpMoney() {
		return EmpMoney;
	}

	public void setEmpMoney(int empMoney) {
		EmpMoney = empMoney;
	}
	
	
}
