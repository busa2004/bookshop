package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.OrderInfoVo;

public class OrderInfoDao {
	public List<OrderInfoVo> getList(){
		List<OrderInfoVo> list = new ArrayList<OrderInfoVo>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			conn = Conn.getConnection();
			//3. statement 객체를 생성
			stmt = conn.createStatement();
			//4. SQL문 실행
			String sql = "select a.no,a.payment,a.shipping,b.name,b.email from order_info a, user b where a.user_no = b.no";
			rs = stmt.executeQuery(sql);
			//5. 결과
			while(rs.next()) {
				long no = rs.getLong(1);
				long payment = rs.getLong(2);
				String shipping = rs.getString(3);
				String user_name = rs.getString(4);
				String user_email = rs.getString(5);
				
				
				OrderInfoVo vo = new OrderInfoVo();
				vo.setNo(no);
				vo.setPayment(payment);
				vo.setShipping(shipping);
				vo.setUser_name(user_name);
				vo.setUser_email(user_email);
				
				
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
	
	public boolean insert(OrderInfoVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			
			conn =  Conn.getConnection();
			//3. statement 객체를 생성
			String sql = "insert into order_info values(null, ?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,  vo.getPayment());
			pstmt.setString(2,  vo.getShipping());
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
			String sql = "delete from order_info";
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
		System.out.println("=========================주문 리스트=========================");
		List<OrderInfoVo> list = getList();
		for(OrderInfoVo vo : list){
			System.out.println(vo);
		}
	}
	public  void insert(long payment,String shipping,long user_no) {
		OrderInfoVo vo = new OrderInfoVo();
		vo.setPayment(payment);
		vo.setShipping(shipping);
		vo.setUser_no(user_no);
		insert(vo);
	}
}
