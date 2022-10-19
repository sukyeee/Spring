package com.mycom.hw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.hw.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource datasource;

	@Override
	public UserDto userDetail(String userId) {
		UserDto dto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = datasource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(" select id, password, name, email, age ")
			.append(" from user where id = ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new UserDto();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setAge(rs.getInt("age"));
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( pstmt != null) pstmt.close();
				if( con != null ) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}

	@Override
	public List<UserDto> userList() {

		List<UserDto> list = new ArrayList<UserDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = datasource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(" select id, password, name, email, age")
			.append(" from user ");
			
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserDto dto = new UserDto();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setAge(rs.getInt("age"));
				
				list.add(dto);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( pstmt != null) pstmt.close();
				if( con != null ) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public int userInsert(UserDto dto) {
		
		int ret = -1;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = datasource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(" insert into user (id, password, name, email, age)  ")
			.append(" values ( ?, ?, ?, ?, ? ) ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setInt(5, dto.getAge());
			
			ret = pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( pstmt != null) pstmt.close();
				if( con != null ) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}

	@Override
	public int userDelete(String userId) {
		int ret = -1;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = datasource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(" delete from user where id = ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, userId);
			ret = pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( pstmt != null) pstmt.close();
				if( con != null ) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}

	@Override
	public int userUpdate(UserDto dto) {
		int ret = -1;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = datasource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(" update user set password = ?, email = ?, age = ? where id = ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getEmail());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getId());
			
				
			ret = pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( pstmt != null) pstmt.close();
				if( con != null ) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}
	
}
