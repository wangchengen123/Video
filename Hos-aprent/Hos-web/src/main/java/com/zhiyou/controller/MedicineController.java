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
import com.zhiyou.model.Drug;
import com.zhiyou.service.MedicineService;

@Controller
@RequestMapping("/medicine")
public class MedicineController {

	@Autowired
	private MedicineService drugService;
	
	@RequestMapping("/list")
	public String findAll(@RequestParam(value="pageNum",defaultValue="1")int pageNum,String drugName,Model model) {
		PageHelper.startPage(pageNum,1);// 当前页
		List<Drug> lists = drugService.findAll(drugName);
		model.addAttribute("drugName", drugName);

		
		
		PageInfo<Drug> pageInfo = new PageInfo<>(lists);
		
		model.addAttribute("total", pageInfo.getTotal()); // 总条数
	//	System.out.println("总条数:"+pageInfo.getTotal());
		model.addAttribute("pageNum",pageNum);// 当前页
		model.addAttribute("pages",pageInfo.getPages() ); // 总页数
		
		model.addAttribute("lists", lists);
		return "/medicine/index";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAddUI() {
		return "/medicine/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addDrug(Drug drug) {
		
		drugService.addDrug(drug);
		
		return "forward:/medicine/list";
	}
	
	// 查询
	@RequestMapping("/select")
	public String selDrug(String id,Model model) {
		
		Drug drug = drugService.selDrug(id);
		System.out.println("查drug:"+drug);
		model.addAttribute("drug", drug);
		return "/medicine/edit";
	}
	
	// 查看
	@RequestMapping("/sele")
	public String seleDrug(String id,Model model) {
		
		Drug drug = drugService.selDrug(id);
		System.out.println("查drug:"+drug);
		model.addAttribute("drug", drug);
		return "/medicine/look";
	}
	
	@RequestMapping("update")
	public String upDrug(Drug drug) {
		System.out.println(drug);
		drugService.upDrug(drug);
		
		return "forward:/medicine/list";
	}
	
	
	
	
	
	
}
