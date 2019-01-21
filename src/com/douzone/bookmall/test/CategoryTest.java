package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.CategoryDao;
import com.douzone.bookmall.vo.CategoryVo;


public class CategoryTest {
	public static void main(String[] args) {

		insertTest("비문학학");
		
		getListTest();
		
	}
	public static void getListTest() {
		List<CategoryVo> list = new CategoryDao().getList();
		for(CategoryVo vo : list){
			System.out.println(vo);
		}
	}
	
	public static void insertTest(String name) {
		CategoryVo vo = new CategoryVo();
		vo.setName(name);
		new CategoryDao().insert(vo);
	}

}
