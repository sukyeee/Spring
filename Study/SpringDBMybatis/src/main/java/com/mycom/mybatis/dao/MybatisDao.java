package com.mycom.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.mybatis.dto.EmpDto;

@Mapper
public interface MybatisDao {

	EmpDto empDetail(int employeeId);
	List<EmpDto> empList();
	public int empInsert(EmpDto dto);
	public int empDelete(int employeeId);
	public int empUpdate(EmpDto dto);
	
	List<EmpDto> empListParameterMap(Map<String, String> map);
	List<EmpDto> empListParameterMap2(@Param("firstName") String firstName, @Param("lastName") String lastName);
	List<EmpDto> empListParameterMap3(EmpDto dto);
	List<EmpDto> empListLike(String firstName);
	
}
