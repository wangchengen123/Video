package com.zhiyou.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/index")
public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/index");
		/*
		 * /admin/list需要认证才能访问 
		 * 在此处进行Shiro实现认证
		 */
		
		
		// 一次请求,/suer/index已经放行,所以以下也会放行
		req.getRequestDispatcher("").forward(req, resp);
		resp.sendRedirect(req.getContextPath()+"/admin/list");
	}
}
