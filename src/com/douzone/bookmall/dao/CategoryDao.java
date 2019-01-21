package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CategoryVo;

public class CategoryDao {
	public List<CategoryVo> getList(){
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			conn = Conn.getConnection();
			//3. statement 객체를 생성
			stmt = conn.createStatement();
			//4. SQL문 실행
			String sql = "select no,name from category";
			rs = stmt.executeQuery(sql);
			//5. 결과
			while(rs.next()) {
				long no = rs.getLong(1);
				String name = rs.getString(2);
				
				CategoryVo vo = new CategoryVo();
				vo.setNo(no);
				vo.setName(name);
				
				
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
	
	
	public boolean insert(CategoryVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			
			conn =  Conn.getConnection();
			//3. statement 객체를 생성
			String sql = "insert into category values(null, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  vo.getName());
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
			String sql = "delete from category";
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
	
	
	
	public  void print() {
		System.out.println("=========================카테고리 리스트=========================");
		List<CategoryVo> list = getList();
		for(CategoryVo vo : list){
			System.out.println(vo);
		}
	}
	
	public  void insert(String name) {
		CategoryVo vo = new CategoryVo();
		vo.setName(name);
		insert(vo);
	}
	
}
