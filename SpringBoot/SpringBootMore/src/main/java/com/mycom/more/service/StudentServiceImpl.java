package com.mycom.more.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.more.dao.StudentDao;
import com.mycom.more.dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao dao;

	@Override
	public List<StudentDto> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public StudentDto detail(int studentId) {
		// TODO Auto-generated method stub
		return dao.detail(studentId);
	}

	@Override
//	@Transactional // 비싼 어노테이션 ⇒ 반드시 필요한 경우에만 사용
	public int insert(StudentDto dto) {
		// TODO Auto-generated method stub
//		dao.insert(dto);	
		return dao.insert(dto);
	}

	@Override
//	@Transactional
	public int update(StudentDto dto) {
		
//		dao.update(dto); // A
		
//		String str = null;
//		str.length();
		
//		dto.setEmail("test");
		
		// dto의 setter를 이용해서 값을 변경 // B 
		return dao.update(dto);
	}

	@Override
	public int delete(int studentId) {
		// TODO Auto-generated method stub
		return dao.delete(studentId);
	}
}
