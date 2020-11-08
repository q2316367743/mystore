package com.bookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bookstore.po.Commodity;

public interface CommodityDao {
	
	List<Commodity> queryAllCommodity();
	Commodity queryCommodityByID(int id);
	List<Commodity> queryCommodityByCategory(String category);
	List<Commodity> queryCommodityByName(String name);
	List<Commodity> queryCommodityByNameAndPrice(@Param("name")String name, @Param("min")int min, @Param("max")int max);
	int saveCommodity(Commodity commodity);
	int deleteCommodityById(int id);

}
