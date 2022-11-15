package com.mycom.myboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myboard.dao.LoginDao;
import com.mycom.myboard.dto.UserDto;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao loginDao;
	
	@Override
	public UserDto login(UserDto dto) {
		System.out.println(dto);
		UserDto userDto = loginDao.login(dto.getUserEmail());
		System.out.println(userDto);
		if( userDto != null && userDto.getUserPassword().equals(dto.getUserPassword())) {
			return userDto;
		}else {
			return null;
		}
	}
}