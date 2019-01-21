package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.OrderBookVo;
import com.douzone.bookmall.vo.OrderInfoVo;

public class OrderBookDao {
	public List<OrderBookVo> getList(){
		List<OrderBookVo> list = new ArrayList<OrderBookVo>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			conn = Conn.getConnection();
			//3. statement 객체를 생성
			stmt = conn.createStatement();
			//4. SQL문 실행
			String sql = "select b.no, b.name,a.count from order_book a, book b where a.book_no = b.no";
			rs = stmt.executeQuery(sql);
			//5. 결과
			while(rs.next()) {
				long book_no = rs.getLong(1);
				String book_name = rs.getString(2);
				long count = rs.getLong(3);
				
				OrderBookVo vo = new OrderBookVo();
				vo.setBook_no(book_no);
				vo.setBook_name(book_name);
				vo.setCount(count);
				
				
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
	
	
	public boolean insert(OrderBookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			
			conn =  Conn.getConnection();
			//3. statement 객체를 생성
			String sql = "insert into order_book values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,  vo.getCount());
			pstmt.setLong(2,  vo.getBook_no());
			pstmt.setLong(3,  vo.getOrder_no());
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
			String sql = "delete from order_book";
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
	
	public void print() {
		System.out.println("=========================주문 도서 리스트=========================");
		List<OrderBookVo> list = getList();
		for(OrderBookVo vo : list){
			System.out.println(vo);
		}
	}
	
	public void insert(long count,long book_no,long order_no) {
		OrderBookVo vo = new OrderBookVo();
		vo.setCount(count);
		vo.setBook_no(book_no);
		vo.setOrder_no(order_no);
		insert(vo);
	}
}
