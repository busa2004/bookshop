package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.BookVo;
import com.douzone.bookmall.vo.UserVo;

public class UserDao {
	public List<UserVo> getList(){
		List<UserVo> list = new ArrayList<UserVo>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			conn = Conn.getConnection();
			//3. statement 객체를 생성
			stmt = conn.createStatement();
			//4. SQL문 실행
			String sql = "select no,name,number,email,password from user";
			rs = stmt.executeQuery(sql);
			//5. 결과
			while(rs.next()) {
				long no = rs.getLong(1);
				String name = rs.getString(2);
				String number = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);
				
				UserVo vo = new UserVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setNumber(number);
				vo.setEmail(email);
				vo.setPassword(password);
				
				
				list.add(vo);
			}
			
		}catch (SQLException e) {
			System.out.println("error:" +e);
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn != null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return list;
	}
	
	
	public boolean insert(UserVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			
			conn =  Conn.getConnection();
			//3. statement 객체를 생성
			String sql = "insert into user values(null, ?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  vo.getName());
			pstmt.setString(2,  vo.getNumber());
			pstmt.setString(3,  vo.getEmail());
			pstmt.setString(4,  vo.getPassword());
			int count = pstmt.executeUpdate();
			result = count == 1;
		}catch (SQLException e) {
			System.out.println("error:" +e);
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn != null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	public void print() {
		System.out.println("=========================회원 리스트=========================");
		List<UserVo> list = getList();
		for(UserVo vo : list){
			System.out.println(vo);
		}
	}
	public void insert(String name, String number, String email, String password) {
		UserVo vo = new UserVo();
		vo.setName(name);
		vo.setNumber(number);;
		vo.setEmail(email);;
		vo.setPassword(password);;
		
		insert(vo);
	}
	
	public boolean delete() {
		boolean result = false;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//1. JDBC Driver 로딩
			conn =  Conn.getConnection();
			//3. statement 객체를 생성
		 stmt = conn.createStatement();
			//4. SQL문 실행
			String sql = "delete from user";
			int count = stmt.executeUpdate(sql);
			
			result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("error:" +e);
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn != null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}
}
