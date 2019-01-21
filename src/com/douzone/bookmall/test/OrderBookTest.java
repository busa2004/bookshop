package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.OrderBookDao;
import com.douzone.bookmall.vo.OrderBookVo;


public class OrderBookTest {
	public static void main(String[] args) {

		insertTest(3,1,1);
		getListTest();
		
	}
	public static void getListTest() {
		List<OrderBookVo> list = new OrderBookDao().getList();
		for(OrderBookVo vo : list){
			System.out.println(vo);
		}
	}
	
	public static void insertTest(long count,long book_no,long order_no) {
		OrderBookVo vo = new OrderBookVo();
		vo.setCount(count);
		vo.setBook_no(book_no);
		vo.setOrder_no(order_no);
		new OrderBookDao().insert(vo);
	}
}
