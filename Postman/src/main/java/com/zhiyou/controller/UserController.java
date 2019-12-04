package com.zhiyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.model.User;
import com.zhiyou.util.ResultObject;

/**
 * 
 * @author Administrator
 * 	演示前后端分离开发:
 * 	后端Restful风格的代码
 * 	以及使用postman测试接口
 */
@RestController  //该类中所有方法都返回json数据,每个发发发不用再去写 @RestController
public class UserController { 
	@Autowired
	private UserMapper mapper;
	
	/**
	 * 查询全部
	 * get /user/get 参数无  返回值ResultObject:{"code":"200/404/500...","msg":"提示信息","data":"数据"}
	 */
	@RequestMapping(value="/user/get",method=RequestMethod.GET)
	public ResultObject getAll() {
		List<User> users = mapper.getAll();
		System.out.println("getAll:"+users);
		if(users == null || users.size() == 0) {
			return new ResultObject(201,"没有数据!",null);
		}
		return new ResultObject(200,"成功",users);
	}
	
	/**
	 * 查询一个
	 * get  /user/get/{id} 参数 int id  返回值
	 */
	@RequestMapping(value="/user/get/{id}",method=RequestMethod.GET)
	public ResultObject getUserById(@PathVariable int id) {
		System.out.println("getUserById:"+id);
		User user = mapper.getUserById(id);
		/*
		 * 对 对象的判断
		 */
		System.out.println("getUserById user:"+user);
		return new ResultObject(200,"成功",user);
	}
	
	/**
	 * 添加用户
	 * post /user/add   返回值
	 * 参数User user 
	 * 		前端以form表单发送postman测试需要使用formdata形式发送
	 * 		ajax默认形式postman:X-www-form-rulencoded
	 * 		ajax发送json数据:postman : row -> json
	 * 			而且: 如果前台发送的json数据,后台要封装进对象,需要使用
	 * 			@RequestBody 解析JSON数据,才能封装进对象
	 * 演示:
	 * 		前端发送json格式数据
	 */
	@RequestMapping(value="/user/add",method=RequestMethod.POST)
	public ResultObject addUser(@RequestBody User user) {
		System.out.println("addUser User:"+user);
		int row = 0;
		try {
			row = mapper.addUser(user);
			
		}catch(Exception e){
			System.out.println("添加异常");
			row = -1;
		}
		if(row > 0) {
			return new ResultObject(200,"成功",null);
		}
		return new ResultObject(404,"失败",user);
		
	}
	
	/**
	 * 
	 * 删除一个
	 * delete /user/delete/{id} 参数int id 返回值
	 */
	@RequestMapping(value="/user/delete/{id}",method=RequestMethod.DELETE)
	public ResultObject deleteUserById(@PathVariable int id) {
		System.out.println("deleteUserById:"+id);
		int row = mapper.deleteUserById(id);
		/*
		 * 对 对象的判断
		 */
		if(row > 0) {
			return new ResultObject(200,"删除成功",null);
		}else {
			return new ResultObject(201,"没有该用户",null);
		}
	}
	
	/**
	 * 
	 * 根据id更新用户
	 * put /user/update 参数json数据 
	 */
	@RequestMapping(value="/user/update",method=RequestMethod.PUT)
	public ResultObject updateUserById(@RequestBody User user) {
		System.out.println("updateUserById:"+user);
		int row = mapper.updateUserById(user);
		/*
		 * 对 对象的判断
		 */
		if(row > 0) {
			return new ResultObject(200,"修改成功",null);
		}else {
			return new ResultObject(201,"没有该用户",null);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
