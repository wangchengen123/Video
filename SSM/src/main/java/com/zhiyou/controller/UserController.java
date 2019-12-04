package com.zhiyou.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	
	//模糊查询
/*	@RequestMapping("selectByName")
	public String selectByName(String name,HttpServletRequest req,HttpServletResponse rep) {
		System.out.println("进来了1");
		req.setAttribute("list", service.selectByName(name));
		System.out.println("进来了2");
		System.out.println("1"+service.selectByName(name));
		return "show";
	}*/
	
	
	@RequestMapping("show")
	public String show(HttpServletRequest req,HttpServletResponse rep,String truename) {
	//	System.out.println("进来了1"+truename);
		Map<String,Object> map = new HashMap<>();
		map.put("truename", truename);
		req.setAttribute("list",service.selectAll(map));
	//	System.out.println("进来了2");
		return "show";
	}
	
	@RequestMapping("add")
	public String add(User user,HttpServletRequest req,HttpServletResponse rep) {
		service.add(user);
		return "redirect:show";
	}
	
	@RequestMapping("delete")
	public String add(int id,HttpServletRequest req,HttpServletResponse rep) {
		service.delete(id);
		return "redirect:show";
	}
	
	@RequestMapping("selectByID")
	public String selectByID(int id,HttpServletRequest req,HttpServletResponse rep) {
		req.setAttribute("user", service.selectByID(id));
		return "update";
	}
	
	@RequestMapping("update")
	public String update(User user,HttpServletRequest req,HttpServletResponse rep) {
		service.update(user);
		return "redirect:show";
	}
	
	
}
