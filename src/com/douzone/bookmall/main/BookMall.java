package com.douzone.bookmall.main;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.dao.CategoryDao;
import com.douzone.bookmall.dao.OrderBookDao;
import com.douzone.bookmall.dao.OrderInfoDao;
import com.douzone.bookmall.dao.UserDao;

public class BookMall {
	public static void main(String[] args) {
		String[] table = {"cart","order_book","book","order_info","category","user"};
		BookDao book = new BookDao();
		CartDao cart = new CartDao();
		CategoryDao category = new CategoryDao();
		OrderBookDao ob = new OrderBookDao();
		OrderInfoDao oi = new OrderInfoDao();
		UserDao user = new UserDao(); 
		
		
		//	생성		
		user.insert("남영덕","111-1111-1111","aaa@aaaa.com","111111");
		user.insert("김감검","222-2222-2222","bbb@aaaa.com","222222");
		category.insert("수필");
		category.insert("소설");
		category.insert("시집");
		book.insert("개발자로 사는법",10000,1);	
		book.insert("돈 많이 벌고 싶어요",29000,2);	
		book.insert("돈돈돈",50000,3);	
		cart.insert(3,1,1);
		cart.insert(2,2,1);
		oi.insert(88000,"부산 남구",1);
		ob.insert(3,1,1);
		ob.insert(2,2,1);
		

		
		
		//회원 리스트 2명
		user.print();
		//카테고리 리스트 3개
		category.print();
		//상품리스트 3개
		book.print();
		//카트 리스트 2개
		cart.print();
		//주문 리스트 1개
		oi.print();
		//주문 도서 리스트 2개
		ob.print();
		
		
		
		// 삭제	
		for(String str : table) {
		book.delete(str);
		book.init(str);
		}

		
	}
	
	
}
