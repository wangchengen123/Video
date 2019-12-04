package com.zhiyou.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
/*protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String accounts = req.getParameter("accounts")!=null?req.getParameter("username"):" ";
		String password = req.getParameter("password")!=null?req.getParameter("password"):" ";;
		
		User user = loginService.findUserByLogin(accounts,password);
		if (user!=null) {
			if (user.get.equals(password)) {
				req.setAttribute("user", user);
				req.getSession().setAttribute(SessionKey.USER_LOGIN,user);
				req.getRequestDispatcher("/admin.jsp").forward(req, resp);
				return;
			}else {
				System.out.println("ʧ��");
			}
		}else {
			System.out.println("���ɹ�?");	
			
		}
		req.getRequestDispatcher("/login.jsp").forward(req, resp);	
	
			
	}*/
	


	// 登录
	@RequestMapping("login.do")
	public String login(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String accounts = req.getParameter("accounts") != null ? req.getParameter("accounts") : "";
		String password = req.getParameter("password") != null ? req.getParameter("password") : "";
		System.out.println(accounts);
		System.out.println(password);
		
		User user = loginService.findUserByLogin(accounts,password);
		System.out.println("--user--" + user);
	
	
		if (user == null) {
			req.setAttribute("msg", "用户不存在");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else {
			
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("second.jsp");
			return null;
		}
		
		return "index";
		
	}


	
	
	
	
	
	
	/*
	@RequestMapping("login.do")
	public String login(String accounts,String password,Model model) {
		System.out.println("进来了");
		// 调用业务层方法,查询
		User user = loginService.findUserByLogin(accounts,password);
		// 判断
		System.out.println(user);
		System.out.println("进来了1");
		if(user != null) {
			// 登录成功,跳转至另一个Controller
			model.addAttribute("user", user);
			return "redirect:second.jsp";
		}else {
			model.addAttribute("msg", "账号或密码错误,请重新输入");
			return "forward:index.jsp";
		}
		
	}*/
	

}
