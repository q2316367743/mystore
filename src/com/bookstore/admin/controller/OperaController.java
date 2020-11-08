package com.bookstore.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.CommodityDao;
import com.bookstore.dao.UserDao;
import com.bookstore.po.Commodity;
import com.bookstore.vo.ResultVo;

@RestController
@RequestMapping("admin/opera")
public class OperaController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping("user/delete")
	public ResultVo userDelete(int id) {
		int delete = userDao.delete(id);
		if (delete == 0) {
			return new ResultVo(400, "fail");
		}
		return new ResultVo(200, "success");
	}
	
	@RequestMapping("commodity/delete")
	public ResultVo commodityDelete(int id) {
		int delete = commodityDao.deleteCommodityById(id);
		if (delete == 0) {
			return new ResultVo(400, "fail");
		}
		return new ResultVo(200, "success");
	}
	
	@RequestMapping("commodity/new")
	public ResultVo commodityNew(Commodity commodity) {
		int saveCommodity = commodityDao.saveCommodity(commodity);
		if (saveCommodity> 0) {
			return new ResultVo(200, "success");
		}else {
			return new ResultVo(400, "fail");
		}
	}
	
	@RequestMapping("category/new")
	public ResultVo categoryNew(String name) {
		int saceCategory = categoryDao.saveCategory(name);
		if (saceCategory> 0) {
			return new ResultVo(200, "success");
		}else {
			return new ResultVo(400, "fail");
		}
	}
	
}
