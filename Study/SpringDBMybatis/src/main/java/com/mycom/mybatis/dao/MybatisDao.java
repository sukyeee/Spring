package com.mycom.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.mybatis.dto.EmpDto;

@Mapper
public interface MybatisDao {

	EmpDto empDetail(int employeeId);
	List<EmpDto> empList();
	public int empInsert(EmpDto dto);
	public int empDelete(int employeeId);
	public int empUpdate(EmpDto dto);
	
}
