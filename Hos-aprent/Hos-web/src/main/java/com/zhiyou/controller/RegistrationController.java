package com.zhiyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou.model.RegistrationInfor;
import com.zhiyou.service.RegisService;


@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private RegisService regisService;
	
	@RequestMapping("/list")
	public String findAll(Model model) {
		System.out.println("进来了");
		List<RegistrationInfor> lists = regisService.findAll();
		model.addAttribute("lists", lists);
		System.out.println("查到了");
		return "forward:/WEB-INF/registration/index.jsp";
	}

	@RequestMapping("/delete")
	public String delRegis(String id,Model model) {
		
		regisService.delRegis(id);
		
		return "forward:/registration/list";
	}
	
	@RequestMapping("/select")
	public String selRegis(int id,Model model) {
		System.out.println("id:"+id);
		RegistrationInfor regis = regisService.selRegis(id);
		model.addAttribute("regis", regis);
		System.out.println("查:"+regis.toString());
		
		return "/registration/edit";
	}
	
	@RequestMapping("/sele")
	public String seleRegis(int id,Model model) {
	//	System.out.println("id:"+id);
		RegistrationInfor regis = regisService.selRegis(id);
		model.addAttribute("regis", regis);
	//	System.out.println("查:"+regis.toString());
		
		return "/registration/look";
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String toAddUI() {
		return "/registration/add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String addRegis(RegistrationInfor regis) {
		System.out.println("添加:"+regis);
		regisService.addRegis(regis);
		
		return "forward:/registration/list";
	}
	
	
	@RequestMapping("/update")
	public String upRegis(int id,Model model) {
		System.out.println("改");
		boolean b = regisService.upRegis(id);
		if(b) {
			
			return "forward:/registration/list";
		}
		return "/registration/edit";
	}
	
	
}
