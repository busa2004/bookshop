package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.vo.CartVo;


public class CartTest {
	public static void main(String[] args) {

		insertTest(1,1,1);
		getListTest();
		
		
	}
	public static void getListTest() {
		List<CartVo> list = new CartDao().getList();
		for(CartVo vo : list){
			System.out.println(vo);
		}
	}
	
	public static void insertTest(long count, long book_no, long user_no) {
		CartVo vo = new CartVo();
		vo.setCount(count);
		vo.setBook_no(book_no);
		vo.setUser_no(user_no);
		new CartDao().insert(vo);
	}

}
