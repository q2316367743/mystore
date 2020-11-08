package com.bookstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.dao.AdminDao;
import com.bookstore.dao.UserDao;
import com.bookstore.po.User;

@Controller
public class ComonUserController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private AdminDao adminDao;

	@RequestMapping("login")
	public String login(User user, HttpServletRequest request) {
		User login = userDao.login(user);
		if (login != null) {
			request.getSession().setAttribute("user", login);
			return "redirect:index";
		}else {
			Integer login2 = adminDao.login(user);
			if (login2 != null && login2 > 0) {
				request.getSession().setAttribute("admin", user);
				return "redirect:admin/index";
			}
			return "redirect:login.jsp";
		}
	}
	
	@RequestMapping("register")
	public String register(User user, HttpServletRequest request) {
		int register = userDao.register(user);
		if (register > 0) {
			user = userDao.login(user);
			request.getSession().setAttribute("user", user);
			return "redirect:index";
		}else {
			return "redirect:register.jsp";
		}
		
	}
	
	@RequestMapping("exit")
	public String exit(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("admin");
		return "redirect:index";
	}
	
}
