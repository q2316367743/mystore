package com.bookstore.dao;

import java.util.List;

import com.bookstore.po.Category;

public interface CategoryDao {
	
	List<Category> queryAllCategory();
	int saveCategory(String name);

}
