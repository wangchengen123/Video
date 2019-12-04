package com.zhiyou;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    
	//responseBody一般是作用在方法上的，加上该注解表示该方法的返回结果直接写到Http response Body中，常用在ajax异步请求中，
	//在RequestMapping中 return返回值默认解析为跳转路径，如果你此时想让Controller返回一个字符串或者对象到前台 就会报404 not response的错误。
	//当加上@ResponseBody注解后不会解析成跳转地址 会解析成相应的json格式的对象 集合 字符串或者xml等直接返回给前台 可以通过 ajax 的“success”：fucntion(data){} data直接获取到。
	@ResponseBody
	@RequestMapping("/hello")
	public String method() {
		return "hello";
	}
	
	public ModelAndView method1() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("aaa");
		
		return mv;
	}
}
