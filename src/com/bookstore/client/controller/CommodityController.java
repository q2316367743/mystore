package com.bookstore.client.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookstore.dao.CommodityDao;
import com.bookstore.dao.RecordDao;
import com.bookstore.dao.ShopDao;
import com.bookstore.dao.UserDao;
import com.bookstore.po.Commodity;
import com.bookstore.po.Record;
import com.bookstore.po.Shop;
import com.bookstore.po.User;
import com.bookstore.vo.ResultVo;

@Controller
@RequestMapping("commodity")
public class CommodityController {
	
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	public UserDao userDao;
	@Autowired
	private RecordDao recordDao;

	@RequestMapping("addShop")
	@ResponseBody
	public ResultVo addShop(int id, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			int result = shopDao.saveShop(new Shop(user.getId(), id));
			if (result > 0) {
				return new ResultVo(200, "加入购物车成功");
			}else {
				return new ResultVo(400, "加入购物车失败");
			}
		}else {
			return new ResultVo(404, "未登录，请登录再试");
		}
	}
	
	@RequestMapping("info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		Commodity commodity = commodityDao.queryCommodityByID(id);
		if (commodity == null) {
			return "redirect:index";
		}
		model.addAttribute("commodity", commodity);
		return "client/info";
	}
	
	@RequestMapping("pay")
	public String pay(int id, Model model, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			Commodity commodity = commodityDao.queryCommodityByID(id);
			if (commodity == null) {
				return "redirect:../index";
			}
			model.addAttribute("commodity", commodity);
			return "client/pay";
		}else {
			return "redirect:../login.jsp";
		}
	}
	
	@RequestMapping("buy")
	@ResponseBody
	public ResultVo buy(int id, HttpServletRequest request) {
		//判断余额是否够
		User user = (User) request.getSession().getAttribute("user");
		int userId = user.getId();
		int money = user.getMoney();
		Commodity commodity = commodityDao.queryCommodityByID(id);
		int commodityId = commodity.getId();
		int price = commodity.getPrice();
		int residue = money - price;
		if (residue > 0) {
			//1. 修改余额
			userDao.updateMoneyById(userId, residue);
			//2. 删除购物车中的信息
			shopDao.deleteShopByUIACI(commodityId, userId);
			//3. 增加到记录表中
			recordDao.saveRecord(new Record(userId, commodityId));
			user.setMoney(residue);
			request.getSession().setAttribute("user", user);
			return new ResultVo(200, "购买成功");
		}else {
			return new ResultVo(400, "购买失败，余额不足");
		}
	}
	
}
