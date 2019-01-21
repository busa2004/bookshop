package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CartVo;
import com.douzone.bookmall.vo.UserVo;

public class CartDao {
	public List<CartVo> getList(){
		List<CartVo> list = new ArrayList<CartVo>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			conn = Conn.getConnection();
			//3. statement 객체를 생성
			stmt = conn.createStatement();
			//4. SQL문 실행
			String sql = "select a.count,b.name,b.price,a.user_no from cart a, book b where b.no=a.book_no";
			rs = stmt.executeQuery(sql);
			//5. 결과
			while(rs.next()) {
				long count = rs.getLong(1);
				String book_name = rs.getString(2);
				long book_price = rs.getLong(3);
				long user_no = rs.getLong(4);
				
				CartVo vo = new CartVo();
				vo.setCount(count);
				vo.setBook_name(book_name);
				vo.setBook_price(book_price);
				vo.setUser_no(user_no);
				
				
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
	
	public boolean insert(CartVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			
			conn =  Conn.getConnection();
			//3. statement 객체를 생성
			String sql = "insert into cart values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,  vo.getCount());
			pstmt.setLong(2,  vo.getBook_no());
			pstmt.setLong(3,  vo.getUser_no());
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
			String sql = "delete from cart";
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
		System.out.println("=========================카트 리스트=========================");
		List<CartVo> list = getList();
		for(CartVo vo : list){
			System.out.println(vo);
		}
	}
	
	public  void insert(long count, long book_no, long user_no) {
		CartVo vo = new CartVo();
		vo.setCount(count);
		vo.setBook_no(book_no);
		vo.setUser_no(user_no);
		insert(vo);
	}

}
