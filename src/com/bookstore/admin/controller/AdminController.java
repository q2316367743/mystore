package com.bookstore.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.CommodityDao;
import com.bookstore.dao.UserDao;
import com.bookstore.po.Category;
import com.bookstore.po.Commodity;
import com.bookstore.po.User;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping("")
	public String welcome() {
		return "admin/index";
	}

	@RequestMapping("index")
	public String index() {
		return "admin/index";
	}
	
	@RequestMapping("user")
	public String user(Model model) {
		List<User> users = userDao.queryAllUser();
		model.addAttribute("users", users);
		return "admin/user";
	}
	
	@RequestMapping("commodity")
	public String commodity(Model model) {
		List<Commodity> commodities = commodityDao.queryAllCommodity();
		model.addAttribute("commodities", commodities);
		return "admin/commodity";
	}
	
	@RequestMapping("new")
	public String news(Model model) {
		List<Category> categories = categoryDao.queryAllCategory();
		model.addAttribute("categories", categories);
		return "admin/new";
	}
	
}
