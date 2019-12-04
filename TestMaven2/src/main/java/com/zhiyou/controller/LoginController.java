package com.zhiyou.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.User;
import com.zhiyou.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("login.do")
	public String login(String username,String password,Model model) {
		
		
		// 登录成功,跳转至另一个Controller
		if(username.equals("admin")&&password.equals("123456")) {
			
		return "forward:/user/list";
		}
		return "redirect:index.jsp";
		
	}
	

}
