package com.yyq.doormanage1.service;

import com.yyq.doormanage1.entity.Room;
import com.yyq.doormanage1.freamwork.Result;

import java.util.Map;

public interface RoomService {

	Result queryPage(Map<String, Object> params, Integer pageSize, Integer pageNum);
	
	Result save(Room room);
	
	Result queryById(Integer id);
	
	Result update(Room room);
	
	Result queryAll();
	
	Result delete(Integer id);
	
	Result open(String token,String roomCode);
}
