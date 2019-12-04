package com.zhiyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public String findAll(Model model) {
		// 登录成功,显示所有用户
		List<User> lists = userService.findAll();
		model.addAttribute("lists",lists);
		return "list";
	}
	// 只用于跳转页面
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAddUI() {
		return "add";
	}
	//添加
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addUser(User user,Model model) {
		boolean result = userService.addUser(user);
		if(result) {
			return "forward:/user/list";
		}
		model.addAttribute("msg","添加失败,重新添加");
		return "add";
	}
	// 查询
	@RequestMapping("/select")
	public String seleUser(int id,Model model) {
		
		User user = userService.seleUser(id);
		model.addAttribute("user",user);
		System.out.println("查:"+user);
		return "update";
	}
	
	// 修改
	@RequestMapping("/update")
	public String upUser(User user,Model model) {
		
		System.out.println("改:"+user);
		boolean r = userService.upUser(user);
		if(r) {
			return "forward:/user/list";
		}
		model.addAttribute("msg", "修改失败,重新修改");
		return "update";
	}
	
	//删除
	@RequestMapping("/delete")
	public String delUser(int id,Model model) {
		userService.delUser(id);
		return "forward:/user/list";
	}
	
	
	
}
