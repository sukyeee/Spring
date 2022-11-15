package com.mycom.myboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myboard.dto.CodeDto;


@Mapper
public interface CodeDao {
	List<CodeDto> codeList(String groupCode);
}
