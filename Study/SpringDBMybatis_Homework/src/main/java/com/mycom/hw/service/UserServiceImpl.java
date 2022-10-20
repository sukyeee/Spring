package com.mycom.hw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.hw.dao.UserDao;
import com.mycom.hw.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao dao;

	@Override
	public UserDto userDetail(String userId) {
		// TODO Auto-generated method stub
		return dao.userDetail(userId);
	}

	@Override
	public List<UserDto> userList() {
		return dao.userList();
	}
	
	@Override
	public int userInsert( UserDto dto) {
		return dao.userInsert(dto);
		}

	@Override
	public int userDelete(String userId) {
		return dao.userDelete(userId);
	}

	@Override
	public int userUpdate(UserDto dto) {
		return dao.userUpdate(dto);
	}
	
}
