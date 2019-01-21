package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.UserDao;
import com.douzone.bookmall.vo.UserVo;


public class UserTest {
	public static void main(String[] args) {

		insertTest("a","111-111-111","13@zs,fd","1211");
		getListTest();
		
	}
	public static void getListTest() {
		List<UserVo> list = new UserDao().getList();
		for(UserVo vo : list){
			System.out.println(vo);
		}
	}
	public static void insertTest(String name, String number, String email, String password) {
		UserVo vo = new UserVo();
		vo.setName(name);
		vo.setNumber(number);;
		vo.setEmail(email);;
		vo.setPassword(password);;
		
		new UserDao().insert(vo);
	}
}
