package com.yyq.doormanage1.mapper;

import com.yyq.doormanage1.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface UserMapper {

	int save(User user);
	
	User login(@Param("account")String account, @Param("password")String password);
	
	List<User> queryByParams(@Param("params")Map<String,Object> params);
	
	User queryByWechatId(@Param("wechatId")String wechatId);
}
