package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// 实现controller的接口
public class LoginController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		// 接收数据
		//封装数据
		//调用业务层
		//跳页面
		ModelAndView mv = new ModelAndView();
		// 向域中添加数据
		mv.addObject("springmvc","srpingmvc - value");
		// 设置跳转页面
		// 因为设置成了绝对的物理路径,所以不经过springmvc的视图解析
		// 经过视图解析器去拼接前缀后缀
		mv.setViewName("/index.jsp");
		return mv;
	}

}
