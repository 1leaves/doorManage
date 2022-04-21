package com.yyq.doormanage1.service.impl;

import com.yyq.doormanage1.mapper.RecordMapper;
import com.yyq.doormanage1.mapper.RoomMapper;
import com.yyq.doormanage1.entity.Room;
import com.yyq.doormanage1.freamwork.Result;
import com.yyq.doormanage1.freamwork.ResultSupport;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyq.doormanage1.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomMapper roomMapper;
	
	@Autowired
	private RecordMapper recordMapper;
	
	@Override
	public Result queryPage(Map<String, Object> params, Integer pageSize,Integer pageNum) {
		Result result = new ResultSupport();
		PageHelper.startPage(pageNum, pageSize);
		List<Room> list = roomMapper.queryByParams(params);
		PageInfo<Room> info = new PageInfo<>(list);
		result.setModel("pageInfo", info);
		return result;
	}

	@Override
	public Result save(Room room) {
		Result result = new ResultSupport();
		try {
			int i = roomMapper.save(room);
			if(i != 1){
				result.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result queryById(Integer id) {
		Result result = new ResultSupport();
		Room room = roomMapper.queryById(id);
		result.setModel("entity", room);
		return result;
	}
	
	@Override
	public Result update(Room room) {
		Result result = new ResultSupport();
		try {
			int i = roomMapper.update(room);
			if(i != 1){
				result.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result queryAll() {
		Result result = new ResultSupport();
		List<Room> list = roomMapper.queryAll();
		result.setModel("list", list);
		return result;
	}

	@Override
	public Result delete(Integer id) {
		Result result = new ResultSupport();
		try {
			int i = roomMapper.delete(id);
			if(i != 1){
				result.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Result open(String token, String roomCode) {
		Result result = new ResultSupport();
		try {
			int i = recordMapper.open(roomCode, token);
			if(i != 1){
				result.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}

