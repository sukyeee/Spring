package com.mycom.mydb.dao;

import java.util.List;

import com.mycom.mydb.dto.EmpDto;

public interface DBDao {

	EmpDto empDetail(int employeeId);
	List<EmpDto> empList();
	public int empInsert(EmpDto dto);
	public int empDelete(int employeeId);
	public int empUpdate(EmpDto dto);
	
}
