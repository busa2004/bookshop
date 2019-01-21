package com.douzone.bookmall.vo;

public class OrderBookVo {
	private long count;
	private long book_no;
	private long order_no;
	private String book_name;
	
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
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
	public long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(long order_no) {
		this.order_no = order_no;
	}
	@Override
	public String toString() {
		return "도서번호:"+book_no +" 도서제목:"+book_name +" 수량:"+count;
	}

	
	
}
