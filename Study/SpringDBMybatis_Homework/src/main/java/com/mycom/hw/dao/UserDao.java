package com.mycom.hw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.hw.dto.UserDto;

@Mapper
public interface UserDao {

	UserDto userDetail(String userId);
	List<UserDto> userList();
	public int userInsert(UserDto dto);
	public int userDelete(String userId);
	public int userUpdate(UserDto dto);
	
}
