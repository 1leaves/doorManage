package com.yyq.doormanage1.service.impl;

import com.yyq.doormanage1.mapper.RecordMapper;
import com.yyq.doormanage1.mapper.UserMapper;
import com.yyq.doormanage1.entity.Record;
import com.yyq.doormanage1.entity.Room;
import com.yyq.doormanage1.entity.User;
import com.yyq.doormanage1.freamwork.Result;
import com.yyq.doormanage1.freamwork.ResultSupport;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyq.doormanage1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private RecordMapper recordMapper;
    
    @Override
	public Result queryPage(Map<String, Object> params, Integer pageSize,Integer pageNum) {
		Result result = new ResultSupport();
		PageHelper.startPage(pageNum, pageSize);
		List<User> list = userMapper.queryByParams(params);
		PageInfo<User> info = new PageInfo<>(list);
		result.setModel("pageInfo", info);
		return result;
	}

	@Override
	public Result login(String account, String password) {
		Result result = new ResultSupport();
		User user = userMapper.login(account, password);
		if(null != user && null != user.getId()){
			result.setModel("user", user);
		}else{
			result.setError("400", "账号或密码错误");
		}
		return result;
	}

	@Override
	public Result regist(User user) {
		Result result = new ResultSupport();
		user.setStatus(3);
		user.setType(2);
		int i = userMapper.save(user);
		if(i != 1){
			result.setError("400", "注册异常");
		}
		return result;
	}

	@Override
	public Result save(User user) {
		Result result = new ResultSupport();
		user.setStatus(3);
		user.setType(2);
		user.setToken(UUID.randomUUID().toString().replace("-", ""));
		user.setWechatId("or8gM5PmsW5lkFHkvqLhw5hwFxRo");
		int i = userMapper.save(user);
		if(i == 1){
			List<Room> list = user.getList();
			for (Room room : list) {
				Record record = new Record();
				record.setRoomId(room.getId());
				record.setUserId(user.getId());
				recordMapper.save(record);
			}
		}else{
			result.setError("400", "保存异常");
		}
		return result;
	}

	@Override
	public Result queryByWechatId(String wechatId) {
		Result result = new ResultSupport();
		try {
			User user = userMapper.queryByWechatId(wechatId);
			if(null != user && null != user.getId()){
				result.setModel("user", user);
			}else{
				result.setError("401", "该账号未注册");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
