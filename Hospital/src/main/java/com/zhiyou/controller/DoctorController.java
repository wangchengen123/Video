package com.zhiyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhiyou.model.Doctor;
import com.zhiyou.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	
	@RequestMapping("/list")
	public String findAll(Model model) {
		System.out.println("进来了");
		List<Doctor> lists  = doctorService.findAll();
		model.addAttribute("lists",lists);
		System.out.println("查到了");
		return "doctor/index";
	}
	
	@RequestMapping("/select")
	public String selDoctor(int id,Model model) {
		Doctor doctor = doctorService.selDoctor(id);
		System.out.println("查:"+doctor.toString());
		model.addAttribute("doctor", doctor);
		return "doctor/edit";
	}
	
	@RequestMapping("/sele")
	public String seleDoctor(int id,Model model) {
		Doctor doctor = doctorService.selDoctor(id);
	//	System.out.println("查:"+doctor.toString());
		model.addAttribute("doctor", doctor);
		return "doctor/look";
	}
	// 只用于跳转界面
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAddUI() {
		return "doctor/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addDoctor(Doctor doctor) {
		System.out.println(doctor);
		boolean b = doctorService.addDoctor(doctor);
		if(b) {
			return "forward:/doctor/list";
			
		}
		return "doctor/add";
	}
	
	@RequestMapping("/update")
	public String upDoctor(Doctor doctor) {
		
		doctorService.upDoctor(doctor);
		
		return "forward:/doctor/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
