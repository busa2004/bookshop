package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;


public class BookTest {
	public static void main(String[] args) {

		insertTest("abc",111,1);
		getListTest();
		
	}
	public static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		for(BookVo vo : list){
			System.out.println(vo);
		}
	}
	
	public static void insertTest(String name,long price, long category_no) {
		BookVo vo = new BookVo();
		vo.setName(name);
		vo.setPrice(price);
		vo.setCategory_no(category_no);
		new BookDao().insert(vo);
	}

}
