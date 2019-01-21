package com.douzone.bookmall.vo;

public class BookVo {
	private long no;
	private String name;
	private long price;
	private long category_no;
	
	

	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(long category_no) {
		this.category_no = category_no;
	}
	@Override
	public String toString() {
		return "제목:" + name + " 가격:" + price;
	}


	
}
