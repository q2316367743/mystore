package com.bookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bookstore.po.User;

public interface UserDao {
	
	User login(User user);
	int register(User user);
	int update(User user);
	int delete(int id);
	int queryMoneyById(int id);
	int updateMoneyById(@Param("id")int id, @Param("money")int money);
	List<User> queryAllUser();

}
