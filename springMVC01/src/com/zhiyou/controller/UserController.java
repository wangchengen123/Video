package com.zhiyou.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou.model.User;
/**
 * @author Administrator
 * 改用注解实现
 */
@Controller  //相当于实现了controller的接口,且配置文件会找到该类
//就不再在springmvc的配置文件中写<bean>
public class UserController {
	/*
	 * value:请求路径
	 * method:请求方法
	 *     RequestMethod.GET / POST
	 * 
	 * 不指定请求方法:可以接受任何方式的请求
	 * ---------------------------------------
	 * 方法是随意些的
	 * 返回值类型:String
	 * 		return"" ; 写的是逻辑视图名
	 * 方法名:见名知意
	 * 参数列表:根据需要添加参数
	 * 		以下参数可以默认使用
	 * 			HttpServletRequest
	 * 			HttpServletRespone
	 * 			HttpSession
	 * 			Model  --->Spring框架用于携带数据,可以理解请求域
	 * 返回值:
	 * 		字符串类型的逻辑视图名
	 */
	@RequestMapping(value="/user.do",method=RequestMethod.GET)
	public String findUser(Model model) {
		model.addAttribute("springmvc", "springmvc annotation");
		return "index";
	}
	/**
	 * 接收基本数据类型
	 * SpringMVC可以直接接收参数并封装/解析
	 *   将对应的数据解析为对应的数据类型
	 *     不再像Servlet那样,全部接收下来都是String
	 *  -------
	 *  只需要在Controller的方法参数列表中写对应的数据类型 参数名即可
	 *  	参数名 与 页面的input标签 的name属性一致
	 *  
	 * @RequestParam(defaultValue="") 注解,默认值
	 */
	@RequestMapping("/receiveBase.do")
	public String receiveBase(@RequestParam(defaultValue="")int id,double score,boolean result,String name) {
		System.out.println("id:"+id);
		System.out.println("score:"+score);
		System.out.println("result:"+result);
		System.out.println("name:"+name);
		return "index";
	}
	/*
	 * 封装对象
	 * 直接将对象写在参数列表中即可
	 * 页面的属性要与User类中的属性一致
	 */
	@RequestMapping("/receiveUser.do")
	public String receiveUser(User user) {
		System.out.println(user);
		return "index";
	}
	@RequestMapping("/receiveArray.do")
	public String receiveArray(int[] ids) {
		System.out.println(Arrays.toString(ids));
		return "index";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
