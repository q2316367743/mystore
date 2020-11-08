package com.bookstore.po;

/**
 * 购物车
 * */
public class Record {

	private int id;
	private int userId;
	private int commodityId;
	public Record(int userId, int commodityId) {
		super();
		this.userId = userId;
		this.commodityId = commodityId;
	}
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	
	
}
