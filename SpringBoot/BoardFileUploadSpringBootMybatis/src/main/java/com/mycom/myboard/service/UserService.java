package com.mycom.myboard.service;

import com.mycom.myboard.dto.UserDto;
import com.mycom.myboard.dto.UserResultDto;

public interface UserService {
	
	// 회원가입 성공 실패 여부 
	UserResultDto userRegister(UserDto userDto);
}
