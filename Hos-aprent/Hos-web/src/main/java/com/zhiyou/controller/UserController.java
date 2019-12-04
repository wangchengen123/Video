package com.zhiyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public String findAll(@RequestParam(value="pageNum",defaultValue="1")int pageNum,String username,Model model) {
		// 登录成功,显示所有用户
		List<User> lists = userService.findAll(username);// 模糊查询   携带参数
		model.addAttribute("username", username);// 模糊查询
		
		
		PageHelper.startPage(pageNum,2);// 当前页
		PageInfo<User> pageInfo = new PageInfo<>(lists); 

		model.addAttribute("total",pageInfo.getTotal() );// 总条数
		model.addAttribute("pageNum",pageNum );// 当前页
		//int pages = (int) ((pageInfo.getTotal()%2==0)?(pageInfo.getTotal()/2):(pageInfo.getTotal()/2+1));
		model.addAttribute("pages",pageInfo.getPages());// 总页数
		
		
		model.addAttribute("lists",lists);
		
		return "forward:/WEB-INF/User/index.jsp";
	}
	
	
	// 只用于跳转页面
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAddUI() {
		return "User/addUser";
	}
	//添加
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addUser(User user,Model model) {
		boolean result = userService.addUser(user);
		if(result) {
			return "forward:/user/list";
		}
		return "User/addUser";
	}
	
	
	// 查询
	@RequestMapping("/select")
	public String seleUser(int id,Model model) {
		
		User user = userService.seleUser(id);
		model.addAttribute("user",user);
		System.out.println("查:"+user);
		return "User/editUser";
	}
	
	
	// 修改
	@RequestMapping("/update")
	public String upUser(User user,Model model) {
		
		System.out.println(user);
		System.out.println("改");
		boolean r = userService.upUser(user);
		if(r) {
			return "forward:/user/list";
		}
		return "User/editUser";
	}
	
	
	//删除
	@RequestMapping("/delete")
	public String delUser(int id,Model model) {
		userService.delUser(id);
		return "forward:/user/list";
	}
	
	
	
	
}
