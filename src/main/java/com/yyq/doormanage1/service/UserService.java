package com.yyq.doormanage1.service;

import com.yyq.doormanage1.entity.User;
import com.yyq.doormanage1.freamwork.Result;

import java.util.Map;

public interface UserService {

    Result queryPage(Map<String, Object> params, Integer pageSize, Integer pageNum);

    User queryById(Integer id);

    Result login(String account,String password);
    
    Result regist(User user);
    
    Result save(User user);
    
    Result queryByWechatId(String wechatId);

    int update(User user);

    Result apply(Integer userId, Integer roomId);
}

