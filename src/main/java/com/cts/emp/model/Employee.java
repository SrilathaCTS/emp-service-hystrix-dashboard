package com.cts.emp.model;

import java.util.List;

public class Employee {

	private int empId;
	private String empName;
	private List<String> empPhoneNumbers;
	
	
	public Employee(int empId, String empName, List<String> empPhoneNumbers) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPhoneNumbers = empPhoneNumbers;
	}
	
	public int getEmpId() {
		return empId; 
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public List<String> getEmpPhoneNumbers() {
		return empPhoneNumbers;
	}
	public void setEmpPhoneNumbers(List<String> empPhoneNumbers) {
		this.empPhoneNumbers = empPhoneNumbers;
	}
	 
	
	
}
