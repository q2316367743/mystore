package com.bookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bookstore.po.Commodity;
import com.bookstore.po.Shop;

public interface ShopDao {
	
	List<Commodity> queryAllShopByUserId(int id);
	int saveShop(Shop shop);
	int deleteShopByUserId(int userId);
	int deleteShopByUIACI(@Param("commodityId")int commodityId, @Param("userId")int userId);

}
