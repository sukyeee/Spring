package com.ssafy.member.model.dao;

import java.sql.SQLException;
import java.util.Map;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.SqlMapConfig;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Override
	public int idCheck(String userId) throws SQLException {
		return 0;
	}

	@Override
	public void joinMember(MemberDto memberDto) throws SQLException {
		
	}

	@Override
	public MemberDto loginMember(Map<String, String> map) throws SQLException {
		return null;
	}

}
