package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.OrderInfoDao;
import com.douzone.bookmall.vo.OrderInfoVo;


public class OrderInfoTest {
	public static void main(String[] args) {

		insertTest(133,"dkf",1);
		getListTest();
		
	}
	public static void getListTest() {
		List<OrderInfoVo> list = new OrderInfoDao().getList();
		for(OrderInfoVo vo : list){
			System.out.println(vo);
		}
	}
	public static void insertTest(long payment,String shipping,long user_no) {
		OrderInfoVo vo = new OrderInfoVo();
		vo.setPayment(payment);
		vo.setShipping(shipping);
		vo.setUser_no(user_no);
		new OrderInfoDao().insert(vo);
	}
}
