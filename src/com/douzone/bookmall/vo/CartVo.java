package com.douzone.bookmall.vo;

public class CartVo {
	private long count;
	private long book_no;
	private long user_no;
	private String book_name;
	private long book_price;
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public long getBook_no() {
		return book_no;
	}
	public void setBook_no(long book_no) {
		this.book_no = book_no;
	}
	public long getUser_no() {
		return user_no;
	}
	public void setUser_no(long user_no) {
		this.user_no = user_no;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public long getBook_price() {
		return book_price;
	}
	public void setBook_price(long book_price) {
		this.book_price = book_price;
	}
	@Override
	public String toString() {
		return "도서 제목:"+book_name+" 수량:"+count+" 가격:"+book_price;
	}


	
	
}
