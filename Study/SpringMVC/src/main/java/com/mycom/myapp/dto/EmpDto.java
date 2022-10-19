package com.mycom.myapp.dto;

public class EmpDto {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String hireDates;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHireDates() {
		return hireDates;
	}
	public void setHireDates(String hireDates) {
		this.hireDates = hireDates;
	}
	@Override
	public String toString() {
		return "EmpDto [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", hireDates=" + hireDates + "]";
	}
	public EmpDto(int employeeId, String firstName, String lastName, String email, String hireDates) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hireDates = hireDates;
	}
	
	public EmpDto() {}
}
