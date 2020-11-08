package com.bookstore.client.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.dao.RecordDao;
import com.bookstore.dao.ShopDao;
import com.bookstore.dao.UserDao;
import com.bookstore.po.User;
import com.bookstore.vo.ResultVo;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private RecordDao recordDao;
	
	@RequestMapping("update")
	public ResultVo update(User user, HttpServletRequest request) {
		User ouser = (User) request.getSession().getAttribute("user");
		user.setId(ouser.getId());
		int update = userDao.update(user);
		if (update > 0) {
			request.getSession().removeAttribute("user");
			return new ResultVo(200, "修改成功");
		}
		return new ResultVo(400, "修改失败");
	}
	
	@RequestMapping("layout")
	public ResultVo layout(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		int userId = user.getId();
		int i = shopDao.deleteShopByUserId(userId);
		int delete = userDao.delete(userId);
		recordDao.deleteRecordByUserId(userId);
		System.out.println(delete + "---" + i);
		if (delete > 0 || i > 0) {
			request.getSession().removeAttribute("user");
			return new ResultVo(200, "注销成功");
		}
		return new ResultVo(200, "注销失败");
	}
	
}
