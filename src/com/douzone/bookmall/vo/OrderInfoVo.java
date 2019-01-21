package com.douzone.bookmall.vo;

public class OrderInfoVo {
	private long no;
	private long payment;
	private String shipping;
	private long user_no;
	private String user_name;
	private String user_email;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public long getPayment() {
		return payment;
	}
	public void setPayment(long payment) {
		this.payment = payment;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public long getUser_no() {
		return user_no;
	}
	public void setUser_no(long user_no) {
		this.user_no = user_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	@Override
	public String toString() {
		return "주문번호:"+no+ " 주문자 이름:"+user_name+ " 주문자 이메일:"+user_email+" 결제금액:"+payment+" 배송지:"+shipping; 
	}


	
	
}
