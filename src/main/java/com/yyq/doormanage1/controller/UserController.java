package com.yyq.doormanage1.controller;

import com.yyq.doormanage1.entity.User;
import com.yyq.doormanage1.freamwork.Result;
import com.yyq.doormanage1.freamwork.ResultSupport;
import com.google.gson.Gson;
import com.yyq.doormanage1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/doorManage/user")
public class UserController {

	private static final String APPID = "wxce6eec5dd7a6c097";
	private static final String SECRET = "cc5173d0b6ebedae4a936a50e9a441e7";
	int i = 10;
	@Autowired
	private UserService userService;

	/**
	 * 列表
	 */
	@RequestMapping("/queryPage")
	@ResponseBody
	public Result list(@RequestParam Map<String, Object> params, @RequestParam("pageSize") Integer pageSize,
                       @RequestParam("pageNum") Integer pageNum) {
		Result result = userService.queryPage(params, pageSize, pageNum);
		return result;
	}

	@RequestMapping("/queryById")
	@ResponseBody
	public Result queryById(@RequestParam Integer id) {
		Result result = new ResultSupport();
		User user = userService.queryById(id);
		result.setModel("entity", user);
		return result;
	}

	/**
	 * 登录
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Result login(@RequestParam("account") String account, @RequestParam("password") String password) {
		Result result = userService.login(account, password);
		return result;
	}

	@RequestMapping("/regist")
	@ResponseBody
	public Result regist(@RequestBody User user) {
		Result result = userService.regist(user);
		return result;
	}

	@RequestMapping("/{location}")
	public String location(@PathVariable String location) {
		return location;
	}

	@RequestMapping("/save")
	@ResponseBody
	public Result save(@RequestParam("account") String account, @RequestParam("username") String username,
                       @RequestParam("wechat_id") String wechat_id) {
		User user = new User();
		user.setAccount(account);
		user.setUsername(username);
		return userService.save(user);
	}

	/** 审核 */
	@RequestMapping("/auth/{status}")
	@ResponseBody
	public Result auth(@PathVariable Integer status,@RequestParam("id") Integer id) {
		Result result = new ResultSupport();
		User user = userService.queryById(id);
		user.setStatus(status);
		userService.update(user);
		result.setModel("user",user);
		return result;
	}

	/** 修改个人信息 */
	@RequestMapping("/update")
	@ResponseBody
	public Result update(@RequestBody User user) {
		Result result = new ResultSupport();
		userService.update(user);
		User new_user = userService.queryById(user.getId());
		result.setModel("user",new_user);
		return result;
	}

	/** 申请门禁权限 */
	@RequestMapping("/apply")
	@ResponseBody
	public Result apply(@RequestParam("userId") Integer userId,@RequestParam("roomId") Integer roomId) {
		return userService.apply(userId,roomId);
	}

	@RequestMapping("/queryByWechatId")
	@ResponseBody
	public Result queryByWechatId(@RequestParam("wechatId") String wechatId) {
		return userService.queryByWechatId(wechatId);
	}

	// 获取凭证校检接口
	@RequestMapping("/wxlogin")
	@ResponseBody
	public Result wxlogin(@RequestParam("code") String code) {
		Result result = new ResultSupport();
		// 微信的接口
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + SECRET + "&js_code="
				+ code + "&grant_type=authorization_code";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
			String sessionData = responseEntity.getBody();
			System.out.println(sessionData);
			Gson gson = new Gson();

			HashMap<String, String> map = gson.fromJson(sessionData, HashMap.class);

			String openid = map.get("openid");

			String session_key = map.get("session_key");

			result = userService.queryByWechatId(openid);
			result.setModel("openid", openid);
			result.setModel("session_key", session_key);
		} else {
			result.setError("400", "访问微信授权接口异常");
		}
		return result;
	}
	/*
	 * @RequestMapping("/getcode")
	 * 
	 * @ResponseBody public String getcode() { i++; String code =
	 * "vgdecoderesult=1&&token=123&&time=100000000000&&devicenumber=001&&otherparams="
	 * + i; return code; }
	 */
}
