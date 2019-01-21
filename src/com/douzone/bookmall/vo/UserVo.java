package com.douzone.bookmall.vo;

public class UserVo {
	private long no;
	private String name;
	private String number;
	private String email;
	private String password;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "이름:"+name+" 전화번호:"+number+" 이메일:"+email + " 비밀번호:"+password;
	}
	
	
	
}
