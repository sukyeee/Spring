package com.mycom.mybatis.service;

import java.util.List;

import com.mycom.mybatis.dto.EmpDto;

public interface MybatisService {
	EmpDto empDetail(int employeeId);
	List<EmpDto> empList();
	public int empInsert(EmpDto dto);
	public int empDelete(int employeeId);
	public int empUpdate(EmpDto dto);

}
