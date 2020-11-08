package com.bookstore.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.CommodityDao;
import com.bookstore.dao.RecordDao;
import com.bookstore.dao.ShopDao;
import com.bookstore.po.Category;
import com.bookstore.po.Commodity;
import com.bookstore.po.User;

@Controller
public class IndexController {
	
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private RecordDao recordDao;
	
	@RequestMapping("")
	public String welcome(Model model) {
		List<Commodity> commodities = commodityDao.queryAllCommodity();
		model.addAttribute("commodities", commodities);
		return "client/index";
	}
	
	@GetMapping("index")
	public String index(Model model) {
		List<Commodity> commodities = commodityDao.queryAllCommodity();
		model.addAttribute("commodities", commodities);
		return "client/index";
	}
	
	@GetMapping("my")
	public String my(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		List<Commodity> commodities = shopDao.queryAllShopByUserId(user.getId());
		List<Commodity> records = recordDao.queryAllRecordByUserId(user.getId());
		model.addAttribute("user", user);
		model.addAttribute("commodities", commodities);
		model.addAttribute("records", records);
		return "client/my";
	}
	
	@GetMapping("category/{category}")
	public String category(@PathVariable("category") String category, Model model) {
		List<Category> categories = categoryDao.queryAllCategory();
		model.addAttribute("categories", categories);
		if (category.equals("default")) {
			category = "日用";
		}
		List<Commodity> commodities = commodityDao.queryCommodityByCategory(category);
		model.addAttribute("commodities", commodities);
		return "client/category";
	}
	
	@GetMapping("search")
	public String search(@RequestParam(value = "name", required = false)String name,
			@RequestParam(value = "min", required = false)Integer min, 
			@RequestParam(value = "max", required = false)Integer max, 
			Model model) {
		if (name == null || name.equals("")) {
			model.addAttribute("commodities", null);
			return "client/search";
		}
		min = min == null ? 0 : min;
		max = max == null ? 0 : max;
		List<Commodity> commodities = commodityDao.queryCommodityByNameAndPrice(name, min, max);
		model.addAttribute("commodities", commodities);
		model.addAttribute("name", name);
		model.addAttribute("max", max);
		model.addAttribute("min", min);
		return "client/search";
	}
	
	@GetMapping("pay")
	public String pay() {
		return "client/pay";
	}

}
