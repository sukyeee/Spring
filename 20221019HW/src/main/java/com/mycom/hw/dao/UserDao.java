package com.mycom.hw.dao;

import java.util.List;

import com.mycom.hw.dto.UserDto;

public interface UserDao {

	UserDto userDetail(String userId);
	List<UserDto> userList();
	public int userInsert(UserDto dto);
	public int userDelete(String userId);
	public int userUpdate(UserDto dto);
	
}
