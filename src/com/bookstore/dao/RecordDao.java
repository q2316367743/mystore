package com.bookstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bookstore.po.Commodity;
import com.bookstore.po.Record;

public interface RecordDao {
	
	List<Commodity> queryAllRecordByUserId(int id);
	int saveRecord(Record record);
	int deleteRecordByUserId(int userId);
	int recordExist(@Param("commodityId")int commodityId, @Param("userId")int userId);

}
